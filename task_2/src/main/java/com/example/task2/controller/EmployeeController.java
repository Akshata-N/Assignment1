package com.example.task2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task2.entity.Employee;
import com.example.task2.exception.EmployeeNotFoundException;
import com.example.task2.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl service;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmpData(@RequestBody Employee emp) {
		return new ResponseEntity<>(service.saveEmployee(emp),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Employee> modifyDepartment(@PathVariable int id,@RequestBody String department) throws EmployeeNotFoundException {
		return new ResponseEntity<>(service.updateEmpData(id, department),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Employee>> findAll(){
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	@DeleteMapping("/{empID}")
	public void removeEmpData(@PathVariable int empID) throws EmployeeNotFoundException {
		service.deleteEmployee(empID);
	}
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> findById(@PathVariable int employeeId) throws EmployeeNotFoundException{
		return new ResponseEntity<>(service.findByEmpId(employeeId),HttpStatus.OK);
		
	}

}
