package br.com.tcc.feuc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.feuc.entities.Administrador;
import br.com.tcc.feuc.repositories.AdmRepository;

@RestController
@RequestMapping("/Administrador")
public class AdministradorController {

	@Autowired
	private AdmRepository admRepository;
	
	@GetMapping()
	public List<Administrador>FindAll(){
		List<Administrador> lista = admRepository.findAll();
		return lista;
	}
	
	
	
}
