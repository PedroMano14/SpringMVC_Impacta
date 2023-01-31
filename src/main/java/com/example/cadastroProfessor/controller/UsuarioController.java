package com.example.cadastroProfessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.cadastroProfessor.model.Usuario;
import com.example.cadastroProfessor.repository.UsuarioRepository;


@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@RequestMapping("/cadastro-usuario")
	public String cadastrarUsuarioMetodo() {
		
		return "cadastrarUsuario";
	}
	
	@RequestMapping(value="/cadastro-usuario", method=RequestMethod.POST)
	public String cadastrarUsuarioMetedo(Usuario usuario) {
		
		
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		
		
		usuarioRepository.save(usuario);
		
		
		return "redirect:/gerenciar-usuario";
	}
	
	
	@RequestMapping("/gerenciar-usuario")
	public ModelAndView cadastrarUsuarioGet() {
		
		ModelAndView modelAndViewUsuario = new ModelAndView("gerenciarUsuario");
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		
		
		
		modelAndViewUsuario.addObject("usuarios", usuarios);
		
		
		return modelAndViewUsuario;
		
		
	}
	
	
	@RequestMapping("/deletar-usuario")
	public String deletarUsuario(String login) {
		Usuario usuario = usuarioRepository.findByLogin(login);
		
		usuarioRepository.delete(usuario);
		
		return "redirect:/gerenciar-usuario";
	}
	


}
