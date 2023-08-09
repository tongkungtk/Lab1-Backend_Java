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

	private List<Employee> data = new ArrayList<Employee>();

	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee body) {

		
		return employeeRepository.save(body);
	}

	@GetMapping("/employee/{employeeId}")

	public Employee getEmployee(@PathVariable Integer employeeId) {
		
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		
		return null;
	}

	@PutMapping("employee/{employeeId}")
	public Employee updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee body)  {
		for (int i = 0; i < data.size(); i++) {
			if (employeeId == data.get(i).getEmployeeId()) {
				data.get(i).setFirstName(body.getFirstName());
				data.get(i).setLastName(body.getLastName());
				data.get(i).setSalary(body.getSalary());
				
				return data.get(i); 
			}
		}
		return null;
	}
	
	@DeleteMapping("employee/{employeeId}")
	public String deleteemploye(@PathVariable Integer employeeId) {
		for (int i = 0; i < data.size(); i++) {
			if (employeeId == data.get(i).getEmployeeId()) {
				data.remove(i);
				return "delate success";
			}
		}	
		return "employee no found";	
	}

	
	
	
	
	

	
	}
