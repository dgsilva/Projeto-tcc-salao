package br.com.tcc.feuc.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {

	private Integer statusCode;
	private String mensagem;
	private String accessToken;
	private String nomeUsuario;
	private String emailUsuario;
}
