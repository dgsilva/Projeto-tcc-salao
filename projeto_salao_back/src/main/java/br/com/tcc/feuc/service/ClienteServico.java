package br.com.tcc.feuc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tcc.feuc.entities.Cliente;
import br.com.tcc.feuc.repositories.ClienteRepository;

@Service
@Transactional
public class ClienteServico {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente Salvar(@RequestBody Cliente cliente) {
		// REGRA: Não permitir o cadastro de um cliente com email duplicado
		if(clienteRepository.findByEmail(cliente.getEmail())!=null) {
			throw new IllegalArgumentException("O email informado já está cadastrado, tente outro.");
		}
		
		// REGRA: Não permitir o cadastro de um cliente com cpf duplicado
		
		if(clienteRepository.findByCpf(cliente.getCpf())!=null) {
			throw new IllegalArgumentException("O cpf informado já está cadastrado, tente outro.");
		}
		
		if(clienteRepository.findByTelefone(cliente.getTelefone())!=null) {
			throw new IllegalArgumentException("O telefone informado já está cadastrado, tente outro.");
		}
		
		Cliente clienteSave = clienteRepository.save(cliente);
		return clienteSave;
		
	}
	
	public List<Cliente>Listar(){
		List<Cliente> listar = clienteRepository.findAll();
		return listar;
	}
	
}
