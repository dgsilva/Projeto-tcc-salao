package br.com.tcc.feuc.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginPostRequest {

	private String email;
	private String senha;
	
}
