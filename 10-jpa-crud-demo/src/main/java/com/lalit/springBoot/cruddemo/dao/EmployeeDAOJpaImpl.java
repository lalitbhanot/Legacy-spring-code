package com.lalit.springBoot.cruddemo.dao;

import java.util.List;
import javax.persistence.EntityManager;
//For standard JPA
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.lalit.springBoot.cruddemo.entity.Employee;

@Repository
@Primary
public class EmployeeDAOJpaImpl implements EmployeeDAOJpa {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	// Imports are imp for the result
	@Override
	// @Transactional --will be handled in service
	public List<Employee> findAll() {

		Query theQuery = entityManager.createQuery("from Employee", Employee.class);

		List<Employee> EmployeeResultList = theQuery.getResultList();

		return EmployeeResultList;

	}

	@Override
	public Employee findById(int theId) {

		Employee theEmp = entityManager.find(Employee.class, theId);

		return theEmp;

	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");

		query.setParameter("employeeId", theId);
		query.executeUpdate();

	}

}
