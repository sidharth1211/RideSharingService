package com.javaproject.cabservice.service;

import com.javaproject.cabservice.model.Cab;
import com.javaproject.cabservice.model.Location;
import com.javaproject.cabservice.model.Trip;
import com.javaproject.cabservice.model.User;
import com.javaproject.cabservice.repository.TripRepository;
import com.javaproject.cabservice.strategy.CabMatchingStrategy;
import com.javaproject.cabservice.strategy.NoCabsAvailableException;
import com.javaproject.cabservice.strategy.PricingStrategy;
import io.micrometer.common.lang.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class TripService {
    private TripRepository tripRepository;
    private CabService cabsService;
    private UserService userService;

    private CabMatchingStrategy cabMatchingStrategy;

    private PricingStrategy pricingStrategy;


    public TripService(TripRepository tripRepository, CabService cabsService, UserService userService, CabMatchingStrategy cabMatchingStrategy, PricingStrategy pricingStrategy) {
        this.tripRepository = tripRepository;
        this.cabsService = cabsService;
        this.userService = userService;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public Trip createTrip(
            @NonNull final User user,
            @NonNull final Location fromPoint,
            @NonNull final Location toPoint) throws NoCabsAvailableException {
        final List<Cab> closeByCabs =
                cabsService.findCabs(fromPoint, Double.MAX_VALUE);
        final List<Cab> closeByAvailableCabs =
                closeByCabs.stream()
                        .filter(cab -> cab.getCurrentTrip() == null)
                        .collect(Collectors.toList());

        final Cab selectedCab =
                cabMatchingStrategy.matchCabToRider(user, closeByAvailableCabs, fromPoint, toPoint);
        if (selectedCab == null) {
            throw new NoCabsAvailableException();
        }
        final Double price = pricingStrategy.findPrice(fromPoint, toPoint);
        final Trip newTrip = new Trip(user, selectedCab, price, fromPoint, toPoint);
        selectedCab.setCurrentTrip(newTrip);
        return tripRepository.save(newTrip);


    }
    public List<Trip> tripHistory(@NonNull final User user) {
        return tripRepository.findByUser(user.getId());
    }

}
