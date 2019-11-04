package com.batch.updater.db0.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.batch.updater.db0.model.Account;
import com.batch.updater.db0.repo.AccountRepo;
import com.batch.updater.db0.repo.Db0QueryDslRepoSupport;

@Service()
@Transactional(readOnly=true)
public class AccountService extends Db0QueryDslRepoSupport implements UserDetailsService
{	
	@Autowired private AccountRepo repo;
	
	public AccountService()
	{
		super(Account.class);
	}
	
	@Modifying
	@Transactional
	public boolean save(Account entity)
	{
		try 
		{
			repo.save(entity);
		} 
		catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public List<Account> findAll()
	{
		return repo.findAll();
	}
	
	public Account findOne(String id)
	{
		return repo.findById(id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
