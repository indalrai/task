package com.cats.ems.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class EmployeeRequest {

	@NotNull(message = "Employee name should not be null")
	private String employeeName;
	@NotNull(message = "Employee password should not be null")
	@NotBlank(message = "Employee password should not be blank")
	private String employeePassword;

}
