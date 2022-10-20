package com.cats.ems.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cats.ems.model.Employee;

import lombok.Data;

@Data
public class CredentialManagerDTO {

	private int loginId;
	
	@NotBlank(message = "not be blank")
	@NotNull(message = "not be null")
	private String userId;
	
	@NotNull
	@NotBlank
	private String password;
	private Employee employee;

}
