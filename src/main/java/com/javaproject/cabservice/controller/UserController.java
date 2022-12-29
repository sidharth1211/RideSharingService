package com.javaproject.cabservice.controller;

import com.javaproject.cabservice.model.User;
import com.javaproject.cabservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }
    @PostMapping("/register/rider")
    public ResponseEntity<User> registerRider(@RequestBody User user ){
        User savedUser = userService.save(user);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
