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
import br.com.tcc.feuc.service.ProfissionalService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("profissionais")
public class ProfissionalControllers {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@ApiOperation("Retornado a listas do profissionais ")
	@CrossOrigin("*")
	@GetMapping
	public List<Profissional>findAll(){
		List<Profissional> profissionalReturn = profissionalService.Listar();
		return profissionalReturn;
	}
	@ApiOperation("Salvando os dados do Profissional")
	@CrossOrigin("*")
	@PostMapping
	public Profissional create(@RequestBody Profissional profissional) {
		Profissional profi = profissionalService.Salvar(profissional);
		return profi;
	}
	
	@ApiOperation("Alterado os dados do profissional")
	@CrossOrigin("*")
	@PutMapping("/{idProfissional}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long idProfissional, @RequestBody Profissional profissional) {
      if(!profissionalRepository.existsById(idProfissional)) {
    	  return ResponseEntity.notFound().build();
      }
      profissional.setIdProfissional(idProfissional);
      profissional = profissionalRepository.save(profissional);	
    	
    	return ResponseEntity.ok(profissional);
    }

	@ApiOperation("Retornado a listas pelo id do profissional ")
	@CrossOrigin("*")
	@GetMapping("/{idProfissional}")
	public Profissional buscarPorId(@PathVariable Long idProfissional) {
		Optional<Profissional> resultadoPorId = profissionalRepository.findById(idProfissional);
		Profissional profissional = resultadoPorId.get();
		return profissional;
	}
}
