package br.com.tcc.feuc.service.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tcc.feuc.components.MailSenderComponent;
import br.com.tcc.feuc.dto.request.ClienteMessageDTO;


@Service
public class ClienteMessageConsumer {
	
//	@Autowired
//	MailSenderComponent mailSenderComponent;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@RabbitListener(queues = { "${queue.name}" })
	public void receive(@Payload String message) {
		try {
			
			//deserializar a mensagem gravada na fila
			ClienteMessageDTO dto = objectMapper.readValue(message, ClienteMessageDTO.class);
			
			//enviar por email
//			mailSenderComponent.sendMessage(dto.getEmailTo(), dto.getSubject(), dto.getBody());			
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}	

}
