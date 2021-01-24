package queue;

import com.sun.istack.NotNull;
import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.sound.midi.Soundbank;
import java.io.IOException;

/**
 * @author phoenixhell
 * @create 2021/1/24 0024-下午 2:31
 */

public class JmsConsumer {
    public static final String ACTIVEMQ_URL="tcp://localhost:61616";
    public static final String QUEUE_NAME="queue01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("--------------1---------------");
        ActiveMQConnectionFactory activeMQConnectionFactory
                =new ActiveMQConnectionFactory("admin","admin",ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //transacted 事务   acknowledgeMode 签收
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建destination queue 还是 topic  queue topic  是destination的子接口
        Queue queue = session.createQueue(QUEUE_NAME);
      //创建消息消费者 参数为destination
        MessageConsumer consumer = session.createConsumer(queue);
       /*
        //消费者 消费队列中消息
        while (true){
            TextMessage textMessage = (TextMessage) consumer.receive(3000L);
            if(textMessage!=null){
                System.out.println("消费者接收到消息"+textMessage.getText());
            }else{
                break;
            }
        }*/
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message != null && message instanceof TextMessage){
                    TextMessage textMessage=(TextMessage)message;
                    try {
                        System.out.println("message listener "+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
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