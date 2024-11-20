package com.gcs14.employeedirectory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;
    private LocalDate birthday;
    private String position;
    private String jobType;
    private int salary;
    private double hourlyWage;
    private LocalDate hireDate;

    public Employee() {

    }

    public Employee(Long id, String name, String username, String email, String phoneNumber, LocalDate birthday, String position, String jobType, int salary, double hourlyWage, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.position = position;
        this.jobType = jobType;
        this.salary = salary;
        this.hourlyWage = hourlyWage;
        this.hireDate = hireDate;
    }
}
