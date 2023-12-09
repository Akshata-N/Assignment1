package com.example.task2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task2.entity.Employee;
import com.example.task2.exception.EmployeeNotFoundException;
import com.example.task2.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo repository;

	@Override
	public Employee saveEmployee(Employee emp) {
	return repository.save(emp);
	}

	public Employee findByEmpId(int empID) throws EmployeeNotFoundException {
		Optional<Employee> emp=repository.findById(empID);
		if(emp.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		return emp.get();
	}
	@Override
	public Employee updateEmpData(int id, String department) throws EmployeeNotFoundException {
		Employee emp=findByEmpId(id);
		emp.setDepartment(department);
		return repository.save(emp);
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteEmployee(int empId) throws EmployeeNotFoundException {
		Employee employee=findByEmpId(empId);
		 repository.delete(employee);
		}

}
