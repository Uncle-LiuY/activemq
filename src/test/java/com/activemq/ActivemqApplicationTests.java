package com.activemq;

import com.activemq.jms.JmsReceiver;
import com.activemq.jms.JmsSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqApplicationTests {

    @Autowired
    private JmsSender sender;

    @Test
    public void testSendByQueue() {
        for (int i = 0; i < 10; i++) {
            this.sender.sendByQueue("发送队列消息： " + i);
        }
    }

    @Test
    public void testSendByTopic() {

        for (int i = 0; i < 10; i++) {
            this.sender.sendByTopic("发送主题消息： " + i);
        }
    }

}
