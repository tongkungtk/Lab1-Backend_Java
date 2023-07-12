package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class Employeecontroller {
	
	private List<Emplo>(data= new ArrayList<Employee>)
	
	@GetMapping("/")
	public String index() {
		return "Greeting from Spring Boot"

	}

}
	