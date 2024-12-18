package com.lalit.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalit.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> students;

	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("stu1", "stu1"));
		students.add(new Student("stu2", "stu2"));
		students.add(new Student("stu3", "stu3"));

	}

	@GetMapping("/students")
	public List<Student> getStudent() {

		return students;
	}

	@GetMapping("/studentById/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if ((studentId >= students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student Id not found :" + studentId);

		}
		return students.get(studentId);
	}

	
	/* Move to Global exception Handler
	 * //Add the exception
	 * 
	 * @ExceptionHandler public ResponseEntity<StudentErrorResponse>
	 * handleException(StudentNotFoundException exe) { StudentErrorResponse error =
	 * new StudentErrorResponse(); error.setMessage(exe.getMessage());
	 * error.setStatus(HttpStatus.NOT_FOUND.value());
	 * error.setTimestamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<> (error, HttpStatus.NOT_FOUND) ; }
	 * 
	 * //Generic Exception
	 * 
	 * @ExceptionHandler public ResponseEntity<StudentErrorResponse>
	 * handleException(Exception exe) { StudentErrorResponse error = new
	 * StudentErrorResponse(); error.setMessage(exe.getMessage());
	 * error.setStatus(HttpStatus.BAD_REQUEST.value());
	 * error.setTimestamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST) ; }
	 */
}
