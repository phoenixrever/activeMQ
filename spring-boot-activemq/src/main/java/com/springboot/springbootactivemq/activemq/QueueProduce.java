package com.springboot.springbootactivemq.activemq;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;


//@Component
public class QueueProduce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;  //要导jms的包不然出找不到队列的错误

    public void productMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"payload"+ UUID.randomUUID().toString().substring(0,6));
    }

    //主启动类才有效果切记
    @Scheduled(fixedDelay =3000)
    public void productMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"payload"+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("messageScheduled queue send");
    }
}
