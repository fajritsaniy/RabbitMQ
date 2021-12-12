package com.adl.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adl.rabbitmq.model.MessageModel;

@Service
public class SenderService {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	//CARA 2 CONSUME MESSAGE
//	@Value("${rabbit.queue}")
//	String queueName;
	
	@Value("${rabbit.exchange}")
	private String exchange;
	@Value("${rabbit.routingkey}")
	private String routingKey;
	
	public void publish(MessageModel msg) {
		rabbitTemplate.convertAndSend(exchange, routingKey, msg);
		System.out.println("msg = "+msg);
		
// CARA 2 CONSUME MESSAGE
//		MessageModel msg2 = (MessageModel) rabbitTemplate.receiveAndConvert(queueName);
//		System.out.println("msg = "+msg2.getSenderId());
	}
}
