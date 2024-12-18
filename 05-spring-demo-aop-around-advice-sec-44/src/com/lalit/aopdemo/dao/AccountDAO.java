package com.lalit.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lalit.aopdemo.Account;

@Component
public class AccountDAO {

	public List<Account> findAccounts(boolean tripWire) {
		List<Account> myAccount = new ArrayList<>();

		if (tripWire) {
			throw new RuntimeException("throwing false exception from find account method");
		}
		Account temp1 = new Account("first", "silver");
		Account temp2 = new Account("second", "gold");
		Account temp3 = new Account("third", "platinum");

		myAccount.add(temp3);
		myAccount.add(temp2);
		myAccount.add(temp1);

		return myAccount;
	}

	public void addAccount(Account account, boolean id) {
		System.out.println(getClass() + " Doing my DB work with account parameter and boolean ID  ");
	}

}