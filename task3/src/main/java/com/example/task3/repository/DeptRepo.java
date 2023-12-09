package com.example.task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.task3.entity.Department;

@Repository
public interface DeptRepo extends JpaRepository<Department,Integer>{
	
	

}
