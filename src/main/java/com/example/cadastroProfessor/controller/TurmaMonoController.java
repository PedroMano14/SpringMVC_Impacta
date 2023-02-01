package com.example.cadastroProfessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.cadastroProfessor.model.Professor;
import com.example.cadastroProfessor.model.Turma;
import com.example.cadastroProfessor.repository.ProfessorRepository;
import com.example.cadastroProfessor.repository.TurmaRepository;

@Controller
public class TurmaMonoController {

	@Autowired
	TurmaRepository turmaRepository;
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@RequestMapping(value ="cadastrar-turma/{codigo}", method = RequestMethod.GET)
	public ModelAndView cadastrarTurma(@PathVariable("codigo") long codigo) {
		Professor professor = professorRepository.findById(codigo);
		ModelAndView modelAndViewProfessor = new ModelAndView("cadastrarTurma");
		modelAndViewProfessor.addObject("professor", professor);
		return modelAndViewProfessor;
		
	}
	
	@RequestMapping(value ="cadastrar-turma/{codigo}", method = RequestMethod.POST)
	public String cadastrarTurmaMetodoPost(@PathVariable("codigo") long codigo, Turma turma) {
		Professor professor = professorRepository.findById(codigo);
		turma.setProfessor(professor);
		turmaRepository.save(turma);
		return "redirect:/listar-professores";
		
	}
	
	@RequestMapping("/listar-turmas")
	public ModelAndView listarTurmas() {
		
		ModelAndView mvTurma = new ModelAndView("listarTurmas");
		Iterable<Turma> turmas = turmaRepository.findAll();
		mvTurma.addObject("turmas", turmas);

		return mvTurma;
	}
}
