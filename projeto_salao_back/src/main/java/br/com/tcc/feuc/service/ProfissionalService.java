package br.com.tcc.feuc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tcc.feuc.dto.request.ProfissionalResquestDTO;
import br.com.tcc.feuc.dto.request.ProfissionalUpdateDTO;
import br.com.tcc.feuc.entities.Profissional;
import br.com.tcc.feuc.repositories.ProfissionalRepository;

@Service
@Transactional
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public Profissional Salvar(@RequestBody ProfissionalResquestDTO dto) {

		// REGRA: Não permitir o cadastro de um cliente com email duplicado
		if (profissionalRepository.findByEmail(dto.getEmail()) != null) {
			throw new IllegalArgumentException("O email informado já está cadastrado, tente outro.");
		}

		// REGRA: Não permitir o cadastro de um cliente com cpf duplicado

		if (profissionalRepository.findByCpf(dto.getCpf()) != null) {
			throw new IllegalArgumentException("O cpf informado já está cadastrado, tente outro.");
		}

		if (profissionalRepository.findByTelefone(dto.getTelefone()) != null) {
			throw new IllegalArgumentException("O telefone informado já está cadastrado, tente outro.");
		}

		if (profissionalRepository.findByCelular(dto.getCelular()) != null) {
			throw new IllegalArgumentException("O celular informado já está cadastrado, tente outro.");
		}

		Profissional profi = modelMapper.map(dto, Profissional.class);
		return profissionalRepository.save(profi);
	}

	public List<Profissional> Listar() {
		List<Profissional> profissionalReturn = profissionalRepository.findAll();
		return profissionalReturn;
	}
	
	 public ResponseEntity<Profissional> atualizar(Long idProfissional, ProfissionalUpdateDTO dto) {
	      if(!profissionalRepository.existsById(idProfissional)) {
	    	  return ResponseEntity.notFound().build();
	      }
	      Profissional prof = new Profissional();
	      prof.setIdProfissional(idProfissional);
	      prof = modelMapper.map(dto, Profissional.class);	
	      profissionalRepository.save(prof);
	      return ResponseEntity.ok(prof);
	    }
	 
	 
	 public Profissional buscarPorId(Long idProfissional) {
			Optional<Profissional> resultadoPorId = profissionalRepository.findById(idProfissional);
			Profissional profissional = resultadoPorId.get();
			return profissional;
		}
	
}
