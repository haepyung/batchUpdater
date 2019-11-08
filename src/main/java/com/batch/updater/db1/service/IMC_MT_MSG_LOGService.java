package com.batch.updater.db1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.batch.updater.db1.model.IMC_MT_MSG_LOG;
import com.batch.updater.db1.repo.Db1QueryDslRepoSupport;
import com.batch.updater.db1.repo.IMC_MT_MSG_LOGRepo;

@Service()
@Transactional(readOnly=true)
public class IMC_MT_MSG_LOGService extends Db1QueryDslRepoSupport
{	
	@Autowired private IMC_MT_MSG_LOGRepo repo;
	
	public IMC_MT_MSG_LOGService()
	{
		super(IMC_MT_MSG_LOG.class);
	}
	
	@Modifying
	@Transactional
	public boolean save(IMC_MT_MSG_LOG entity)
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
	
	public IMC_MT_MSG_LOG findOne(String id)
	{
		return repo.findById(id).get();
	}
	
	public List<IMC_MT_MSG_LOG> findAll()
	{
		return repo.findAll();
	}
}
