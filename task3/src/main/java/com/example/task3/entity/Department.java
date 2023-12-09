package com.example.task3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int deptId;
	private String department;
	private String departmentCode;
	private int empId;
	
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public Department() {
		super();
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Department(int deptId, String department, String departmentCode, int empId) {
		super();
		this.deptId = deptId;
		this.department = department;
		this.departmentCode = departmentCode;
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", department=" + department + ", departmentCode=" + departmentCode
				+ ", empId=" + empId + "]";
	}
	
}
