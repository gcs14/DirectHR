package com.gcs14.employeedirectory.controller;

import com.gcs14.employeedirectory.model.Employee;
import com.gcs14.employeedirectory.model.Users;
import com.gcs14.employeedirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return service.register(user);
    }

    @GetMapping("/register")
    public List<Users> getEmployees() {
        return service.getUsers();
    }
}
