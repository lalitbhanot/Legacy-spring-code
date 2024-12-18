package com.lalit.maven.jsonDemo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class Driver {
	public static void main(String[] args) {
		try {

			// create object mapper
			ObjectMapper objectMapper = new ObjectMapper();

			Student theStudent = objectMapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println("FirstName:::" + theStudent.getFirstName());
			System.out.println("FirstName:::" + theStudent.getAddress().getCity());
			

			// read the Json
for (String tempLang :theStudent.getLanguages()) {
	System.out.println(tempLang);
}
			// print first and last name

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
