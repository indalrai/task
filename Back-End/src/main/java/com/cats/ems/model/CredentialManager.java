package com.cats.ems.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class CredentialManager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loginId;
	
	@NotNull
	@NotBlank(message ="not be blank" )
//	@Pattern(regexp = "^\\d{10}$(?=.*[a-z])(?=.*[A-Z])", message = "Invalid User ID entered")
	private String userId;
	
	 
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$", message = "Invalid Password")
	@NotNull
	@NotBlank
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId")
	private Employee employee;

}
