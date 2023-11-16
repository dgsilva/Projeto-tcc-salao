package br.com.tcc.feuc.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import br.com.tcc.feuc.dto.request.ClienteRequestDTO;
import br.com.tcc.feuc.dto.request.ClienteUpdateRequest;
import br.com.tcc.feuc.entities.Cliente;
import br.com.tcc.feuc.repositories.ClienteRepository;

@Service
@Transactional
public class ClienteServico {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public Cliente Salvar(@RequestBody ClienteRequestDTO dto) {
		// REGRA: Não permitir o cadastro de um cliente com email duplicado
		if(clienteRepository.findByEmail(dto.getEmail())!=null) {
			throw new IllegalArgumentException("O email informado já está cadastrado, tente outro.");
		}
		
		// REGRA: Não permitir o cadastro de um cliente com cpf duplicado
		
		if(clienteRepository.findByCpf(dto.getCpf())!=null) {
			throw new IllegalArgumentException("O cpf informado já está cadastrado, tente outro.");
		}
		
		if(clienteRepository.findByTelefone(dto.getTelefone())!=null) {
			throw new IllegalArgumentException("O telefone informado já está cadastrado, tente outro.");
		}
		
		Cliente clienteSave = modelMapper.map(dto, Cliente.class);
		return  clienteRepository.save(clienteSave);
	}
	
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long idCliente, @RequestBody ClienteUpdateRequest dto) {
		if (!clienteRepository.existsById(idCliente)) {
			return ResponseEntity.notFound().build();

		}
		Cliente cliente = new Cliente(); 
		cliente.setIdCliente(idCliente);
		cliente = modelMapper.map(dto, Cliente.class);
		clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	
	public Cliente buscarPorId(@PathVariable Long idCliente) {
		if (!clienteRepository.existsById(idCliente)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado no banco de dados");
		}
		Optional<Cliente> resultadoPorId = clienteRepository.findById(idCliente);
		Cliente cliente = resultadoPorId.get();
		return cliente;
	}
	
	public List<Cliente>Listar(){
		List<Cliente> listar = clienteRepository.findAll();
		return listar;
	}
	
}
