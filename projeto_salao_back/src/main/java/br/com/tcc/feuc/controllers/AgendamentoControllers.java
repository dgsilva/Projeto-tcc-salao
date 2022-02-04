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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoControllers {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@ApiOperation("Retornado a listas dos agendamentos ")
	@CrossOrigin("*")
	@GetMapping
	public List<Agendamento> findAll() {
		List<Agendamento> agendamentoListar = agendamentoRepository.findAll();
		return agendamentoListar;
	}

	@ApiOperation("Salvando os dados dos agendamentos")
	@CrossOrigin("*")
	@PostMapping
	public Agendamento create(@RequestBody Agendamento agendamento) {
		Agendamento agendamentoSave = agendamentoRepository.save(agendamento);
		return agendamentoSave;
	}

	@ApiOperation("Alterado os dados do agendamento")
	@CrossOrigin("*")
	@PutMapping("/{idAgendamento}")
	public ResponseEntity<Agendamento> atualizar(@PathVariable Long idAgendamento,
			@RequestBody Agendamento agendamento) {
		if (!agendamentoRepository.existsById(idAgendamento)) {
			return ResponseEntity.notFound().build();
		}
		agendamento.setIdAgendamento(idAgendamento);
		agendamento = agendamentoRepository.save(agendamento);

		return ResponseEntity.ok(agendamento);
	}

	@ApiOperation("Fazendo a busca pelo id Agendamento")
	@CrossOrigin("*")
	@GetMapping("/{idAgendamento}")
	public Agendamento buscarPorId(@PathVariable Long idAgendamento) {
		Optional<Agendamento> resultadoPorId = agendamentoRepository.findById(idAgendamento);
		Agendamento agendamento = resultadoPorId.get();
		return agendamento;
	}
}
