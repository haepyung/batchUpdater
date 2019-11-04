package com.batch.updater.db1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.batch.updater.db1.model.Custom;
import com.batch.updater.db1.repo.CustomRepo;
import com.batch.updater.db1.repo.Db1QueryDslRepoSupport;

@Service()
@Transactional(readOnly=true)
public class CustomService extends Db1QueryDslRepoSupport
{	
	@Autowired private CustomRepo repo;
	
	public CustomService()
	{
		super(Custom.class);
	}
	
	@Modifying
	@Transactional
	public boolean save(Custom entity)
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
	
	public Custom findOne(String id)
	{
		return repo.findById(id).get();
	}
	
	public List<Custom> findAll()
	{
		return repo.findAll();
	}
}
