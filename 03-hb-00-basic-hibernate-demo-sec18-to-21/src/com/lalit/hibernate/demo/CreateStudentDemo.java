package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {
			// use the session object to save Java Object

			// create a student object
			System.out.println("Creating a new object...");
			Student student = new Student("Lalit", "Bhanot", "abc.gamail.com");
			// start a transaction
			System.out.println("begining the transcation");
			currentSession.beginTransaction();
			// save the student
			System.out.println("save the student");
			currentSession.save(student);
			// commit the transaction
			currentSession.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

}
