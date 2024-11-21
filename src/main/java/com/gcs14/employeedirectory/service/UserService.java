package com.gcs14.employeedirectory.service;

import com.gcs14.employeedirectory.model.Employee;
import com.gcs14.employeedirectory.model.Users;
import com.gcs14.employeedirectory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public List<Users> getUsers() {
        return repo.findAll();
    }
}
