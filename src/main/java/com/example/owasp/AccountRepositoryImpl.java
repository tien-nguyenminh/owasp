package com.example.owasp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.owasp.models.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository  {

	@PersistenceContext
	private EntityManager entityManager;
	// Select * from ACCOUNT where last_name = ''
	@Override
	public List<Account> findByLastName(String lastName) {
		List<Account> resultList = entityManager
				.createNativeQuery("Select * from ACCOUNT where last_name = :lastName", Account.class)
				.setParameter("lastName", lastName)
				.getResultList();
		return resultList;
	}
	@Override
	public List<Account> findByLastNameWrong(String lastName) {
		List<Account> resultList = entityManager
				.createNativeQuery("Select * from ACCOUNT where last_name = " + lastName, Account.class)
				.getResultList();
		return resultList;
	}
	
	@Override
	public Account findByIdWrong(String id) {
		List<Account> resultList = entityManager
				.createNativeQuery("Select * from ACCOUNT where id = " + id, Account.class)
				.getResultList();
		return resultList.get(0);
	}
	
	@Override
	public Account findByIdFixed(String id) {
		List<Account> resultList = entityManager
				.createNativeQuery("Select * from ACCOUNT where id = :id ", Account.class)
				.setParameter("id", id)
				.getResultList();
		return resultList.get(0);
	}
	
	@Transactional
	@Override
	public Account addAccount(Account account) {
		entityManager.persist(account);
		return account;
	}

}
