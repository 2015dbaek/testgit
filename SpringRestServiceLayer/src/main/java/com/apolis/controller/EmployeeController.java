package com.apolis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apolis.model.Employee;
import com.apolis.service.EmployeeService;

@RestController
@RequestMapping("/employee") //request mapping at top gives a base location for all employee functions so its localhost:num/employee/function
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/employee") //better to name without verbs and use postman get/post/delete to decide which to use
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e1){ //response entity more used as return type to give some status
		Employee responseEmployee = service.saveEmployee(e1);
		return new ResponseEntity<Employee>(responseEmployee,HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		Employee e1 = service.getEmployeeById(id);
		return new ResponseEntity<Employee>(e1,HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
		service.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //for void returns
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e1){
		Employee responseEmployee = service.updateEmployee(e1);
		return new ResponseEntity<Employee>(responseEmployee,HttpStatus.CREATED);
	}
	
}
