package com.lalit.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.lalit.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + " Doing my DB work");
	}
	
	public boolean addCutomer() {
		System.out.println(getClass() + " Doing my DB  Boolean Customer work");
		return true ;
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + " Doing my DB work with account parameter ");
	}
	
	public void addAccount(Account account,boolean id) {
		System.out.println(getClass() + " Doing my DB work with account parameter and boolean ID  ");
	}
	
}
