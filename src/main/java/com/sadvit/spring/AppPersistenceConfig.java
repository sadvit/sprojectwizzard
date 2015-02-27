package com.sadvit.spring;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan({"com.sadvit"})
@EnableTransactionManagement
public class AppPersistenceConfig {

	@Bean
	@Autowired
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.sadvit"); // TODO check
		sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:hsql:database/testdb");
		dataSource.setUsername("sa");
		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.setCheckWriteOperations(false);
		return hibernateTemplate;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
        return prop;
    }

}