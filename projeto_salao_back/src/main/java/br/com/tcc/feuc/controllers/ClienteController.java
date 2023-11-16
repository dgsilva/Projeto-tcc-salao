package br.com.tcc.feuc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.tcc.feuc.dto.request.ClienteRequestDTO;
import br.com.tcc.feuc.dto.request.ClienteUpdateRequest;
import br.com.tcc.feuc.entities.Cliente;
import br.com.tcc.feuc.service.ClienteServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Tag(description = "Conjunto de endpoints para manipulação do Cliente" , name = "Cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteServico clienteServico;

	@Operation(summary = "Retornado a listas dos clientes ")
	@CrossOrigin("*")
	@GetMapping()
	public List<Cliente> findAll() {
		log.info("Listar todos dados de cliente");
		return clienteServico.Listar();
	}

	@Operation(summary = "Salvando os dados dos clientes ")
	@CrossOrigin("*")
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody ClienteRequestDTO dto) {
		log.info("Salvar todos dados de cliente");
		return clienteServico.Salvar(dto);
	}

	@Operation(summary = "Retornado a lista pelo id do cliente ")
	@CrossOrigin("*")
	@GetMapping("/{idCliente}")
	public Cliente buscarPorId(@PathVariable Long idCliente) {
		return clienteServico.buscarPorId(idCliente);
	}

	@Operation(summary = "Alterado os dados do cliente")
	@CrossOrigin(origins = "*")
	@PutMapping("/{idCliente}")
	public ResponseEntity<ResponseEntity<Cliente>> atualizar(@Valid @PathVariable Long idCliente, @RequestBody ClienteUpdateRequest dto) {
		log.info("Update dos dados clientes");
		ResponseEntity<Cliente> dtoUpdate = clienteServico.atualizar(idCliente, dto);
		return ResponseEntity.ok(dtoUpdate);
	}
}
