package br.com.tcc.feuc.dto.request;



import java.time.LocalDate;

import br.com.tcc.feuc.entities.Cliente;
import br.com.tcc.feuc.entities.Profissional;
import br.com.tcc.feuc.entities.Servico;
import lombok.Data;

@Data
public class AgendamentoRequestDTO {

	private Long idAgendamento;
	private LocalDate data;
	private String hora;
	private Cliente cliente;
	private Profissional profissional;
	private Servico servico;
}
