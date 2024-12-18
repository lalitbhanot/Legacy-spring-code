package com.lalit.springBoot.cruddemo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lalit.springBoot.cruddemo.entity.Employee;

public interface EmployeeRepositoryDAO extends JpaRepository<Employee, Integer> {


	
}
