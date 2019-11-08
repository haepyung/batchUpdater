package com.batch.updater.db0.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.batch.updater.db0.model.EBAD;

public interface EBADRepo extends JpaRepository<EBAD, String>, QuerydslPredicateExecutor<EBAD>  {

}
