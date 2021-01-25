package com.activemq.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * @author phoenixhell
 * @create 2021/1/25 0025-下午 4:50
 */

public class MainApplication {

    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    public static void main(String[] args) {

    }

    @Test
    public void producer() {
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplateQueue");
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("springAbdactivemq整合case1 queue");
                return textMessage;
            }
        });
        System.out.println("textMessage send complete");
    }

    @Test
    public void consumer(){
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplateQueue");
        System.out.println("textMessage receive complete");
        String textMessage= (String) jmsTemplate.receiveAndConvert();
        System.out.println(textMessage+"received");
    }

    //和TopicListenerProducer一样
    @Test
    public void TopicProducer(){
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplateTopic");
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("springAndActivemq整合case1 topic");
                return textMessage;
            }
        });
        System.out.println("topic textMessage send complete");
    }

    @Test
    public void TopicConsumer(){
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplateTopic");
        String textMessage= (String) jmsTemplate.receiveAndConvert();
        System.out.println("topic textMessage receive complete");
        System.out.println(textMessage+"received");
    }


}
