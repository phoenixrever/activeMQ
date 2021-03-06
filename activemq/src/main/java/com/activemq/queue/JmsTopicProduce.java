package com.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author phoenixhell
 * @create 2021/1/24 0024-下午 4:06
 */

public class JmsTopicProduce {

    public static final String ACTIVEMQ_URL="tcp://192.168.1.100:61616";
    public static final String TOPIC_NAME="jdbc-topic-persistent";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory
                =new ActiveMQConnectionFactory("admin","admin",ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        //transacted 事务   acknowledgeMode 签收
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建destination queue 还是 topic  queue topic  是destination的子接口
        Topic topic = session.createTopic(TOPIC_NAME);
        //创建消息生产者 参数为destination
        MessageProducer producer = session.createProducer(topic);
        //持久化topic 后connection才能启动 建议写上
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        //消息生产者生产消息发送打队列
        for (int i = 0; i <10 ; i++) {
            //创建基于session的消息
            TextMessage textMessage = session.createTextMessage("TOPIC-Durable" +( i + 1));
            producer.send(textMessage);
        }

        producer.close();
        session.close();
//        session.commit();
        connection.close();
        System.out.println("topic Durable message complete");
    }
}
