package com.apolis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apolis.dao.EmployeeRepository;
import com.apolis.exception.InputMissingException;
import com.apolis.exception.NegativeIdException;
import com.apolis.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public Employee saveEmployee(Employee e1){
		if(e1.getName().isEmpty()){
			throw new InputMissingException("701", "Input is missing details.");
		}
		return repo.save(e1);
	}
	
	public List<Employee> getAllEmployees(){
		return repo.getAllEmployees();
	}
	
	public Employee getEmployeeById(int id){
		if(id <= 0){
			throw new NegativeIdException("702", "id search cannot be 0 or negative");
		}
		Optional<Employee> e1 = repo.getEmployeeById(id);
		return e1.get();
	}
	
	public void deleteEmployee(int id){
		if(id <= 0){
			throw new NegativeIdException("702", "id search cannot be 0 or negative");
		}
		repo.deleteById(id);
	}
	
	public Employee updateEmployee(Employee e1){
		Optional<Employee> optional = repo.getEmployeeById(e1.getId());
		//optional used here to avoid null pointer exception/to help with null cases more easily
		if(optional.isPresent()){
			Employee newE = optional.get();
			newE.setName(e1.getName());
			newE.setSalary(e1.getSalary());
			newE.setEmail(e1.getEmail());
			newE = repo.save(newE);
			return e1; //why return e1 and not newE
		}
		return null; //only if employee wasn't present!
	}
}
