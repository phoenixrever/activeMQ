package com.springboot.springbootactivemq.config;

import lombok.Data;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

/**
 * @author phoenixhell
 * @create 2021/1/26 0026-上午 10:45
 */
@Configuration
//@Data
//@ConfigurationProperties(prefix = "topic")
public class TopicBean {
    @Value("${topic.topicName}")
    private String topicName;

    @Bean
    public Topic topic(){
        System.out.println(topicName);
        return new ActiveMQTopic(topicName);
    }
}
