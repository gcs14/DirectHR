package com.gcs14.employeedirectory;

import com.gcs14.employeedirectory.model.Employee;
import com.gcs14.employeedirectory.model.Users;
import com.gcs14.employeedirectory.repository.EmployeeRepository;
import com.gcs14.employeedirectory.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class EmployeeDirectoryApplication {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDirectoryApplication.class, args);
	}

	String adminPassword = "directhrdemo@123";
	String guestPassword = "123";

	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	String admin = encoder.encode(adminPassword);
	String guest = encoder.encode(guestPassword);

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			userRepository.save(new Users(1, "admin", admin));
			userRepository.save(new Users(2, "guest", guest));
			employeeRepository.save(new Employee(
					1L, "John Doyll", "jdoyll@corpocorp.com","jdoyll", "jdoyll@123",
					"5555555555", LocalDate.of(1983,1, 1), "Accountant",
					"full-time", 70000, 0, LocalDate.of(2022, 8, 1)));
			employeeRepository.save(new Employee(
					2L, "Cheryl Fenton", "cfenton@corpocorp.com", "cfenton", "cfenton@123",
					"7777777777", LocalDate.of(1991,9, 9), "Executive Assistant",
					"full-time", 82000, 0, LocalDate.of(2018, 4, 12)));
			employeeRepository.save(new Employee(
					3L, "Tiffany Richardson", "trichardson@corpocorp.com", "trich", "trich@123",
					"8888888888", LocalDate.of(2003,5, 23), "Intern",
					"part-time", 0, 20, LocalDate.of(2024, 6, 1)));
			employeeRepository.save(new Employee(
					4L, "David Smith", "dsmith@corpocorp.com", "dsmith", "dsmith@123",
					"9999999999", LocalDate.of(1991,9, 9), "Desktop Support",
					"full-time", 0, 26, LocalDate.of(2023, 3, 30)));
		};
	}
}
