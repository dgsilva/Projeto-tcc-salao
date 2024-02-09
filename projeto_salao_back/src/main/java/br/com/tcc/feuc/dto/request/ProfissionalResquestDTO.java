package br.com.tcc.feuc.dto.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class ProfissionalResquestDTO {

	@Size(min = 6, max = 100, message = "Nome deve ter de 6 a 100 caracteres.")
	@NotBlank(message = "Informe o nome do profissional.")
	private String nome;
	@NotBlank(message = "Informe o bairro do profissional.")
	private String bairro;
	@NotBlank(message = "Informe o data de nascimento do profissional.")
	private String dataNascimento;
	@NotBlank(message = "Informe o celular do profissional.")
	private String celular;
	@NotBlank(message = "Informe o telefone do profissional.")
	private String telefone;
	@Email(message = "Informe um endereço de email válido.")
	@NotBlank(message = "Informe o email do profissional.")
	private String email;
	@CPF(message = "Informe um endereço de cpf válido.")
	@NotBlank(message = "Informe o cpf do profissional.")
	private String cpf;
	@NotBlank(message = "Informe o sexo do profissional.")
	private String sexo;
	
}
