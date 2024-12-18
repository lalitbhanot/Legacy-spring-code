package com.lalit.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {
			currentSession.beginTransaction();
			// use the session object to save Java Object
			List<Student> theStudent = currentSession.createQuery("from Student").getResultList();

			displayStudents("from Student ", theStudent);
			// simple where condition
			theStudent = currentSession.createQuery("from Student s where s.lastName='bhanot'").getResultList();
			displayStudents("where condition ", theStudent);
			// OR conditon
			theStudent = currentSession.createQuery("from Student s where s.firstName='lalit' OR s.lastName='bhanot'")
					.getResultList();
			displayStudents("OR Condition ", theStudent);

			// LIKE conditon
			theStudent = currentSession.createQuery("from Student s where s.firstName LIKE '%lalit%'").getResultList();
			displayStudents("OR Condition ", theStudent);

			currentSession.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(String msg, List<Student> theStudent) {
		for (Student student : theStudent) {
			System.out.println(msg + " " + student.toString());
		}
	}

}
