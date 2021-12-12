package com.adl.rabbitmq.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.rabbitmq.model.MessageModel;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Integer> {

}
