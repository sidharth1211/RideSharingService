package com.javaproject.cabservice.model;

import jakarta.persistence.*;

@Entity
public class Cab {
    @Id
    @GeneratedValue
    private String id;

    @OneToOne
    @JoinColumn(name = "current_location_id")
    private Location currentLocation;
    private Boolean isAvailable;
    @OneToOne
    @JoinColumn(name = "current_trip_id")
    private Trip currentTrip;

    public Cab() {
    }

    public Cab(String id, Boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }



    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }


    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
