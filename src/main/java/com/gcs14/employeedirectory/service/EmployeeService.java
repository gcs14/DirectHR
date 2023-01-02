package com.gcs14.employeedirectory.service;

import com.gcs14.employeedirectory.converter.EmployeeConverter;
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

    @Autowired
    EmployeeConverter converter;

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
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));

        if(newEmployee.getName()!= null){
            existingEmployee.setName(newEmployee.getName());
        }
        if(newEmployee.getUsername()!= null){
            existingEmployee.setUsername(newEmployee.getUsername());
        }
        if(newEmployee.getEmail()!= null){
            existingEmployee.setEmail(newEmployee.getEmail());
        }
        if(newEmployee.getPhoneNumber() != null){
            existingEmployee.setPhoneNumber(newEmployee.getPhoneNumber());
        }
        if(newEmployee.getPosition() != null){
            existingEmployee.setPosition(newEmployee.getPosition());
        }
        if(newEmployee.getJobType() != null){
            existingEmployee.setJobType(newEmployee.getJobType());
        }
        if(newEmployee.getSalary() != 0){
            existingEmployee.setSalary(newEmployee.getSalary());
        }
        if(newEmployee.getHourlyWage() != 0.0){
            existingEmployee.setHourlyWage(newEmployee.getHourlyWage());
        }
        return employeeRepository.save(existingEmployee);
    }


    // Code for if DTO implementation were needed
    /*
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> getAll = employeeRepository.findAll();
        return converter.entityToDto(getAll);
    }

    public EmployeeDTO getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
        return converter.entityToDto(employee);
    }

    public EmployeeDTO addNewEmployee(EmployeeDTO dto) {
        Employee employee = converter.dtoToEntity(dto);
        employee = employeeRepository.save(employee);
        return converter.entityToDto(employee);
    }

    public EmployeeDTO updateEmployee(@NotNull EmployeeDTO newEmployee, Long id){
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));

        if(newEmployee.getName()!= null){
            existingEmployee.setName(newEmployee.getName());
        }
        if(newEmployee.getUsername()!= null){
            existingEmployee.setUsername(newEmployee.getUsername());
        }
        if(newEmployee.getEmail()!= null){
            existingEmployee.setEmail(newEmployee.getEmail());
        }
        if(newEmployee.getPhoneNumber() != null){
            existingEmployee.setPhoneNumber(newEmployee.getPhoneNumber());
        }
        if(newEmployee.getPosition() != null){
            existingEmployee.setPosition(newEmployee.getPosition());
        }
        if(newEmployee.getJobType() != null){
            existingEmployee.setJobType(newEmployee.getJobType());
        }
        if(newEmployee.getSalary() != 0){
            existingEmployee.setSalary(newEmployee.getSalary());
        }
        if(newEmployee.getHourlyWage() != 0.0){
            existingEmployee.setHourlyWage(newEmployee.getHourlyWage());
        }

        existingEmployee = employeeRepository.save(existingEmployee);
        return converter.entityToDto(existingEmployee);
    }
*/
}
