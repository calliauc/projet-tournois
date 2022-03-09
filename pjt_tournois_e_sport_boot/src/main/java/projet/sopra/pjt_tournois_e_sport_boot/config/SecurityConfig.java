package projet.sopra.pjt_tournois_e_sport_boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	// gestion des regles sur les URL
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		///// ADAPTER
		
		http.antMatcher("/**")
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf().disable()
			.authorizeHttpRequests()
				.antMatchers(HttpMethod.GET, "/api/utilisateur/search/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS,"/api/**").permitAll()
				.antMatchers(HttpMethod.POST,"/api/utilisateur/signup").permitAll() // ce lien existe-t-il vraiment ?
				.antMatchers(HttpMethod.GET).hasAnyRole("ADMIN")
				.antMatchers(HttpMethod.POST).hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT).hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
			.and()
			.httpBasic();
	}

	// gestion des utilisateurs
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
