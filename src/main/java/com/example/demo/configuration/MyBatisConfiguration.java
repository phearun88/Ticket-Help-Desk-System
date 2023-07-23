package com.example.demo.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan("com.example.demo.repository")
public class MyBatisConfiguration {

private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager managerDataSour() {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	SqlSessionFactoryBean factoryBean() {
		
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		
		return bean;
	}
}
