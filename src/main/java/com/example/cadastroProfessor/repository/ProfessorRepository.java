package com.example.cadastroProfessor.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.cadastroProfessor.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
	Professor findById(long codigo);
}