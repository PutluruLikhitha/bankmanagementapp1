package com.Bankapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bankapp.entity.account;
import com.Bankapp.service.Accountservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/account")

public class Accountcontroller {
	@Autowired
	Accountservice service;
	@PostMapping("/create")
	
	public ResponseEntity<account> createAccount(@RequestBody account Account) {
		account createAccount=service.createAccount(Account);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	@GetMapping("/{accountnumber}")
	public account getAccountByAccountnumberAccount(@PathVariable Long accountnumber) {
		account Account=service.getAccountDetailsByAccountNumber(accountnumber);
		return Account;
		
	}
	@GetMapping("/getallaccounts")
	public List<account> getAllAccountDetails(){
		List<account> allAccountsDetails=service.getAllAccountDetails();
		return allAccountsDetails;
	}
	@PutMapping("/deposit/{accountnumber}/{amount}")
	public account depositAccount(@PathVariable long accountnumber,@ PathVariable Double amount) {
		account Account=service.depositamount(accountnumber, amount);
		return Account;
	}
	@PutMapping("/withdraw/{accountnumber}/{amount}")
	public account withdrawAccount(@PathVariable long accountnumber,@ PathVariable Double amount) {
		account Account=service.withdrawamount(accountnumber, amount);
		return Account;
	}
	@DeleteMapping("/delete/{accountnumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountnumber) {
		service.closeaccount(accountnumber);
		return ResponseEntity.ok("Account closed");
	}

	
	
	

}
