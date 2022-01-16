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
import br.com.tcc.feuc.entities.Servico;
import br.com.tcc.feuc.repositories.ServicoRepository;

@RestController
@RequestMapping("servicos")
public class ServicoControllers {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping
	public List<Servico>findAll(){
		List<Servico> servicoListar = servicoRepository.findAll();
		return servicoListar;
	}
	
	@PostMapping
	public Servico create(@RequestBody Servico servico) {
		Servico servicoSave = servicoRepository.save(servico);
		return servicoSave;
	}
	
	@PutMapping("/{idServico}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long idServico, @RequestBody Servico servico) {
      if(!servicoRepository.existsById(idServico)) {
    	  return ResponseEntity.notFound().build();
      }
      servico.setIdServico(idServico);
      servico = servicoRepository.save(servico);	
    	
    	return ResponseEntity.ok(servico);
    }
	
	@CrossOrigin("*")
	@GetMapping("/{idServico}")
	public Servico buscarPorId(@PathVariable Long idServico) {
		Optional<Servico> resultadoPorId = servicoRepository.findById(idServico);
		Servico servico = resultadoPorId.get();
		return servico;
	}
}
