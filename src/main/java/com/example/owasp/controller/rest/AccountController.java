package com.example.owasp.controller.rest;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.owasp.AccountRepository;
import com.example.owasp.models.Account;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	
	@GetMapping("v1/search")
    public List<Account> findByLastNameWrong(@QueryParam("lastName") String lastName) {
        return accountRepository.findByLastNameWrong(lastName);
    }
	
	@GetMapping("v2/search")
	public List<Account> findByLastName(@QueryParam("lastName") String lastName) {
		return accountRepository.findByLastName(lastName);
	}
	
	
	@GetMapping("v1/{id}")
    public Account findByIdWrong(@PathVariable("id") String id) {
        return accountRepository.findByIdWrong(id);
    }
	
	@GetMapping("v2/{id}")
	public Account findByIdFixed(@PathVariable("id") String id) {
		return accountRepository.findByIdFixed(id);
	}
	
}
