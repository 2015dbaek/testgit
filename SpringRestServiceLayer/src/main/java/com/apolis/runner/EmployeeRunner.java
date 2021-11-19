package com.apolis.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apolis.dao.EmployeeRepository;
import com.apolis.model.Employee;

@Component
public class EmployeeRunner implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.save(new Employee("Jon", 10000, "joni@imail.com"));
		repo.save(new Employee("Tom", 20000, "tome@email.com"));
		repo.save(new Employee("Pam", 15000, "pama@amail.com"));
	}

}
