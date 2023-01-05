package com.javaproject.cabservice.service;

import com.javaproject.cabservice.model.Cab;
import com.javaproject.cabservice.model.Location;
import com.javaproject.cabservice.repository.CabRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CabService {
    private CabRepository cabsRepository;

    public CabService(CabRepository cabsRepository) {
        this.cabsRepository = cabsRepository;
    }

    public Cab save(Cab cab){
        return cabsRepository.save(cab);
    }
    public Optional<Cab> findById(String id) {
        return cabsRepository.findById(id);
    }

    public List<Cab> findCabs(@NonNull final Location fromPoint, @NonNull Double distance){
        return cabsRepository.findAll()
                .stream()
                .filter(cab -> (cab.getAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance))
                .collect(Collectors.toList());
    }
}
