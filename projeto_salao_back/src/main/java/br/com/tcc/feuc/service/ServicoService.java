package br.com.tcc.feuc.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.tcc.feuc.dto.request.ServicoRequestDTO;
import br.com.tcc.feuc.dto.request.ServicoUpdateDTO;
import br.com.tcc.feuc.entities.Servico;
import br.com.tcc.feuc.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<Servico>findAll(){
		return servicoRepository.findAll();
	}
	
	public Servico create(ServicoRequestDTO dto) {
		Servico servico  = modelMapper.map(dto, Servico.class);
		return servicoRepository.save(servico);
		 
	}
	
    public ResponseEntity<Servico> atualizar(Long idServico,ServicoUpdateDTO dto) {
      if(!servicoRepository.existsById(idServico)) {
    	  return ResponseEntity.notFound().build();
      }
      Servico servico = new Servico();
      servico.setIdServico(idServico);
      servico = modelMapper.map(dto, Servico.class);
      servicoRepository.save(servico);	
     return ResponseEntity.ok(servico);
    }
    
	public Servico buscarPorId(Long idServico) {
		Optional<Servico> resultadoPorId = servicoRepository.findById(idServico);
		Servico servico = resultadoPorId.get();
		return servico;
	}
}
