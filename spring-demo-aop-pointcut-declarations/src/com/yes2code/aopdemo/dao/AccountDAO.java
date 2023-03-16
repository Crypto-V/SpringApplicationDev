package com.yes2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.yes2code.aopdemo.Account;

@Component
public class AccountDAO {
	String name;
	String serviceCode;

	public void addAccount(Account theAccount, boolean vipPlag) {
		System.out.println(getClass() + ": Doing my DB work: Adding Account!");
	}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public void setName(String string) {
		this.name = string;
		
	}

	public void setServiceCode(String string) {
		this.serviceCode = string;
		
	}

	public String getName() {
		return name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

}
