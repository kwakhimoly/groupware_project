package com.ds.gw.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DBConfig {
	@Autowired
	ApplicationContext applicationContext;
	
    
	@Bean //객체 생성 
	public SqlSessionFactory makeSqlSessionFactory(
			DataSource dataSource) throws Exception
	{
		System.out.println("************************");
		//SqlSessionFactory -  Factory 공장객체를 먼저 만들어서 던진다 
		final SqlSessionFactoryBean factory  
		   = new SqlSessionFactoryBean();
		
		//저객체와 application.properties 파일에 있는  datasource
		//와 연결 
		factory.setDataSource(dataSource);
		//설정파일과 연동하기(mybatis-config.xml)파일과 연동
		PathMatchingResourcePatternResolver resolver 
		  = new PathMatchingResourcePatternResolver();
		//classpath - src/main/resource
		Resource configLocation = 
			resolver.getResource("classpath:mybatis-config.xml");
		
		factory.setConfigLocation(configLocation);
		return factory.getObject();
	}
	
	@Bean 
	public SqlSessionTemplate makeSqlSession(
			SqlSessionFactory factory)
	{
		return new SqlSessionTemplate(factory);
	}
}
