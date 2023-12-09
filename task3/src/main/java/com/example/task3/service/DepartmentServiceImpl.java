package com.example.task3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.task3.entity.Department;
import com.example.task3.exception.DepartmentNotFoundException;
import com.example.task3.repository.DeptRepo;
import com.example.task3.vo.Employee;
import com.example.task3.vo.ResponseTemplate;

@Service
public class DepartmentServiceImpl implements DeptService{
	@Autowired
	private DeptRepo repository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return repository.save(department);
	}
	public Department findDeptById(int deptId) throws DepartmentNotFoundException {
		Optional<Department> dept=repository.findById(deptId);
		if(dept.isEmpty()) {
			throw new DepartmentNotFoundException("department not found exception");
		}
		return dept.get();
	}

	@Override
	public ResponseTemplate getDepartmentWithEmployee(int deptId) throws DepartmentNotFoundException {
		ResponseTemplate template=new ResponseTemplate();
		Department department1=findDeptById(deptId);
		Employee employee=restTemplate.getForObject("localhost:8081/emp/" + department1.getEmpId(), Employee.class);
		template.setDepartment(department1);
		template.setEmployee(employee);
		return template;
	}




}
