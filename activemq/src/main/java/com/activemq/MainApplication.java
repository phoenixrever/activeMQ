package com.activemq;

import com.activemq.spring.springProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author phoenixhell
 * @create 2021/1/25 0025-下午 4:50
 */

public class MainApplication {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        springProducer producer = (springProducer) context.getBean("springProducer");
        System.out.println(producer);
    }
}
