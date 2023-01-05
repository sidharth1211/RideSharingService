package com.javaproject.cabservice.strategy;

import com.javaproject.cabservice.model.Location;

public interface PricingStrategy {
    public Double findPrice(Location fromPoint, Location toPoint);

}
