package com.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author phoenixhell
 * @create 2021/1/24 0024-下午 1:51
 * 消息生产者
 */

public class JmsProduce {

    public static final String ACTIVEMQ_URL="tcp://192.168.1.100:61616";
    public static final String QUEUE_NAME="jdbc-queue01";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory
                =new ActiveMQConnectionFactory("admin","admin",ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //transacted 事务   acknowledgeMode 签收
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建destination queue 还是 topic  queue topic  是destination的子接口
        Queue queue = session.createQueue(QUEUE_NAME);
        //创建消息生产者 参数为destination
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //消息生产者生产消息发送打队列
        for (int i = 0; i <10 ; i++) {
            //创建基于session的消息
            TextMessage textMessage = session.createTextMessage("message" +( i + 1));
            //消息生产者发送消息
            producer.send(textMessage);
        }


        producer.close();
//        session.commit();
        session.close();
        connection.close();
        System.out.println("message complete");
    }
}
