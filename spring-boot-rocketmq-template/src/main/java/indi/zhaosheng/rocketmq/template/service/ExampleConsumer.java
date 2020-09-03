package indi.zhaosheng.rocketmq.template.service;

import indi.zhaosheng.rocketmq.template.base.consumer.BaseConcurrentlyConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.stereotype.Component;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/3 1:31 下午
 */
@Component
public class ExampleConsumer extends BaseConcurrentlyConsumer {

    public ExampleConsumer() throws MQClientException {
    }

    @Override
    protected String getConsumerGroup() {
        return "templateConsumerGroup";
    }

    @Override
    protected String getTopic() {
        return "templateTopic";
    }

    @Override
    protected String getTags() {
        return "*";
    }

    @Override
    protected boolean handleMsg(String msg) {
        System.out.println("收到消息：" + msg);
        return true;
    }

}
