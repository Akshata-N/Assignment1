package com.example.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task2.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
