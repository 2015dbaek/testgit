package com.apolis.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apolis.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

	@Query(value = "SELECT * FROM employee", nativeQuery=true)
	public List<Employee> getAllEmployees(); //to create a custom query matching with a method
	
	@Query(value = "SELECT * FROM employee WHERE ID= :id", nativeQuery=true)
	public Optional<Employee> getEmployeeById(@Param("id") int id); //these custom queries match with the method being called on repo
}
