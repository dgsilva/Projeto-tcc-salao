package br.com.tcc.feuc.dto.request;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tcc.feuc.entities.Profissional;
import lombok.Data;

@Data
public class ServicoRequestDTO {

	@NotBlank(message = "Informe o tipo de serviço do serviço.")
	private String tipoServico;
	@NotBlank(message = "Informe o descrição do serviço.")
	private String descricao;
	@NotBlank(message = "Informe o valor do serviço.")
	private String valor;
	@JsonIgnore
	private Profissional profissional;
	
}
