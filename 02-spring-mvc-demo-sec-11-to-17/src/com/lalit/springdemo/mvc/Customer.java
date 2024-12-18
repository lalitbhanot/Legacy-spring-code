package com.lalit.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.lalit.springdemo.mvc.validation.CoarseCode;

public class Customer {
//adding validation rules 
	@NotNull(message = "is Required")
	@Size(min = 1, message = " First Name is required")
	private String firstName;
	private String lastName;

	@NotNull(message = " freePasses is Required")
	@Min(value = 1, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be greater than or equal to ten")
	private Integer freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}",message = " only 5 character allowed")
	private String postalCode;
	
	@CoarseCode
	private String courseCode ;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
