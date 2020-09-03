package indi.zhaosheng.rocketmq.template.base.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhaosheng
 * @version v1.0
 * @description: 消费者实例基类，具体实例不继承此类，而是继承${@link BaseConcurrentlyConsumer}
 * @date 2020/9/2 9:45 下午
 */
abstract class BaseRocketMQConsumer {

    @Value("${rocketMq.namesrvAddr}")
    private String namesrvAddr;

    protected final DefaultMQPushConsumer consumer;

    public BaseRocketMQConsumer() {
        this.consumer = new DefaultMQPushConsumer();
    }

    /**消费者组*/
    protected abstract String getConsumerGroup();
    /**topic*/
    protected abstract String getTopic();
    /**tags*/
    protected abstract String getTags();
    /**处理从broker拉取的消息*/
    protected abstract boolean handleMsg(String msg);

    /**这个方法会在子类的构造方法*/
    protected void start() throws MQClientException {
        this.consumer.setConsumerGroup(getConsumerGroup());
        this.consumer.setNamesrvAddr(namesrvAddr);
        this.consumer.subscribe(getTopic(), getTags());
        this.consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        this.consumer.start();
    }
}
