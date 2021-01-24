package queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author phoenixhell
 * @create 2021/1/24 0024-下午 4:10
 */

public class JmsTopicConsumer {
    public static final String ACTIVEMQ_URL="tcp://localhost:61616";
    public static final String TOPIC_NAME="topic01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("------------------2------------------");
        ActiveMQConnectionFactory activeMQConnectionFactory
                =new ActiveMQConnectionFactory("admin","admin",ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //transacted 事务   acknowledgeMode 签收
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建destination queue 还是 topic  queue topic  是destination的子接口
        Topic topic = session.createTopic(TOPIC_NAME);
        //创建主题topic消费者 参数为destination
        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener((message)->{
            if(message != null && message instanceof TextMessage){
                TextMessage textMessage=(TextMessage)message;
                try {
                    System.out.println("message listener "+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //不写消费不到消息消费需要时间 而下面关闭语句会断了连接接收不到消息
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
        System.out.println("message complete");
    }
}
