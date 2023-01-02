package com.gcs14.employeedirectory.controller;

import com.gcs14.employeedirectory.model.Employee;
import com.gcs14.employeedirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/employee")
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }
    @PutMapping("/employee/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        employeeService.updateEmployee(employee, id);
    }

    // Code for if DTO implementation were needed
    /*
    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public EmployeeDTO addNewEmployee(@RequestBody EmployeeDTO dto) {
        return employeeService.addNewEmployee(dto);
    }

    @PutMapping("/employee/{id}")
    public void updateEmployee(@RequestBody EmployeeDTO updatedDto, @PathVariable Long id){
        employeeService.updateEmployee(updatedDto, id);
    }
     */
}
