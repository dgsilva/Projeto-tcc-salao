package br.com.tcc.feuc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.feuc.repositories.AdmRepository;

@RestController
public class LoginController {

	@Autowired
	private AdmRepository admRepositorio;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String>post(){
		return null;
	}
}
