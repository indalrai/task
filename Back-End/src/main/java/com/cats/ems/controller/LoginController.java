package com.cats.ems.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cats.ems.model.CredentialManager;
import com.cats.ems.repo.CredentialsRepository;


@RestController
@RequestMapping("/employee")
public class LoginController {
	
	@Autowired
	CredentialsRepository credentialsRepository;
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);

	@PostMapping("/login")
	public ResponseEntity<String> saveCredentialManager(@RequestBody CredentialManager credentialManager)
	{
		logger.info("Login successfully to employee management system");
		credentialsRepository.save(credentialManager);
		return ResponseEntity.ok("credential successfull");
	}
	
	
}
