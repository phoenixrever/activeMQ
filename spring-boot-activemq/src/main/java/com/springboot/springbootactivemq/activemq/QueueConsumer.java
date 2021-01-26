package com.springboot.springbootactivemq.activemq;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

import javax.jms.TextMessage;


/**
 * @author phoenixhell
 * @create 2021/1/26 0026-上午 9:26
 */
@Component
public class QueueConsumer {
    //下面方法不行
/*    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void receive() throws JMSException {
        Message<?> message = jmsMessagingTemplate.receive(queue);
        if(message!=null && message instanceof TextMessage){
            System.out.println(((TextMessage) message).getText());
        }
    }*/
//    主启动类自动调用
    @JmsListener(destination = "${queue.queueName}")
    public void receive(TextMessage textMessage) throws JMSException{
        System.out.println(textMessage.getText());
    }
}
