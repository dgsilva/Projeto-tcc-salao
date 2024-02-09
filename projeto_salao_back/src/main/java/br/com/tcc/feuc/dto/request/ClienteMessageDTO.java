package br.com.tcc.feuc.dto.request;

import lombok.Data;

@Data
public class ClienteMessageDTO {
	
	private String emailTo;
	private String subject;
	private String body;

}
