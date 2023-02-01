package com.example.cadastroProfessor.security;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Transactional
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http // objeto do tipo HttpSecurity 
		.authorizeRequests().antMatchers(HttpMethod.POST).permitAll()
		.and() // Conexão de instruções
		.formLogin()//Indica que terá uma pagina com formulario de Login
		.loginPage("/login")// Indica a pagina HTML que será usada para o Login
		.defaultSuccessUrl("/listar-professores") // Indica a pagina que será apresentada apos a realização do Login
		.permitAll() // Todos os Usuarios logodos possuem permissão para acessar a Index
		.and() // Conexão de instruções
		.logout()//Indica que a aplicação terá logout
		.permitAll().and()
		.csrf().disable();//Permite que todos logados podem fazer logout
    return http.build();
		
	}
	
	
	private Object authorizeRequests() {
		// TODO Auto-generated method stub
		return null;
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}