package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {
			int id = 5;
			// use the session object to save Java Object

			// start a transaction
			System.out.println("begining the transcation");
			currentSession.beginTransaction();
			// For reading the data
			System.out.println("********Reading the data*****");
			currentSession = factory.getCurrentSession();

			Student student = currentSession.get(Student.class, id);
			System.out.println("Before  Updating " + student.toString());
			student.setFirstName("updated value");
			System.out.println("After Updating  " + student.toString());
			currentSession.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
