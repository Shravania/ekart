package com.niit.ekart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.ekart.models.BillingAddress;
import com.niit.ekart.models.Cart;
import com.niit.ekart.models.CartGroup;
import com.niit.ekart.models.CartItem;
import com.niit.ekart.models.Catagory;
import com.niit.ekart.models.UserOrder;
import com.niit.ekart.models.User;
import com.niit.ekart.models.UserRole;
import com.niit.ekart.models.Product;

import com.niit.ekart.models.ShippingAddress;


@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class ApplicationConfiguration{
	
	//Hibernates Properties
	
	private  Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	//SessionFactory Bean
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		
		//Ecomerce Module
		
		//localSessionFactoryBuilder.addAnnotatedClass(User.class);
		
		//Colabration Module
		
		localSessionFactoryBuilder.addAnnotatedClass(Catagory.class);
		localSessionFactoryBuilder.addAnnotatedClass(User.class);
		localSessionFactoryBuilder.addAnnotatedClass(Product.class);
		
		localSessionFactoryBuilder.addAnnotatedClass(UserRole.class);
		localSessionFactoryBuilder.addAnnotatedClass(BillingAddress.class);
		localSessionFactoryBuilder.addAnnotatedClass(ShippingAddress.class);
		localSessionFactoryBuilder.addAnnotatedClass(Cart.class);
		localSessionFactoryBuilder.addAnnotatedClass(CartItem.class);
		localSessionFactoryBuilder.addAnnotatedClass(CartGroup.class);
		
		
		localSessionFactoryBuilder.addAnnotatedClass(UserOrder.class);
		
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	//Hibernate Transaction
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
		
	}
	

	    
}