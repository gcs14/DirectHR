package com.gcs14.employeedirectory.controller;

import com.gcs14.employeedirectory.exception.EmployeeNotFoundException;
import com.gcs14.employeedirectory.model.Employee;
import com.gcs14.employeedirectory.repository.EmployeeRepository;
import com.gcs14.employeedirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@CrossOrigin("*")
@CrossOrigin("http://localhost:3000")
//@CrossOrigin("http://direct-hr.com/")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    @GetMapping("/employee/{id}")
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

    @DeleteMapping("/employee/{id}")
    String deleteEmployee(@PathVariable Long id){
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        String name = employeeRepository.findById(id).get().getName();
        employeeRepository.deleteById(id);
        return "The employee named '" + name + "' has been deleted.";
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
