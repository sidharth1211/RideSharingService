package com.javaproject.cabservice.model;

import jakarta.persistence.*;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private String id;
    @OneToOne
    @JoinColumn(name = "user")
    private User user;
    @OneToOne
    @JoinColumn(name = "cab")
    private Cab cab;
    private TripStatus status;
    private Double price;
    @OneToOne
    @JoinColumn(name = "from_point_id")
    private Location fromPoint;
    @OneToOne
    @JoinColumn(name = "to_point_id")
    private Location toPoint;

    public Trip() {
    }

    public Trip(User user, Cab cab, Double price, Location fromPoint, Location toPoint) {
        this.user = user;
        this.cab = cab;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.status = TripStatus.IN_PROGRESS;
    }

    public Location getToPoint() {
        return toPoint;
    }

    public void setToPoint(Location toPoint) {
        this.toPoint = toPoint;
    }

    public Location getFromPoint() {
        return fromPoint;
    }

    public void setFromPoint(Location fromPoint) {
        this.fromPoint = fromPoint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void endTrip(){
        this.status = TripStatus.FINISHED;
    }
}
