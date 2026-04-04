package com.Bankapp.service;

import java.util.List;

import com.Bankapp.entity.account;

public interface Accountservice {
	public account createAccount(account Account);
	public account getAccountDetailsByAccountNumber(long accountnumber);
	public List<account>getAllAccountDetails();
	public account depositamount(long accountnumber,Double amount);
	public account withdrawamount(long accountnumber,Double amount);
	public void closeaccount(long accountnumber);

}
