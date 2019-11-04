package com.batch.updater.db0.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.updater.db0.model.Account;

public interface AccountRepo extends JpaRepository<Account, String> {

}
