 package com.cats.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cats.ems.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByEmployeeId(int id);

	@Query(value = "select * from employee where employee_name=?",nativeQuery =true)
	public Employee findByName (String name);


}
