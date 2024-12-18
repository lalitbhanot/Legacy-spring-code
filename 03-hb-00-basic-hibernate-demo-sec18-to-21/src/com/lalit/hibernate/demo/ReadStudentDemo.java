package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Lalit1", "Bhanot1", "abc.gamail.com");
			// start a transaction
			System.out.println("begining the transcation");
			currentSession.beginTransaction();
			// save the student
			System.out.println("save the student");
			currentSession.save(student);
			// commit the transaction
			currentSession.getTransaction().commit();
			
			
			// For reading the data 
			System.out.println("********Reading the data*****");
			currentSession = factory.getCurrentSession();
			currentSession.beginTransaction();
			
			Student student2 = currentSession.get(Student.class, student.getId()); 
			
			System.out.println("Done " +student2.toString());
			currentSession.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
