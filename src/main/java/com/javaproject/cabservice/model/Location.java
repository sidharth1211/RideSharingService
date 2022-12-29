package com.javaproject.cabservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Location {
    @Id
    @GeneratedValue(generator="system-uuid")
    private String id;
    private Integer x;
    private Integer y;

    public Location() {
    }

    public Location(String id, Integer x, Integer y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double distance(Location location2) {
        return Math.sqrt( Math.pow(this.x - location2.x, 2) + Math.pow(this.y - location2.y, 2) );
    }
}
