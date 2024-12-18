package com.lalit.springBoot.cruddemo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lalit.springBoot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	// Imports are imp for the result
	@Override
	// @Transactional --will be handled in service
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		List<Employee> EmployeeResultList = theQuery.getResultList();

		return EmployeeResultList;

	}

	@Override
	public Employee findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Employee theEmp = currentSession.get(Employee.class, theId);

		return theEmp;

	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");

		query.setParameter("employeeId", theId);
		query.executeUpdate();

	}

}
