package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Victor Quintanilla
 *
 * Main class, loads packages, entities, repositories.
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan({"com.example.controller", "com.example.aggregator", "com.example.service"})
public class App {

	  @Bean
	  public RestTemplate restTemplate(){
		return new RestTemplate();
	  }

//	   TO DO A JPA IMPLEMENTATION
//	  @Bean
//	  public EntityManagerFactory entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean factory = new ClassPathXmlApplicationContext("entity-manager.xml")
//				.getBean(LocalContainerEntityManagerFactoryBean.class);
//		factory.afterPropertiesSet();
//		return factory.getObject();
//	  }
//
//	  @Bean
//	  public PlatformTransactionManager transactionManager() {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(entityManagerFactory());
//		return txManager;
//	  }
		
	   public static void main(String[] args) {
	      SpringApplication.run(App.class, args);
		}
	
}
