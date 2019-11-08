package com.batch.updater.db0.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public abstract class Db0QueryDslRepoSupport extends QuerydslRepositorySupport {

	public Db0QueryDslRepoSupport(Class<?> domainClass) {
		super(domainClass);
	}
	
	@Override
	@PersistenceContext(unitName = "db0EntityManager")
	public void setEntityManager(EntityManager entityManager)
	{
		super.setEntityManager(entityManager);
	}
}
