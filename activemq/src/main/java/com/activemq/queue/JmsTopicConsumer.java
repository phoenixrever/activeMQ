package com.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author phoenixhell
 * @create 2021/1/24 0024-下午 4:10
 */

public class JmsTopicConsumer {
    public static final String ACTIVEMQ_URL="tcp://192.168.1.100:61616";
    public static final String TOPIC_NAME="jdbc-topic-persistent";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("------------------shadow------------------");
        ActiveMQConnectionFactory activeMQConnectionFactory
                =new ActiveMQConnectionFactory("admin","admin",ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("shadow");
        //transacted 事务   acknowledgeMode 签收
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建destination queue 还是 topic  queue topic  是destination的子接口
        Topic topic = session.createTopic(TOPIC_NAME);
        //订阅topic
        TopicSubscriber topicSubscriber=session.createDurableSubscriber(topic, "remark...");
        connection.start();

        Message message = topicSubscriber.receive();
        while (true) {
            if(message!=null && message instanceof TextMessage){
                TextMessage textMessage=(TextMessage)message;
                System.out.println("receive Durable topic message"+textMessage.getText());
                //在while下继续监听
                message = topicSubscriber.receive(3000L);
            }else{
                break;
            }
        }
        session.close();
        connection.close();
        System.out.println("message complete");
    }
}
