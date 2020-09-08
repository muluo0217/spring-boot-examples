package indi.zhaosheng.rocketmq.base;

import indi.zhaosheng.rocketmq.base.enums.ConsumeModel;
import indi.zhaosheng.rocketmq.base.handler.RocketMQMsgHandler;
import lombok.Getter;
import lombok.Setter;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/8 11:26 下午
 */
@Setter
@Getter
public class DefaultRocketMQConsumer {

    private static final Logger log = LoggerFactory.getLogger(DefaultRocketMQConsumer.class);

    private String namesrvAddr;
    private String topic;
    private String tags;
    private String consumerGroup;
    private ConsumeModel consumeModel;
    private MessageModel messageModel;
    private RocketMQMsgHandler rocketMQMsgHandler;
    private DefaultMQPushConsumer consumer;

    public void start() throws MQClientException {
        init();
        this.consumer.start();
        log.info("consumer started! topic:{}, tags:{}, consumerGroup:{}", this.topic, this.tags, this.consumerGroup);
    }

    private void init() throws MQClientException {
        this.consumer = new DefaultMQPushConsumer(this.consumerGroup);
        this.consumer.setNamesrvAddr(this.namesrvAddr);
        this.consumer.setMessageModel(this.messageModel);
        this.consumer.subscribe(this.topic, this.tags);
        switch (consumeModel) {
            case ORDERLY:
                consumer.setMessageListener(messageListenerOrderly);
                break;
            case CONCURRENTLY:
                consumer.setMessageListener(messageListenerConcurrently);
                break;
            default:
                throw new IllegalArgumentException("Property 'consumeMode' was wrong.");
        }

    }

    private MessageListenerConcurrently messageListenerConcurrently = (list, context) -> {
        MessageExt messageExt = list.get(0);
        String msg = new String(messageExt.getBody());
        log.info("{} Receive message: topic={}, tag={}, messageId={}, body={}", Thread.currentThread().getName(), messageExt.getTopic(), messageExt.getTags(), messageExt.getMsgId(), msg);
        boolean result = rocketMQMsgHandler.handleMsg(msg);
        return result ? ConsumeConcurrentlyStatus.CONSUME_SUCCESS : ConsumeConcurrentlyStatus.RECONSUME_LATER;
    };

    private MessageListenerOrderly messageListenerOrderly = (list, context) -> {
        MessageExt messageExt = list.get(0);
        String msg = new String(messageExt.getBody());
        log.info("{} Receive message: topic={}, tag={}, messageId={}, body={}", Thread.currentThread().getName(), messageExt.getTopic(), messageExt.getTags(), messageExt.getMsgId(), msg);
        boolean result = rocketMQMsgHandler.handleMsg(msg);
        return result ? ConsumeOrderlyStatus.SUCCESS : ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
    };
}
