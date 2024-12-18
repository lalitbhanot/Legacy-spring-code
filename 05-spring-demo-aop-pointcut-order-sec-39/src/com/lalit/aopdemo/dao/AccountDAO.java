package com.lalit.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.lalit.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	
	
	
	
	public String getName() {
		System.out.println("----getNameCode----");
		return name;
	}

	public void setName(String name) {
		System.out.println("----setNameCode----");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("----getServiceCode----");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("----setServiceCode----");
		this.serviceCode = serviceCode;
	}

	public void addAccount() {
		System.out.println("----addAccount----");
		System.out.println(getClass() + " Doing my DB work");
	}

	public boolean addCutomer() {
		System.out.println("----addCutomer----");
		System.out.println(getClass() + " Doing my DB  Boolean Customer work");
		return true;
	}

	public void addAccount(Account account) {
		System.out.println(getClass() + " Doing my DB work with account parameter ");
	}

	public void addAccount(Account account, boolean id) {
		System.out.println(getClass() + " Doing my DB work with account parameter and boolean ID  ");
	}

}
