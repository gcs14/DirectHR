package com.gcs14.employeedirectory.dto;

import lombok.Data;

/*
To be used when a DTO is needed to be implemented
 */
@Data
public class EmployeeDTO {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;
    private String position;
    private String jobType;
    private int salary;
    private double hourlyWage;
}
