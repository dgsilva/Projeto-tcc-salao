package br.com.tcc.feuc.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	private final String queuename;

	public RabbitMQConfig(@Value("${queue.name}") String queuename) {
		this.queuename = queuename;
	}

	@Bean
	public Queue queue() {
		return new Queue(queuename);
	}

}
