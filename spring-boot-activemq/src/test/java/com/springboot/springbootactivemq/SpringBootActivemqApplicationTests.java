package com.springboot.springbootactivemq;

import com.springboot.springbootactivemq.activemq.QueueConsumer;
import com.springboot.springbootactivemq.activemq.QueueProduce;
import com.springboot.springbootactivemq.activemq.TopicConsumer;
import com.springboot.springbootactivemq.activemq.TopicProduce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.JMSException;

@SpringBootTest
class SpringBootActivemqApplicationTests {

//    @Autowired
//    private QueueProduce queueProduce;
//    @Autowired
//    private QueueConsumer QueueConsumer;
//
//    @Test
//    void testQueueProduce() {
//        queueProduce.productMsg();
//    }
//    @Test
//    //主启动类才有效果 此处只运行一次
//    void testQueueProduceScheduled() {
//        queueProduce.productMsgScheduled();
////    }
//    @Autowired
//    private TopicConsumer topicConsumer;
//        @Test
//    void testQueueProduce() throws JMSException {
//            topicConsumer.receive();
//    }
}
