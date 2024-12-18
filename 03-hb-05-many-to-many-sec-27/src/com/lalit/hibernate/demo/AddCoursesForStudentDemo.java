package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Course;
import com.lalit.hibernate.entity.Instructor;
import com.lalit.hibernate.entity.InstructorDetail;
import com.lalit.hibernate.entity.Review;
import com.lalit.hibernate.entity.Student;

public class AddCoursesForStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {

			currentSession.beginTransaction();

			Student student = currentSession.get(Student.class, 2);

			Course course = new Course(" abc ");
			Course course1 = new Course(" cdf ");

			course.addStudent(student);
			course1.addStudent(student);

			currentSession.save(course1);
			currentSession.save(course);

			currentSession.getTransaction().commit();
			System.out.println("Done");
		} finally {
			currentSession.close();
			factory.close();
		}

	}

}
