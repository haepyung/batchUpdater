package com.batch.updater.db1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.batch.updater.db1.model.IMC_MT_MSG_LOG;

public interface IMC_MT_MSG_LOGRepo extends JpaRepository<IMC_MT_MSG_LOG, String>, QuerydslPredicateExecutor<IMC_MT_MSG_LOG>  {

}
