package com.gcs14.employeedirectory.service;

import com.gcs14.employeedirectory.exception.EmployeeNotFoundException;
import com.gcs14.employeedirectory.model.Employee;
import com.gcs14.employeedirectory.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
    }

    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee newEmployee, Long id){
        return employeeRepository.findById(id)
                .map(employee->{
                    employee.setName(newEmployee.getName());
                    employee.setUsername(newEmployee.getUsername());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setPhoneNumber(newEmployee.getPhoneNumber());
                    employee.setBirthday(newEmployee.getBirthday());
                    employee.setPosition(newEmployee.getPosition());
                    employee.setJobType(newEmployee.getJobType());
                    employee.setSalary(newEmployee.getSalary());
                    employee.setHourlyWage(newEmployee.getHourlyWage());
                    employee.setHireDate(newEmployee.getHireDate());
                    return employeeRepository.save(employee);
                }).orElseThrow(()->new EmployeeNotFoundException(id));
    }
}
