package com.fuad.fleetMgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuad.fleetMgt.models.Employee;

import com.fuad.fleetMgt.repositories.EmployeeRepository;


@Service
public class EmployeeService {

	// we need to autowire the Table from MySql
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Return list of employees
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	// Save a new Employee
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	// delete a employee
	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}
	
	// get by ID
	public Optional<Employee> findById(int id){
		return employeeRepository.findById(id);
	}
	
	//get by keyword
	public List<Employee> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return employeeRepository.findByKeyword(keyword);
	}

	public Employee findByUsername(String un) {
		// TODO Auto-generated method stub
		return employeeRepository.findByUsername(un);
	}

}
