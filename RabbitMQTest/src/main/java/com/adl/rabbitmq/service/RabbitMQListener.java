package com.adl.rabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adl.rabbitmq.model.MessageModel;
import com.adl.rabbitmq.repository.MessageRepository;
import com.google.gson.Gson;

@Service
public class RabbitMQListener implements MessageListener{

	MessageRepository mRepo;
	
	
	public RabbitMQListener(MessageRepository mRepo) {
		
		this.mRepo = mRepo;
	}



	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		//UNTUK CONVERT KE SPRING AGAR BISA DIPAKAI JPA
		String data = new String(message.getBody());
		Gson gson = new Gson();
		MessageModel message2 = gson.fromJson(data, MessageModel.class);
		mRepo.save(message2);
		//System.out.println("Consuming message : "+ new String (message.getBody()));
	}
	
}
