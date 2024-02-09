package br.com.tcc.feuc.controllers;

import java.util.List;

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

import br.com.tcc.feuc.dto.request.ProfissionalResquestDTO;
import br.com.tcc.feuc.dto.request.ProfissionalUpdateDTO;
import br.com.tcc.feuc.entities.Profissional;
import br.com.tcc.feuc.service.ProfissionalService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("profissionais")
public class ProfissionalControllers {
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@Operation(summary = "Retornado a listas do profissionais ")
	@CrossOrigin("*")
	@GetMapping
	public List<Profissional>findAll(){
		List<Profissional> profissionalReturn = profissionalService.Listar();
		return profissionalReturn;
	}
	@Operation(summary = "Salvando os dados do Profissional")
	@CrossOrigin("*")
	@PostMapping
	public Profissional create(@Valid @RequestBody ProfissionalResquestDTO dto) {
		return profissionalService.Salvar(dto);
	}
	
	@Operation(summary = "Alterado os dados do profissional")
	@CrossOrigin("*")
	@PutMapping("/{idProfissional}")
    public ResponseEntity<ResponseEntity<Profissional>> atualizar(@PathVariable Long idProfissional, @RequestBody ProfissionalUpdateDTO dto) {
		ResponseEntity<Profissional>dtoUpdate = profissionalService.atualizar(idProfissional, dto);
    	return ResponseEntity.ok(dtoUpdate);
    }

	@Operation(summary =  "Retornado a listas pelo id do profissional ")
	@CrossOrigin("*")
	@GetMapping("/{idProfissional}")
	public Profissional buscarPorId(@PathVariable Long idProfissional) {
		return  profissionalService.buscarPorId(idProfissional);
	}
}
