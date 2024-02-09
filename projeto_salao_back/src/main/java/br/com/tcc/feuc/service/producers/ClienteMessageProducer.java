package br.com.tcc.feuc.service.producers;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteMessageProducer {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	Queue queue;
	
	/*
	 * Método para gravar uma mensagem na fila
	 */
	public void sendMessage(String messege) {
		String queueName = queue.getName();
		System.out.println("Queue Name: " + queueName);
		rabbitTemplate.convertAndSend(queue.getName(), messege);
	}
}
