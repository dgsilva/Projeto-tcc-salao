package br.com.tcc.feuc.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcc.feuc.dto.request.AgendamentoRequestDTO;
import br.com.tcc.feuc.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	List<AgendamentoRequestDTO> findByDataAndHora(LocalDate data, String hora);
}
