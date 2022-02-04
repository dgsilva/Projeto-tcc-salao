package br.com.tcc.feuc.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.server.ResponseStatusException;

import br.com.tcc.feuc.entities.Cliente;
import br.com.tcc.feuc.repositories.ClienteRepository;
import br.com.tcc.feuc.service.ClienteServico;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteServico clienteServico;

	@ApiOperation("Retornado a listas dos clientes ")
	@CrossOrigin("*")
	@GetMapping()
	public List<Cliente> findAll() {
		List<Cliente> listar = clienteServico.Listar();
		return listar;
	}

	@ApiOperation("Salvando os dados dos clientes ")
	@CrossOrigin("*")
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody Cliente cliente) {
		Cliente clienteSave = clienteServico.Salvar(cliente);
		return clienteSave;
	}

	@ApiOperation("Retornado a lista pelo id do cliente ")
	@CrossOrigin("*")
	@GetMapping("/{idCliente}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long idCliente) {

		if (!clienteRepository.existsById(idCliente)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado no banco de dados");
		}

		Optional<Cliente> resultadoPorId = clienteRepository.findById(idCliente);
		Cliente cliente = resultadoPorId.get();
		return ResponseEntity.ok(cliente);
	}

	@ApiOperation("Alterado os dados do cliente")
	@CrossOrigin(origins = "*")
	@PutMapping("/{idCliente}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long idCliente, @RequestBody Cliente cliente) {

		if (!clienteRepository.existsById(idCliente)) {
			return ResponseEntity.notFound().build();

		}
		cliente.setIdCliente(idCliente);
		cliente = clienteRepository.save(cliente);

		return ResponseEntity.ok(cliente);
	}
}
