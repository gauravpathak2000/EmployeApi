package com.nagarro.EmployeeAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.EmployeeAPI.model.Employee;
import com.nagarro.EmployeeAPI.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return (List<Employee>)empRepo.findAll();
	}
	
	@PostMapping("/setEmployee")
	public Employee setEmployee(@RequestBody Employee emp) {
		if(empRepo.findByEmpCode(emp.getEmpCode()) == null ) {
			empRepo.save(emp);
			return emp;
		}
		return null;
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		return (Employee) empRepo.findByEmpCode(id);
	}
	
	@PostMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		if(empRepo.findByEmpCode(emp.getEmpCode()) != null ) {
			empRepo.save(emp);
			return emp;
		}
		return null;
	}
}
