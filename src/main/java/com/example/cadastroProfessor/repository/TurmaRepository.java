package com.example.cadastroProfessor.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cadastroProfessor.model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, Long> {
	Turma findById(long codigo);
}