package com.lalit.springBoot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lalit.springBoot.cruddemo.entity.Employee;


//@RepositoryRestResource(path="members")
public interface EmployeeRepositoryDAO extends JpaRepository<Employee, Integer> {


	
}
