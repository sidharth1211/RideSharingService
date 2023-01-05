package com.javaproject.cabservice.strategy;

import com.javaproject.cabservice.model.Cab;
import com.javaproject.cabservice.model.Location;
import com.javaproject.cabservice.model.User;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {
    @Override
    public Cab matchCabToRider(User user, List<Cab> closeByAvailableCabs, Location fromPoint, Location toPoint) {
        if(closeByAvailableCabs.isEmpty())
        return null;
        else return closeByAvailableCabs.get(0);
    }
}
