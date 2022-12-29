package com.javaproject.cabservice.service;

import com.javaproject.cabservice.repository.UserRepository;
import com.javaproject.cabservice.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User save(User user){
        return userRepository.save(user);
    }

}