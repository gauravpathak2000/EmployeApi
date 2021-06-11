package com.nagarro.EmployeeAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.EmployeeAPI.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	Employee findByEmpCode(int id);
}
