package fr.livre.business.common;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.livre.business.common.SpringApplicationContext;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="fr.livre.business.* , fr.livre.persistance.*")
public class AppConfig {
	
	
	/** Jndi banque name **/
	private static final String JNDI_LIVRE_NAME = "java:comp/env/jdbc/LivreDB";
	
	private static final String LIVRE_DATASOURCE_NAME = "livreDataSource";
	
	private static final String SESSION_FACTORY = "sessionFactory";
	
	public static final String TRANSACTION_MANAGER = "transactionManager";	
	
	public static final String HIBERNATE_DAO_TEMPLATE = "hibernateTemplateDao";
	
	
	@Bean(name=LIVRE_DATASOURCE_NAME)
	public DataSource livreDataSource(){
		JndiDataSourceLookup datasourceLookup = new JndiDataSourceLookup();
		return datasourceLookup.getDataSource(JNDI_LIVRE_NAME);
	}
	
	@Bean(name=TRANSACTION_MANAGER)
	public PlatformTransactionManager dbTransactionManager(ApplicationContext context){
		HibernateTransactionManager hibernateTrasactionManager = new HibernateTransactionManager();
		hibernateTrasactionManager.setSessionFactory(context.getBean(SESSION_FACTORY,SessionFactory.class));
		return hibernateTrasactionManager;
	}
		
	@Bean(name=SESSION_FACTORY)
	public LocalSessionFactoryBean  localSessionFactoryBean(ApplicationContext context){
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(context.getBean(LIVRE_DATASOURCE_NAME, DataSource.class));
		localSessionFactoryBean.setMappingResources("fr/livre/persistance/user/User.hbm.xml","fr/livre/persistance/user/Role.hbm.xml");	
	    localSessionFactoryBean.setHibernateProperties(this.hibernateProperties());
	    
	    return localSessionFactoryBean;
	}
	
	@Bean(HIBERNATE_DAO_TEMPLATE)
	public HibernateTemplate hibernateTemplate(ApplicationContext context){
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(context.getBean(SESSION_FACTORY,SessionFactory.class));
		return hibernateTemplate;		
	}

	
	/**
	 * Set the hibernate properties
	 * 
	 * @return
	 */
	private Properties hibernateProperties(){
		Properties props=new Properties();
	    props.put(AvailableSettings.DIALECT, MySQL5Dialect.class.getName());
	    props.put(AvailableSettings.SHOW_SQL, "true");
	    props.put(AvailableSettings.AUTOCOMMIT, "false");
	    return props;
	}
	
		
	@Bean
	public SpringApplicationContext springApplicationContext(){
		return new SpringApplicationContext();
	}
	
}
