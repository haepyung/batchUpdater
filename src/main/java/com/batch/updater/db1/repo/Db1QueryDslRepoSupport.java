package com.batch.updater.db1.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public abstract class Db1QueryDslRepoSupport extends QuerydslRepositorySupport {

	public Db1QueryDslRepoSupport(Class<?> domainClass) {
		super(domainClass);
	}
	
	@Override
	@PersistenceContext(unitName = "db1EntityManager")
	public void setEntityManager(EntityManager entityManager)
	{
		super.setEntityManager(entityManager);
	}
}
