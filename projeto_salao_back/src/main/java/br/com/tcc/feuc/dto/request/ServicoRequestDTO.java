package br.com.tcc.feuc.dto.request;


import br.com.tcc.feuc.entities.Profissional;
import lombok.Data;

@Data
public class ServicoRequestDTO {

	private String tipoServico;
	private String descricao;
	private double valor;
	private Profissional profissional;
	
}
