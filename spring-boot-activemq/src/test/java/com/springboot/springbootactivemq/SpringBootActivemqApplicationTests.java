package com.springboot.springbootactivemq;

import com.springboot.springbootactivemq.activemq.QueueProduce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootActivemqApplicationTests {

    @Autowired
    private QueueProduce queueProduce;

    @Test
    void testQueueProduce() {
        queueProduce.productMsg();
    }

}
