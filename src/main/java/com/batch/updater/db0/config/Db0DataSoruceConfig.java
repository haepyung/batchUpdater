package com.batch.updater.db0.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
(
		entityManagerFactoryRef = "db0EntityManagerFactory",
		transactionManagerRef = "db0TransactionManager",
		basePackages = {"com.batch.updater.db0.repo"}
)
public class Db0DataSoruceConfig {
	
	@Autowired
	@Qualifier("db0DataSource")
	private DataSource db0DataSource;
	
	@Primary
	@Bean(name = "db0EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean db0EntityManagerFactory(EntityManagerFactoryBuilder builder)
	{
		return builder.dataSource(db0DataSource).persistenceUnit("db0EntityManager").packages("com.batch.updater.db0.model").build();
	}
	
	@Primary
	@Bean("db0TransactionManager")
	public PlatformTransactionManager db0TransactionManager(EntityManagerFactoryBuilder builder)
	{
		return new JpaTransactionManager(db0EntityManagerFactory(builder).getObject());
	}
}
