package com.example.cadastroProfessor.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cadastroProfessor.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,String>{
	
	Usuario findByLogin(String login);

}
