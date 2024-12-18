package com.lalit.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lalit.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory

	@Autowired
	private SessionFactory sessionFactory;

	// @Transactional moved to service layer
	public List<Customer> getCustomer() {

		// get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute a query
		List<Customer> customer = theQuery.getResultList();

		// return the results

		// TODO Auto-generated method stub
		return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int id) {
		// get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Customer customer = currentSession.get(Customer.class, id);

		// return the results

		// TODO Auto-generated method stub
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery= currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		
	}

}
