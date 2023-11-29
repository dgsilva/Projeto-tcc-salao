package br.com.tcc.feuc.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.tcc.feuc.dto.request.AgendamentoRequestDTO;
import br.com.tcc.feuc.entities.Agendamento;
import br.com.tcc.feuc.repositories.AgendamentoRepository;

@Transactional
@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
	}
	
	public Agendamento create(AgendamentoRequestDTO dto) {
		validateAgendamento(dto);
		Agendamento agendamento = modelMapper.map(dto, Agendamento.class);
		return agendamentoRepository.save(agendamento);
	}
	
	public ResponseEntity<Agendamento> atualizar(Long idAgendamento,AgendamentoRequestDTO dto) {
		if (!agendamentoRepository.existsById(idAgendamento)) {
			return ResponseEntity.notFound().build();
		}
		Agendamento agendamento = new Agendamento();
		agendamento.setIdAgendamento(idAgendamento);
		agendamento = modelMapper.map(dto, Agendamento.class);
		agendamentoRepository.save(agendamento);
		return ResponseEntity.ok(agendamento);
	}
	
	public Agendamento buscarPorId(Long idAgendamento) {
		Optional<Agendamento> resultadoPorId = agendamentoRepository.findById(idAgendamento);
		Agendamento agendamento = resultadoPorId.get();
		return agendamento;
	}
	
	private void validateAgendamento(AgendamentoRequestDTO dto) {
        // Verificar antecedência mínima de 1 hora
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime dataHoraAgendamento = LocalDateTime.parse(dto.getData() + "T" + dto.getHora());
        if (dataHoraAgendamento.isBefore(agora.plusHours(1))) {
            throw new IllegalArgumentException("O agendamento deve ser feito com pelo menos 1 hora de antecedência.");
        }

        // Verificar se o mesmo horário já foi agendado
        List<AgendamentoRequestDTO> agendamentosNoMesmoHorario = agendamentoRepository.findByDataAndHora(dto.getData(), dto.getHora());
        if (!agendamentosNoMesmoHorario.isEmpty()) {
            throw new IllegalArgumentException("Este horário já está agendado para outro cliente.");
        }
    }
}
