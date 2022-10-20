package com.cats.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cats.ems.model.CredentialManager;
import com.cats.ems.model.Employee;

public interface CredentialsRepository extends JpaRepository<CredentialManager, Integer> {
	
	//@Query(value = "select * from cre where employee_name=?",nativeQuery =true)
	CredentialManager findByUserId(String userId);

	

}
