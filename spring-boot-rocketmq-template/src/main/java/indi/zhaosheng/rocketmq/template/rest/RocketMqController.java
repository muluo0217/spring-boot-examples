package indi.zhaosheng.rocketmq.template.rest;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/3 1:27 下午
 */
@RestController
@RequestMapping
public class RocketMqController {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @GetMapping("/send")
    public void send() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Message message = new Message("templateTopic", "tagA", "hello world!".getBytes());
        SendResult result = defaultMQProducer.send(message);
        System.out.println(result.getMsgId());
    }
}
