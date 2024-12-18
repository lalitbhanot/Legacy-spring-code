package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Course;
import com.lalit.hibernate.entity.Instructor;
import com.lalit.hibernate.entity.InstructorDetail;
import com.lalit.hibernate.entity.Review;
import com.lalit.hibernate.entity.Student;

public class GetCoursesAndReviewDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {

			currentSession.beginTransaction();
			Course tempCourse = currentSession.get(Course.class, 10);
		System.out.println("tempCourse" + tempCourse);
			System.out.println("tempCourse" + tempCourse.getReview());
			
			currentSession.getTransaction().commit();
			System.out.println("Done");
		} finally {
			currentSession.close();
			factory.close();
		}

	}

}