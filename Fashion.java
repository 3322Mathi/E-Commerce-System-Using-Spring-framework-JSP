package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.jsp")
public class Fashion {
	
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver vr= new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public EntityManager getManager()
	{
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("dev");
		EntityManager manager= factory.createEntityManager();
		return manager;
		
	}
	
	@Bean
	public EntityTransaction getTransaction()
	{
		EntityTransaction transaction= getManager().getTransaction();
		return transaction;
	}

}
