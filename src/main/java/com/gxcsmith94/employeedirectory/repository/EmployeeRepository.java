package com.gxcsmith94.employeedirectory.repository;

import com.gxcsmith94.employeedirectory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
