package indi.zhaosheng.rocketmq.template.base.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/2 11:53 下午
 */
@Slf4j
public abstract class BaseConcurrentlyConsumer extends BaseRocketMQConsumer {

    /**并发消费方式的回调实现类*/
    private final MessageListenerConcurrently messageListenerConcurrently = (msgList, consumeConcurrentlyContext) -> {
        MessageExt messageExt = msgList.get(0);
        String msg = new String(messageExt.getBody());
        log.info("{} receive msg: topic={}, tag={}, msgId={}, body={}",
                Thread.currentThread().getName(), messageExt.getTopic(), messageExt.getTags(),
                messageExt.getMsgId(), msg);
        //handelMsg()为实际业务处理的类，onMsg()为实际处理消息的方法
        boolean result = handleMsg(msg);
        return result ? ConsumeConcurrentlyStatus.CONSUME_SUCCESS : ConsumeConcurrentlyStatus.RECONSUME_LATER;
    };

    public BaseConcurrentlyConsumer() throws MQClientException {
        //注册回调实现类
        super.consumer.registerMessageListener(messageListenerConcurrently);
        super.start();
    }
}
