package com.springboot.springbootactivemq.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import java.util.Queue;
import java.util.UUID;

@Component
public class QueueProduce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    public void productMsg(){
        jmsMessagingTemplate.convertAndSend((Destination) queue, UUID.randomUUID().toString().substring(0,6));
    }
}
