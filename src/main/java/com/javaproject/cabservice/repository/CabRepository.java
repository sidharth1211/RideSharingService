package com.javaproject.cabservice.repository;

import com.javaproject.cabservice.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabRepository extends JpaRepository<Cab,String> {
}
