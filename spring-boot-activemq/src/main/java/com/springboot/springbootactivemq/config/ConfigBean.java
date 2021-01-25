package com.springboot.springbootactivemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@Configuration
//@ConfigurationProperties(prefix = "queue")
@EnableJms
public class ConfigBean {

    @Value("${queue.queueName}")
    private String queueName;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queueName);
    }
}
