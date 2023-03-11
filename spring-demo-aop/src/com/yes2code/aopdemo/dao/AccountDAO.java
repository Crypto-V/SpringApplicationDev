package com.yes2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.yes2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipPlag) {
		System.out.println(getClass() + ": Doing my DB work: Adding Account!");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

}
