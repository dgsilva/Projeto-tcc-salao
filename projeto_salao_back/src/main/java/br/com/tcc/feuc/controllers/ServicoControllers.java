package br.com.tcc.feuc.controllers;

import java.util.List;

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

import br.com.tcc.feuc.dto.request.ServicoRequestDTO;
import br.com.tcc.feuc.dto.request.ServicoUpdateDTO;
import br.com.tcc.feuc.entities.Servico;
import br.com.tcc.feuc.service.ServicoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("servicos")
public class ServicoControllers {

	@Autowired
	private ServicoService serviceService;
	
	@Operation(summary = "Retornado a listas dos serviços ")
	@CrossOrigin("*")
	@GetMapping
	public List<Servico>findAll(){
		return serviceService.findAll();
	}
	@Operation(summary = "Salvando os dados dos serviços")
	@CrossOrigin("*")
	@PostMapping
	public Servico create(@RequestBody ServicoRequestDTO dto) {
		return serviceService.create(dto);
		
	}
	@Operation(summary = "Alterado os dados dos serviços")
	@CrossOrigin("*")
	@PutMapping("/{idServico}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long idServico, @RequestBody ServicoUpdateDTO dto) {
     return  serviceService.atualizar(idServico, dto);	
  
    }
	@Operation(summary = "Retornado a busca por id do servicos ")
	@CrossOrigin("*")
	@GetMapping("/{idServico}")
	public Servico buscarPorId(@PathVariable Long idServico) {
		return serviceService.buscarPorId(idServico);
	}
}
