package com.springboot.springbootactivemq.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * @author phoenixhell
 * @create 2021/1/26 0026-上午 11:15
 */
@Component
public class TopicConsumer {

    @JmsListener(destination = "${topic.topicName}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("consumer received"+textMessage.getText()); }
}
