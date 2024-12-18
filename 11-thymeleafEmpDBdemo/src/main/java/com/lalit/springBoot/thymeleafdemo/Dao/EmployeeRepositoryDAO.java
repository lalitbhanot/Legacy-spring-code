package com.lalit.springBoot.thymeleafdemo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lalit.springBoot.thymeleafdemo.entity.Employee;


public interface EmployeeRepositoryDAO extends JpaRepository<Employee, Integer> {


	
}
