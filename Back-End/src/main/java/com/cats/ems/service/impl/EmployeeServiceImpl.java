package com.cats.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cats.ems.encryption.EmployeeEncryption;
import com.cats.ems.exception.UserNotFoundException;
import com.cats.ems.model.CredentialManager;
import com.cats.ems.model.Employee;
import com.cats.ems.repo.CredentialsRepository;
import com.cats.ems.repo.EmployeeRepository;
import com.cats.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	CredentialsRepository credentialsRepository;

	public Employee saveEmployee(Employee employee) {
		Employee employee1 = new Employee();
		employee1.setEmployeeName(employee1.getEmployeeName());
		employee1.setEmployeePassword(employee1.getEmployeePassword());
		employeeRepo.save(employee1);

		return employee1;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee getEmployee(int id) throws UserNotFoundException {
		Employee employee = employeeRepo.findByEmployeeId(id);
		if (employee != null) {
			return employee;
		} else {
			throw new UserNotFoundException("User not found with id: " + id);
		}
	}

	public String savelogin(CredentialManager credentialManager) {

		return null;
	}
	private EmployeeEncryption employeeEncryption = new EmployeeEncryption();
	

	public String storeData(CredentialManager credentialManager) {
		String password = credentialManager.getPassword();
		try {

			String encryptedData = employeeEncryption.encrypt(password);
			// System.out.println(encryptedData);
			 CredentialManager credentialManager2=new CredentialManager();
			 credentialManager2.setUserId(credentialManager.getUserId());
			 credentialManager2.setPassword(encryptedData);
			 credentialsRepository.save(credentialManager2);
			 
		} catch (Exception e) {

		}

		return "Successfully stored";
	}

	public String getEmpData( String name, String password) {
		CredentialManager credentialManager = credentialsRepository.findByUserId(name);
		if(credentialManager!=null)
		{
		 String encryptedData2 = credentialManager.getPassword();
		// System.out.println(password);
		
		try {
			if (encryptedData2.equals(password)) {
				String decryptedData = employeeEncryption.decrypt(encryptedData2);
				System.out.println(decryptedData);
//				EmployeeDto employeeDto = new EmployeeDto();
//				employeeDto.setEmployeeId(employee.getEmployeeId());
//				employeeDto.setEmployeeName(employee.getEmployeeName());
//				employeeDto.setEmployeePassword(decryptedData);
				return "Employee exists";
			} else {

				return "Not exists";
			}
		} catch (Exception e) {
		}
		return null;
		}
		else {
			return "Not exists";
		}
	}
}
