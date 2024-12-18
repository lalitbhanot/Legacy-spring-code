package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Course;
import com.lalit.hibernate.entity.Instructor;
import com.lalit.hibernate.entity.InstructorDetail;
import com.lalit.hibernate.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {

			currentSession.beginTransaction();
			//get the instructor from db
			Instructor instructor =  currentSession.get(Instructor.class, 1) ;
			
			// create some courses
			Course tempCourse =  new Course("The Pinball Course");
			Course tempCourse1 =  new Course("Drawing ");
			
			
			// add courses to instructor
			instructor.add(tempCourse);
			instructor.add(tempCourse1);
			
			// save the courses
		
			currentSession.save(tempCourse);

			currentSession.save(tempCourse1);
			
			
			currentSession.getTransaction().commit();
			System.out.println("Done");
		} finally {
			currentSession.close();
			factory.close();
		}

	}

}
