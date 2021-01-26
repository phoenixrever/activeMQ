package com.springboot.springbootactivemq.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;


/**
 * @author phoenixhell
 * @create 2021/1/26 0026-上午 10:58
 */
@Component
public class TopicProduce {
    @Autowired
    private Topic topic;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Scheduled(fixedDelay = 3000)
    private void topicProduce(){
        jmsMessagingTemplate.convertAndSend(topic,"topic"+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("topic send");
    }
}
