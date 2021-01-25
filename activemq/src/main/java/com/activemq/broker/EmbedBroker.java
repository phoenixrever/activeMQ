package com.activemq.broker;

import org.apache.activemq.broker.BrokerService;

/**
 * @author phoenixhell
 * @create 2021/1/25 0025-下午 3:49
 */

public class EmbedBroker {
    public static void main(String[] args) throws Exception {
        BrokerService brokerService =new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
