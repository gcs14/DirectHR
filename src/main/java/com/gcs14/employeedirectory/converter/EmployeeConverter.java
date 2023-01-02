package com.gcs14.employeedirectory.converter;

import com.gcs14.employeedirectory.dto.EmployeeDTO;
import com.gcs14.employeedirectory.model.Employee;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/*
To be used when a DTO is implemented
 */

@Component
public class EmployeeConverter {

    public EmployeeDTO entityToDto(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setUsername(employee.getUsername());
        dto.setEmail(employee.getEmail());
        dto.setPhoneNumber(employee.getPhoneNumber());
        dto.setPosition(employee.getPosition());
        dto.setJobType(employee.getJobType());
        dto.setSalary(employee.getSalary());
        dto.setHourlyWage(employee.getHourlyWage());

        return dto;
    }

    public List<EmployeeDTO> entityToDto(List<Employee> employee){
        return employee.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Employee dtoToEntity(EmployeeDTO dto){
        Employee emp = new Employee();
        emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setUsername(dto.getUsername());
        emp.setEmail(dto.getEmail());
        emp.setPhoneNumber(dto.getPhoneNumber());
        emp.setPosition(dto.getPosition());
        emp.setJobType(dto.getJobType());
        emp.setSalary(dto.getSalary());
        emp.setHourlyWage(dto.getHourlyWage());

        return emp;
    }

    public List<Employee> dtoToEntity(List<EmployeeDTO> dto){
        return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
