package com.example.cadastroProfessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CadastroProfessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroProfessorApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}