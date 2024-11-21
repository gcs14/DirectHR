package com.gcs14.employeedirectory.repository;

import com.gcs14.employeedirectory.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
