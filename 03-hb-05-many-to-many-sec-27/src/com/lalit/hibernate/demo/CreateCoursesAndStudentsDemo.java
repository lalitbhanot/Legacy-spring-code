package com.lalit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lalit.hibernate.entity.Course;
import com.lalit.hibernate.entity.Instructor;
import com.lalit.hibernate.entity.InstructorDetail;
import com.lalit.hibernate.entity.Review;
import com.lalit.hibernate.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// create session

		Session currentSession = factory.getCurrentSession();

		try {

			currentSession.beginTransaction();
			Course course = new Course(" Pacman ");
			Student student = new Student("a", "b", "c.com");
			Student student1 = new Student("a1", "b1", "c1.com");
			
			course.addStudent(student1);
			course.addStudent(student);
			currentSession.save(student1);
			currentSession.save(student);
			currentSession.save(course);

			currentSession.getTransaction().commit();
			System.out.println("Done");
		} finally {
			currentSession.close();
			factory.close();
		}

	}

}
