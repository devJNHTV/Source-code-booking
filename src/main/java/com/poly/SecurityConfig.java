package com.poly;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	 public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	// nguon du lieu la data src
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new CustomJdbcUserDetailsManager(dataSource);
	}
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}
	//
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());// ngan chan cac request gia lap// cross site Request forgecy
		http.cors(cors -> cors.disable()); // cross site resource sharing ngan chan chia se tai nguyen 
		
		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/booking/**").authenticated();
			auth.requestMatchers("/rest/authorities").hasAuthority("Directors");
			auth.requestMatchers("/admin/**").hasAnyAuthority("Staffs","Directors");
			auth.anyRequest().permitAll();
		});
		http.exceptionHandling(denied -> {
			denied.accessDeniedPage("/security/unauthoried");
		});

		http.formLogin(login -> {
			login.loginProcessingUrl("/security/login");// form login
			login.loginPage("/security/login/form"); //context path khi yc login
			login.defaultSuccessUrl("/security/login/success",false);
			login.failureUrl("/security/login/error");
			login.permitAll();
		}); 
		http.rememberMe().tokenValiditySeconds(86400).userDetailsService(userDetailsService(null));
        http.logout(logout -> logout.logoutUrl("/security/logoff")
                .logoutSuccessUrl("/security/logoff/success"));
        
//        http.oauth2Login(login -> {
//			login.successHandler((request, response, authentication) -> {
//				DefaultOidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
//				UserDetails user = User.withUsername(oidcUser.getEmail()).password("").roles("Customers").build();
//				Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//				SecurityContextHolder.getContext().setAuthentication(auth);
//				
//				DefaultSavedRequest savedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
//				if(savedRequest != null){
//					response.sendRedirect(savedRequest.getRedirectUrl());
//				} else {
//					response.sendRedirect("/security/login/success");
//				}
//			});
//		});
		return http.build();
}
}
