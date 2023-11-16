package br.com.tcc.feuc.dto.request;

import lombok.Data;

@Data
public class ProfissionalUpdateDTO {
	
	private Long idProfissional;
	private String nome;
	private String bairro;
	private String dataNascimento;
	private String celular;
	private String telefone;
	private String email;
	private String cpf;
	private String sexo;

}
