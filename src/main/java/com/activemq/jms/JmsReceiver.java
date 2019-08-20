package com.activemq.jms;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jws.Oneway;

/**
 * 消息消费者
 */
@Component
public class JmsReceiver {
    //需要给topic定义独立的JmsListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    @JmsListener(destination = JmsConfirguration.QUEUE_NAME)
    public void receiveByQueue1(String message) {
        System.out.println("接收队列消息1:" + message);
    }

    @JmsListener(destination = JmsConfirguration.QUEUE_NAME)
    public void receiveByQueue2(String message) {
        System.out.println("接收队列消息2:" + message);
    }

    @JmsListener(destination = JmsConfirguration.TOPIC_NAME , containerFactory="jmsListenerContainerTopic")
    public void receiveByTopic1(String message) {
        System.out.println("接收主题消息1:" + message);
    }
    @JmsListener(destination = JmsConfirguration.TOPIC_NAME, containerFactory="jmsListenerContainerTopic")
    public void receiveByTopic2(String message) {
        System.out.println("接收主题消息2:" + message);
    }
}
