package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Instructor;
import com.lalit.hibernate.entity.InstructorDetail;
import com.lalit.hibernate.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {

			currentSession.beginTransaction();
			InstructorDetail instructorDetail = currentSession.get(InstructorDetail.class, 3);
			System.out.println("Bi Directional example ::::: " + instructorDetail.getInstructor());
			
			//deleting the object 
			System.out.println("Deletting.....");
			//break the bi directinal link ,remove the assocaited data
			instructorDetail.getInstructor().setInstructorDetailId(null);
			currentSession.delete(instructorDetail);
			currentSession.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			currentSession.close();
			;
			factory.close();
		}

	}

}
