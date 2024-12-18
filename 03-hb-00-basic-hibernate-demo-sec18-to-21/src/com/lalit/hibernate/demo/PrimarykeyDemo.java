package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Student;

public class PrimarykeyDemo {


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
			Student student = new Student("abc", "abc", "abc.gamail.com");
			Student student1 = new Student("qwerty", "qwerty", "abc.gamail.com");
			Student student2 = new Student("asdfg", "asdf", "abc.gamail.com");
			// start a transaction
			System.out.println("begining the transcation");
			currentSession.beginTransaction();
			// save the student
			System.out.println("save the student");
			currentSession.save(student);
			currentSession.save(student1);
			currentSession.save(student2);
			// commit the transaction
			currentSession.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

	
}
