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

import com.example.cadastroProfessor.repository.ProfessorRepository;
import com.example.cadastroProfessor.repository.TurmaRepository;
import com.example.cadastroProfessor.model.Turma;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TurmaRestController {
	
	@Autowired
	ProfessorRepository profRepo;
	
	@Autowired
	TurmaRepository turmaRepo;
	
	@GetMapping("/turmas")
	public List<Turma> listarTurmas() {
		
		List<Turma> listaTurmas = (List<Turma>) turmaRepo.findAll();
		return listaTurmas;
	}
	
	@GetMapping("/turma/{codigo}")
	public Turma consultaTurma(@PathVariable long codigo) {
		
		Turma turma= turmaRepo.findById(codigo);
		return turma;
	}

	@PostMapping("/cadastrar-turma/{matricula}")
	public void cadastrarTurma(@RequestBody Turma turma, @PathVariable long matricula) {
		
		turma.setProfessor(profRepo.findById(matricula));
		turmaRepo.save(turma);
	}

	@DeleteMapping("/excluir-turma/{codigo}")
	public void excluirTurma(@PathVariable long codigo) {
		
		Turma turma = turmaRepo.findById(codigo);
		turmaRepo.delete(turma);
	}
	
	@PutMapping("/editar-turma/{matricula}")
	public void editarTurma(@RequestBody Turma turma, @PathVariable long matricula) {
		
		turma.setProfessor(profRepo.findById(matricula));
		turmaRepo.save(turma);
	}
}
