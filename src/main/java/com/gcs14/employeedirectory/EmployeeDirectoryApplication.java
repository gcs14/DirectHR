package com.gcs14.employeedirectory;

import com.gcs14.employeedirectory.model.Employee;
import com.gcs14.employeedirectory.repository.EmployeeRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class EmployeeDirectoryApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDirectoryApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			employeeRepository.save(new Employee(
					1L, "John Doyll", "jdoyll", "jdoyll@corpocorp.com",
					"5555555555", LocalDate.of(1983,1, 1), "Accountant",
					"full-time", 70000, 0, LocalDate.of(2022, 8, 1)));
			employeeRepository.save(new Employee(
					2L, "Cheryl Fenton", "cfenton", "cfenton@corpocorp.com",
					"7777777777", LocalDate.of(1991,9, 9), "Executive Assistant",
					"full-time", 82000, 0, LocalDate.of(2018, 4, 12)));
			employeeRepository.save(new Employee(
					3L, "Tiffany Richardson", "trichardson", "trichardson@corpocorp.com",
					"8888888888", LocalDate.of(2003,5, 23), "Intern",
					"part-time", 0, 20, LocalDate.of(2024, 6, 1)));
			employeeRepository.save(new Employee(
					4L, "David Smith", "dsmith", "dsmith@corpocorp.com",
					"9999999999", LocalDate.of(1991,9, 9), "Desktop Support",
					"full-time", 0, 26, LocalDate.of(2023, 3, 30)));
		};
	}
}
