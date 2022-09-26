package com.java.user.config;


import java.util.Properties;





import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



import com.java.user.entities.User;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.java.user.*")
public class SpringConfig 
{
	static
	{
		System.out.println("Spring Config loaded.....");
	}
	
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root123");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/Spring_user");
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return basicDataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getFactory()
	{
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setAnnotatedClasses(User.class);
		
		Properties prop=new Properties();
		prop.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect"); 
		prop.put(Environment.HBM2DDL_AUTO,"update");
		prop.put(Environment.SHOW_SQL,true);
		
		bean.setHibernateProperties(prop);
		return bean;
		
	}
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/pages/");	
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
	

}
