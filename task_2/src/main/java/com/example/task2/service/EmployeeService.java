package com.example.task2.service;

import java.util.List;

import com.example.task2.entity.Employee;
import com.example.task2.exception.EmployeeNotFoundException;

public interface EmployeeService {
    Employee saveEmployee(Employee emp);
	Employee updateEmpData(int id,String department) throws EmployeeNotFoundException;
	List<Employee> getAll();
	void deleteEmployee(int empId) throws EmployeeNotFoundException;
	}
