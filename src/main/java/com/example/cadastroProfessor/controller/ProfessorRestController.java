package com.example.cadastroProfessor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastroProfessor.model.Professor;
import com.example.cadastroProfessor.repository.ProfessorRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProfessorRestController {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@GetMapping("/professores")
	public List<Professor> listarProfessors(){
		
		List<Professor> listaProfessors = (List<Professor>) professorRepository.findAll(); 
		return listaProfessors;
	}
	
	@PostMapping("/cadastrar-professor")
	public void cadastrarProfessor(@RequestBody Professor professor) {
		
		professorRepository.save(professor);
	}
	 
	@GetMapping("/professor/{codigo}")
	public Professor procurarProfessor(@PathVariable long codigo) {
		
		Professor professor = professorRepository.findById(codigo);
		
		return professor;
	}
	
	@DeleteMapping("/deletar-professor/{codigo}")
	public void deletarProfessor(@PathVariable long codigo) {
		
		Professor professor = professorRepository.findById(codigo);
		
		professorRepository.delete(professor);
		
		
	}
	
	@PutMapping("/editar-professor")
	public void editarProfessor(@RequestBody Professor professor) {

		professorRepository.save(professor);
		
	}
	
}