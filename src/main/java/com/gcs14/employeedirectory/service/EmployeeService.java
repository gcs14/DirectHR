package com.gcs14.employeedirectory.service;

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

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }

    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee newEmployee, Long id){
        Employee existingEmployee = employeeRepository.findById(id).get();

        if(newEmployee.getName()!= null && !newEmployee.getName().isEmpty()){
            existingEmployee.setName(newEmployee.getName());
        }
        if(newEmployee.getUsername()!= null && !newEmployee.getUsername().isEmpty()){
            existingEmployee.setUsername(newEmployee.getUsername());
        }
        if(newEmployee.getEmail()!= null && !newEmployee.getEmail().isEmpty()){
            existingEmployee.setEmail(newEmployee.getEmail());
        }
        if(newEmployee.getPhoneNumber() != null && !newEmployee.getPhoneNumber().isEmpty()){
            existingEmployee.setPhoneNumber(newEmployee.getPhoneNumber());
        }
        if(newEmployee.getPosition() != null && !newEmployee.getPosition().isEmpty()){
            existingEmployee.setPosition(newEmployee.getPosition());
        }
        if(newEmployee.getJobType() != null && !newEmployee.getJobType().isEmpty()){
            existingEmployee.setJobType(newEmployee.getJobType());
        }
        if(newEmployee.getSalary() != 0){
            existingEmployee.setSalary(newEmployee.getSalary());
        }
        if(newEmployee.getHourlyWage() != 0.0){
            existingEmployee.setHourlyWage(newEmployee.getHourlyWage());
        }
        if(newEmployee.getHireDate() != null && !newEmployee.getHireDate().toString().isEmpty()){
            existingEmployee.setHireDate(newEmployee.getHireDate());
        }
        employeeRepository.save(existingEmployee);
    }
}
