package Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	private final DataSource dataSource;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public SpringSecurityConfig(DataSource dataSource, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.dataSource = dataSource;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("Select username, password, enabled from user_accounts where username =?")
				.authoritiesByUsernameQuery("Select username, roles from user_accounts where username = ?")
				.passwordEncoder(bCryptPasswordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.authorizeRequests()
				.antMatchers("/placeOrderPage**").permitAll()
				.antMatchers("/cart/**").authenticated()
				.antMatchers("/updatePw").hasRole("USER")
				.antMatchers("/login**", "/register/**").anonymous()
				.and()
				.formLogin()
				.loginPage("/login").defaultSuccessUrl("/placeOrderPage", true)
				.and()
				.logout()
				.logoutUrl("/logout").permitAll()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/login").and().exceptionHandling().accessDeniedPage("/accessDenied");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/webjars/**");
	}


	@Bean
	JdbcUserDetailsManager jdbcUserDetailsManager()
	{
		
//		AuthenticationManagerBuilder
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManager.setUsersByUsernameQuery("Select username, password, enabled from user_accounts where username =?");
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("Select username, roles from user_accounts where username = ?");
		jdbcUserDetailsManager.setChangePasswordSql("update user_accounts set password =? where username =?");
		jdbcUserDetailsManager.setDeleteUserSql("delete from user_accounts where username = ?");
//		jdbcUserDetailsManager.setAuthenticationManager(AuthenticationManager authenticationManager());


		return jdbcUserDetailsManager;
	}



}
