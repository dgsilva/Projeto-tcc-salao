package br.com.tcc.feuc.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@CrossOrigin("*")
	@GetMapping()
	public List<Cliente>findAll(){
		List<Cliente> listar = clienteRepository.findAll();
		return listar;
	}
	@CrossOrigin("*")
	@PostMapping()
	public Cliente save(@RequestBody Cliente cliente) {
		Cliente clienteSave = clienteRepository.save(cliente);
		return clienteSave;
	}
	
	@CrossOrigin("*")
	@GetMapping("/{idCliente}")
	public Cliente buscarPorId(@PathVariable Long idCliente) {
		Optional<Cliente> resultadoPorId = clienteRepository.findById(idCliente);
		Cliente cliente = resultadoPorId.get();
		return cliente;
	}
	
	 @CrossOrigin(origins = "*")
	    @PutMapping("/{idCliente}")
	    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long idCliente, @RequestBody Cliente cliente) {
	      if(!clienteRepository.existsById(idCliente)) {
	    	  return ResponseEntity.notFound().build();
	      }
	        cliente.setIdCliente(idCliente);
	    	cliente = clienteRepository.save(cliente);	
	    	
	    	return ResponseEntity.ok(cliente);
	    }
}
