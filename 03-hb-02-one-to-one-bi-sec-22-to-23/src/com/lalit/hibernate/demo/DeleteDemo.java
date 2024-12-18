package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Instructor;
import com.lalit.hibernate.entity.InstructorDetail;
import com.lalit.hibernate.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {

			currentSession.beginTransaction();
			//get the instructor by ID 
			
			Instructor instructor =	currentSession.get(Instructor.class, 1);
			
			
			//delete the instructor
			if (instructor!=null)
			{ //will delete both parent and child since I have used the 
				// cascade 
				currentSession.delete(instructor);
			}
			
			currentSession.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

}
