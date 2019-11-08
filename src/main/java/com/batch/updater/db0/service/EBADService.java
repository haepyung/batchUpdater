package com.batch.updater.db0.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.batch.updater.db0.model.EBAD;
import com.batch.updater.db0.repo.Db0QueryDslRepoSupport;
import com.batch.updater.db0.repo.EBADRepo;

@Service()
@Transactional(readOnly=true)
public class EBADService extends Db0QueryDslRepoSupport
{	
	@Autowired private EBADRepo repo;

	public EBADService()
	{
		super(EBAD.class);
	}
	
	@Modifying
	@Transactional
	public boolean save(EBAD entity)
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
	
	public List<EBAD> findAll()
	{
		return repo.findAll();
	}
	
	public EBAD findOne(String id)
	{
		return repo.findById(id).get();
	}
}
