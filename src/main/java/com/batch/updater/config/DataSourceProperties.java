package com.batch.updater.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableConfigurationProperties
public class DataSourceProperties {
	
	@Bean(name = "db0DataSource")
	@Qualifier("db0DataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.db0")
	public DataSource db0DataSource() 
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource.db0.liquibase")
    public LiquibaseProperties db0LiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public SpringLiquibase db0Liquibase() {
        return springLiquibase(db0DataSource(), db0LiquibaseProperties());
    }
	
	@Bean(name ="db1DataSource")
	@Qualifier("db1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.db1")
	public DataSource db1DataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource.db1.liquibase")
    public LiquibaseProperties db1LiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public SpringLiquibase db1Liquibase() {
        return springLiquibase(db1DataSource(), db1LiquibaseProperties());
    }
	
	private static SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());
        liquibase.setContexts(properties.getContexts());
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setDropFirst(properties.isDropFirst());
        liquibase.setShouldRun(properties.isEnabled());
        liquibase.setLabels(properties.getLabels());
        liquibase.setChangeLogParameters(properties.getParameters());
        liquibase.setRollbackFile(properties.getRollbackFile());
        return liquibase;
    }
}
