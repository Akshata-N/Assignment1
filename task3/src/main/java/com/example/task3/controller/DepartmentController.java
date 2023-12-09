package com.example.task3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task3.entity.Department;
import com.example.task3.exception.DepartmentNotFoundException;
import com.example.task3.service.DepartmentServiceImpl;
import com.example.task3.vo.ResponseTemplate;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentServiceImpl service;
	
	@PostMapping("/")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department){
		return new ResponseEntity<>(service.saveDepartment(department),HttpStatus.OK);
	}
	@GetMapping("/{deptId}")
	public ResponseEntity<ResponseTemplate> getDepartmentWithEmployee(@PathVariable int deptId) throws DepartmentNotFoundException {
		return new ResponseEntity<>(service.getDepartmentWithEmployee(deptId),HttpStatus.OK);
	}

}
