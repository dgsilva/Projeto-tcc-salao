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

import br.com.tcc.feuc.dto.request.AgendamentoRequestDTO;
import br.com.tcc.feuc.entities.Agendamento;
import br.com.tcc.feuc.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Tag(name="Agendamento")
@RestController
@RequestMapping("agendamentos")
public class AgendamentoControllers {

	@Autowired
	private AgendamentoService agendamentoService;

	@Operation(summary = "Retornado a listas dos agendamentos ")
	@CrossOrigin("*")
	@GetMapping
	public List<Agendamento> findAll() {
		log.info("Listar todos dados de agendamento");
		return agendamentoService.findAll();
	}

	@Operation(summary = "Salvando os dados dos agendamentos")
	@CrossOrigin("*")
	@PostMapping
	public Agendamento create(@RequestBody AgendamentoRequestDTO dto) {
		log.info("Salvando os dados do agendamento");
		return agendamentoService.create(dto);
	}

	@Operation(summary = "Alterado os dados do agendamento")
	@CrossOrigin("*")
	@PutMapping("/{idAgendamento}")
	public ResponseEntity<Agendamento> atualizar(@PathVariable Long idAgendamento,
			@RequestBody AgendamentoRequestDTO dto) {
		log.info("Alterar os dados");
		return agendamentoService.atualizar(idAgendamento, dto);
	}

	@Operation(summary = "Fazendo a busca pelo id Agendamento")
	@CrossOrigin("*")
	@GetMapping("/{idAgendamento}")
	public Agendamento buscarPorId(@PathVariable Long idAgendamento) {
		log.info("Listar por id");
	    return agendamentoService.buscarPorId(idAgendamento);
		
	}
}
