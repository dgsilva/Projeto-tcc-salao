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


import br.com.tcc.feuc.entities.Agendamento;
import br.com.tcc.feuc.repositories.AgendamentoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Tag(name="Agendamento")
@RestController
@RequestMapping("agendamentos")
public class AgendamentoControllers {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Operation(summary = "Retornado a listas dos agendamentos ")
	@CrossOrigin("*")
	@GetMapping
	public List<Agendamento> findAll() {
		log.info("Listar todos dados de agendamento");
		List<Agendamento> agendamentoListar = agendamentoRepository.findAll();
		return agendamentoListar;
	}

	@Operation(summary = "Salvando os dados dos agendamentos")
	@CrossOrigin("*")
	@PostMapping
	public Agendamento create(@RequestBody Agendamento agendamento) {
		log.info("Salvando os dados do agendamento");
		Agendamento agendamentoSave = agendamentoRepository.save(agendamento);
		return agendamentoSave;
	}

	@Operation(summary = "Alterado os dados do agendamento")
	@CrossOrigin("*")
	@PutMapping("/{idAgendamento}")
	public ResponseEntity<Agendamento> atualizar(@PathVariable Long idAgendamento,
			@RequestBody Agendamento agendamento) {
		if (!agendamentoRepository.existsById(idAgendamento)) {
			return ResponseEntity.notFound().build();
		}
		agendamento.setIdAgendamento(idAgendamento);
		agendamento = agendamentoRepository.save(agendamento);
		log.info("Alterar os dados");
		return ResponseEntity.ok(agendamento);
	}

	@Operation(summary = "Fazendo a busca pelo id Agendamento")
	@CrossOrigin("*")
	@GetMapping("/{idAgendamento}")
	public Agendamento buscarPorId(@PathVariable Long idAgendamento) {
		log.info("Listar por id");
		Optional<Agendamento> resultadoPorId = agendamentoRepository.findById(idAgendamento);
		Agendamento agendamento = resultadoPorId.get();
		return agendamento;
	}
}
