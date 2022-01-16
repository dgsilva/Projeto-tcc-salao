package br.com.tcc.feuc.controllers;

import java.util.List;
import java.util.Optional;

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

import br.com.tcc.feuc.entities.Profissional;
import br.com.tcc.feuc.repositories.ProfissionalRepository;

@RestController
@RequestMapping("profissionais")
public class ProfissionalControllers {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@GetMapping
	public List<Profissional>findAll(){
		List<Profissional> profissionalReturn = profissionalRepository.findAll();
		return profissionalReturn;
	}
	
	@PostMapping
	public Profissional create(@RequestBody Profissional profissional) {
		Profissional profi = profissionalRepository.save(profissional);
		return profi;
	}
	
	@PutMapping("/{idProfissional}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long idProfissional, @RequestBody Profissional profissional) {
      if(!profissionalRepository.existsById(idProfissional)) {
    	  return ResponseEntity.notFound().build();
      }
      profissional.setIdProfissional(idProfissional);
      profissional = profissionalRepository.save(profissional);	
    	
    	return ResponseEntity.ok(profissional);
    }

	@CrossOrigin("*")
	@GetMapping("/{idProfissional}")
	public Profissional buscarPorId(@PathVariable Long idProfissional) {
		Optional<Profissional> resultadoPorId = profissionalRepository.findById(idProfissional);
		Profissional profissional = resultadoPorId.get();
		return profissional;
	}
}
