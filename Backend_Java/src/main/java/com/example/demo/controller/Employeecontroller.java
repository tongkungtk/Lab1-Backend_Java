package com.example.demo.Employeecontroller;

import com.example.demo.mobel.Employee;
import com.example.demo.repository.EmployeeRepository;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employeecontroller {

  @Autowired
  EmployeeRepository employeeRepository;

  private List<Employee> data = new ArrayList<Employee>();

  @GetMapping("/employee")
  public List<Employee> getEmployee() {
    return employeeRepository.findAll();
  }

  @PostMapping("/employee")
  public Employee addEmployee(@RequestBody Employee body) {
    return employeeRepository.save(body);
  }

  @GetMapping("/employee/{EmployeeId}")
  public Optional<Employee> gatEmployeeDetail(
    @PathVariable Integer EmployeeId
  ) {
    Optional<Employee> employee = employeeRepository.findById(EmployeeId);

    return employee;
  }

  @PutMapping("/employee/{EmployeeId}")
  public Employee updatEmployee(
    @PathVariable Integer EmployeeId,
    @RequestBody Employee body
  ) {
    Optional<Employee> employee = employeeRepository.findById(EmployeeId);

    if (employee.isPresent()) {
      employee.get().setFirstname(body.getFirstname());
      employee.get().setLastname(body.getLastname());
      employee.get().setFirstname(body.getLastname());
      employee.get().setSalary(body.getSalary());
      employee.get().setEmployeeId(body.getEmployeeId());
      employeeRepository.save(employee.get());
      return employee.get();
    } else {
      return null;
    }
  }

  @DeleteMapping("/employee/{EmployeeId}")
  public String deletEmployee(@PathVariable Integer EmployeeId) {
    Optional<Employee> employee = employeeRepository.findById(EmployeeId);

    if (employee.isPresent()) {
      employeeRepository.delete(employee.get());

      return "delete sucess";
    }

    return "employee not font";
  }
}
