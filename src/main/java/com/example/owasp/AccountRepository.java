package com.example.owasp;

import java.util.List;

import com.example.owasp.models.Account;

public interface AccountRepository {

	List<Account> findByLastName(String lastName);
	List<Account> findByLastNameWrong(String lastName);

	Account findByIdFixed(String id);
	
	Account findByIdWrong(String id);
	
	Account addAccount(Account account);

}
