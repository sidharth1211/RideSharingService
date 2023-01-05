package com.javaproject.cabservice.strategy;

import com.javaproject.cabservice.model.Location;

public class DefaultPricingStrategy implements PricingStrategy{
    private static final Double PER_KM_RATE = Double.valueOf(10);

    @Override
    public Double findPrice(Location fromPoint, Location toPoint) {
        return fromPoint.distance(toPoint) * PER_KM_RATE;
    }
}
