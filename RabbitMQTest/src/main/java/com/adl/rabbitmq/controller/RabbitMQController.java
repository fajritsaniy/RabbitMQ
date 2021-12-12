package com.adl.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adl.rabbitmq.model.MessageModel;
import com.adl.rabbitmq.service.SenderService;

@RestController
public class RabbitMQController {

	@Autowired
	SenderService send;
	
	
	@GetMapping("/")
	public String rabbitSend(@RequestParam("senderId") int senderId, @RequestParam("message") String message) {
		MessageModel msg = new MessageModel();
		msg.setSenderId(senderId);
		msg.setMessage(message);
		send.publish(msg);
		
		return "message berhasil dikirim";
	}
}
