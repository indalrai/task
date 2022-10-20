package com.cats.ems.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cats.ems.model.Employee;
import com.cats.ems.repo.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	private static final Logger logger = LogManager.getLogger(EmployeeController.class);


	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		logger.debug("Employee save "+employee);
		employeeRepository.save(employee);
		return ResponseEntity.ok("Successfully Registered...");
	}
	
}
