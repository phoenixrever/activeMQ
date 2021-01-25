package com.activemq.spring;

import com.sun.org.apache.xerces.internal.dom.PSVIDocumentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author phoenixhell
 * @create 2021/1/25 0025-下午 4:00
 */
@Service
public class springProducer {
    @Autowired
    private JmsTemplate jmsTemplate;
}
