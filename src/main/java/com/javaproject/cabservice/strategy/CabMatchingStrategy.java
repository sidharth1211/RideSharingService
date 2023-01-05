package com.javaproject.cabservice.strategy;

import com.javaproject.cabservice.model.Cab;
import com.javaproject.cabservice.model.Location;
import com.javaproject.cabservice.model.User;

import java.util.List;

public interface CabMatchingStrategy {
    public Cab matchCabToRider(User user, List<Cab> closeByAvailableCabs, Location fromPoint, Location toPoint);
}
