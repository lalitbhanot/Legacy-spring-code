package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Instructor;
import com.lalit.hibernate.entity.InstructorDetail;
import com.lalit.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {

			currentSession.beginTransaction();

			// commit the transaction
			Instructor instructor = new Instructor("instructor first name","instructor last name","asdf@gmail.com"); 
			InstructorDetail instructorDetail = new InstructorDetail ("youtube.com", "coding") ;
			instructor.setInstructorDetailId(instructorDetail);
			currentSession.save(instructor);
			currentSession.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

}
