package com.javaproject.cabservice.repository;

import com.javaproject.cabservice.model.Trip;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip,String> {
    List<Trip> findByUser(String id);
}
