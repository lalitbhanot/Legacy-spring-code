package com.lalit.springdemo.mvc;

import java.util.*;

public class Student {

	
	private String firstName ;
	private String lastName ;
	private String country ;
	private LinkedHashMap<String, String>  countries ;
	private String favLang ;
	private String[] operatingSystem ;
	
public Student () {
	countries = new LinkedHashMap<>() ;
	countries.put("BR", "brazil") ;
	countries.put("FR", "France") ;
	countries.put("INR", "India") ;
}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
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

	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}

	public void setCountries(LinkedHashMap<String, String> countries) {
		this.countries = countries;
	}

	public String getFavLang() {
		return favLang;
	}

	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	
}
