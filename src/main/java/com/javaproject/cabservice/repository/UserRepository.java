package com.javaproject.cabservice.repository;

import com.javaproject.cabservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *  Creation of User
 *  Storing User in a Database or a DataStructure
 *  functions for performing operations on User Model
 * */
@Repository
public interface UserRepository extends JpaRepository<User,String> {

}