package com.project.dbconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.project")
public class DBconfig 
{
	//DriverManager datasource need to be created
			@Bean(name="dataSource")
			public DataSource getH2DataSource()
			{
				DriverManagerDataSource dataSource=new DriverManagerDataSource();
				dataSource.setDriverClassName("org.h2.Driver");
				dataSource.setUrl("jdbc:h2:tcp://localhost/~/project");
				dataSource.setUsername("ram");
				dataSource.setPassword("ram");
				System.out.println("DataSource Created");
				return dataSource;
			}
			//SessionFactory need to be created
			
			@Bean(name="sessionFactory")
			public SessionFactory getSessionFactor()
			{
				Properties hibernateProp=new Properties();
				hibernateProp.put("hibernate.hbm2ddl.auto","update");
				hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
				LocalSessionFactoryBuilder buildFactory=new LocalSessionFactoryBuilder(getH2DataSource());
				buildFactory.addProperties(hibernateProp);
				buildFactory.scanPackages("com.project.model");
				
				System.out.println("Session Factory created");
				return buildFactory.buildSessionFactory();
				
			}
			//HibernateTransactionManager object need to created
			@Bean(name="hibernateTransactionManager")
			public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
			{
				System.out.println("Hibernate Transaction manager object created");
				return new HibernateTransactionManager(sessionFactory);
			}

	

}
