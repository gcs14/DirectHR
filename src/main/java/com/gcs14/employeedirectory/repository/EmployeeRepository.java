package com.gcs14.employeedirectory.repository;

import com.gcs14.employeedirectory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
