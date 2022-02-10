package br.com.tcc.feuc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tcc.feuc.entities.Profissional;
import br.com.tcc.feuc.repositories.ProfissionalRepository;

@Service
@Transactional
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public Profissional Salvar(@RequestBody Profissional profissional) {
		
		// REGRA: Não permitir o cadastro de um cliente com email duplicado
				if(profissionalRepository.findByEmail(profissional.getEmail())!=null) {
					throw new IllegalArgumentException("O email informado já está cadastrado, tente outro.");
				}
				
				// REGRA: Não permitir o cadastro de um cliente com cpf duplicado
				
				if(profissionalRepository.findByCpf(profissional.getCpf())!=null) {
					throw new IllegalArgumentException("O cpf informado já está cadastrado, tente outro.");
				}
				
				if(profissionalRepository.findByTelefone(profissional.getTelefone())!=null) {
					throw new IllegalArgumentException("O telefone informado já está cadastrado, tente outro.");
				}
				

				if(profissionalRepository.findByCelular(profissional.getCelular())!=null) {
					throw new IllegalArgumentException("O celular informado já está cadastrado, tente outro.");
				}
		
		Profissional profi = profissionalRepository.save(profissional);
		return profi;
	}
	public List<Profissional>Listar(){
		List<Profissional> profissionalReturn = profissionalRepository.findAll();
		return profissionalReturn;
	}
}
