package com.Bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bankapp.entity.account;
import com.Bankapp.repo.accountrepos;
@Service

public class Accountserviceimplementation implements Accountservice {
	@Autowired
	accountrepos repo;

	@Override
	public account createAccount(account Account) {
		account account_saved=repo.save(Account);
		// TODO Auto-generated method stub
		return account_saved;
	}

	@Override
	public account getAccountDetailsByAccountNumber(long accountnumber) {
		Optional<account> Account=repo.findById(accountnumber);
		if(Account.isEmpty()) {
			throw new RuntimeException("account is not present");
		}
		account account_found=Account.get();
		// TODO Auto-generated method stub
		return account_found;
	}

	@Override
	public List<account> getAllAccountDetails() {
		List<account> listOfAccounts=repo.findAll();
		// TODO Auto-generated method stub
		return listOfAccounts;
	}

	@Override
	public account depositamount(long accountnumber, Double amount) {
		Optional<account> Account=repo.findById(accountnumber);
		if(Account.isEmpty()) {
			throw new RuntimeException("account is not present");
			
		}
		account AccountPresent=Account.get();
		Double totalBalance=AccountPresent.getAccount_balance()+amount;
		AccountPresent.setAccount_balance(totalBalance);
		repo.save(AccountPresent);
		// TODO Auto-generated method stub
		return AccountPresent;
	}

	@Override
	public account withdrawamount(long accountnumber, Double amount) {
		Optional<account> Account=repo.findById(accountnumber);
		if(Account.isEmpty()) {
			throw new RuntimeException("account is not present");
			
		}
		account AccountPresent=Account.get();
		Double accountBalance=AccountPresent.getAccount_balance()-amount;
		AccountPresent.setAccount_balance(accountBalance);
		// TODO Auto-generated method stub
		return AccountPresent;
	}

	@Override
	public void closeaccount(long accountnumber) {
		getAccountDetailsByAccountNumber(accountnumber);
		repo.deleteById(accountnumber);
		// TODO Auto-generated method stub
		
	}

}
