package com.batch.updater.db1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.updater.db1.model.Custom;

public interface CustomRepo extends JpaRepository<Custom, String> {

}
