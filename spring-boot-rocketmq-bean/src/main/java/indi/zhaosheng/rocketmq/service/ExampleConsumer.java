package indi.zhaosheng.rocketmq.service;

import indi.zhaosheng.rocketmq.base.annotation.RocketMQConsumer;
import indi.zhaosheng.rocketmq.base.handler.RocketMQMsgHandler;
import org.springframework.stereotype.Component;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/3 1:31 下午
 */
@Component
@RocketMQConsumer(topic = "beanTopic", tags = "*", consumerGroup = "beanConsumerGroup")
public class ExampleConsumer implements RocketMQMsgHandler {

    @Override
    public boolean handleMsg(String msg) {
        System.out.println("收到消息：" + msg);
        return true;
    }

}
