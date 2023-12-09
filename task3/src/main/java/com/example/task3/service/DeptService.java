package com.example.task3.service;

import com.example.task3.entity.Department;
import com.example.task3.exception.DepartmentNotFoundException;
import com.example.task3.vo.ResponseTemplate;

public interface DeptService {
	Department saveDepartment(Department department);
	ResponseTemplate getDepartmentWithEmployee(int deptId) throws DepartmentNotFoundException;
	

}
