package br.com.tcc.feuc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.feuc.entities.Cliente;
import br.com.tcc.feuc.repositories.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping()
	public List<Cliente>findAll(){
		List<Cliente> listar = clienteRepository.findAll();
		return listar;
	}
	
	@PostMapping()
	public Cliente save(@RequestBody Cliente cliente) {
		Cliente clienteSave = clienteRepository.save(cliente);
		return clienteSave;
	}
}
