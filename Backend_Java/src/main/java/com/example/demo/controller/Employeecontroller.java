package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class Employeecontroller {
	
	@Autowired
	EmployeeRepository employeeRepository;



	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee body) {

		
		return employeeRepository.save(body);
	}

	@GetMapping("/employee/{employeeId}")

	public Optional<Employee> getEmployee(@PathVariable Integer employeeId) {
		
		Optional<Employee> employee =employeeRepository.findById(employeeId);
		
		return null;
	}

	@PutMapping("employee/{employeeId}")
	public Employee updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee body)  {
		
		
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		
		if(employee.isPresent()) {
			
			Employee employeeEdit = employee.get();			
			employeeEdit.setFirstName(body.getFirstName());
			employeeEdit.setLastName(body.getLastName());
			employeeEdit.setSalary(body.getSalary());
			employeeEdit.setEmployeeId(body.getEmployeeId());
			
			return employeeRepository.save(employeeEdit);
		
			
			return employeeEdit;
		}else {
			
			return null;
		}
	}
		
		
	
	@DeleteMapping("employee/{employeeId}")
	public String deleteemploye(@PathVariable Integer employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
	    
	    if (employee.isPresent()) {
	        employeeRepository.delete(employee.get());
	        return "delete success";
	    } else {
	        return "employee not found";
	    }
	}
