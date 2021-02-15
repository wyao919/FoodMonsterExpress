package Config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "Controller", "Dao", "Service", "Config" })
@EnableTransactionManagement
@PropertySource({ "classpath:configInfo.properties", "classpath:email.properties" })
public class ExpressConfig implements WebMvcConfigurer {

	private final Environment environment;

	@Autowired
	public ExpressConfig(Environment environment) {
		this.environment = environment;
	}

	@Bean
	InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public DriverManagerDataSource getDataSource() {

		System.out.println(environment.getProperty("myjdbc.url"));
		System.out.println((environment.getProperty("myjdbc.username")));
		System.out.println(environment.getProperty("myjdbc.password"));
		System.out.println((environment.getProperty("myHibernate.packagesToScan")));

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty("myjdbc.url"));
		driverManagerDataSource.setUsername(environment.getProperty("myjdbc.username"));
		driverManagerDataSource.setPassword(environment.getProperty("myjdbc.password"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("myjdbc.driverClassName"));

		return driverManagerDataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(environment.getProperty("myHibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());

		return sessionFactory;

	}

	@Bean
	public Properties getHibernateProperties() {
		Properties hibiernateProperties = new Properties();
		hibiernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		hibiernateProperties.setProperty("hibernate.show_sql", "true");
//		hibiernateProperties.setProperty("hibernate.current_session_context_class", "thread");

		return hibiernateProperties;
	}

	@Bean // transaction manager instantiates SessionFactory
	public HibernateTransactionManager getTransactionManager() {

		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();

		hibernateTransactionManager.setSessionFactory(getSessionFactory().getObject());

		return hibernateTransactionManager;

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**") // this name can be anything. Spring uses 2 **
				.addResourceLocations("/resources/"); // this is the folder we created

		registry.addResourceHandler("/webjars/**") // this name can be anything. Spring uses 2 **
				.addResourceLocations("/webjars/"); // this is the folder we created
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	@Bean
	public JavaMailSender getJavaMailSender() {

		System.out.println(environment.getProperty("mail.host"));

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(environment.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(environment.getProperty("mail.userName"));
		javaMailSenderImpl.setPassword(environment.getProperty("mail.password"));

		// 2 ways to do this
//		javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port")));
		javaMailSenderImpl.setPort(getIntProperty("mail.port"));

		// this needs to be used for GMAIL since security is tight.
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		javaMailSenderImpl.setJavaMailProperties(mailProperties);

		return javaMailSenderImpl;
	}

	public int getIntProperty(String key) {

		String property = environment.getProperty(key);

		return Integer.parseInt(property);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("errormessage");

		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {

		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());

		return localValidatorFactoryBean;

	}
	
	@Bean
	public Validator getValidator()
	{
		return validator();
	}

}
