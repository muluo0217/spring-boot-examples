package indi.zhaosheng.springbootrocketmq.mq.consumer;

import indi.zhaosheng.rocktmq.consumer.BaseOrderlyConsumer;
import indi.zhaosheng.rocktmq.consumer.ConsumerAction;
import indi.zhaosheng.springbootrocketmq.constants.MQConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author muluo
 * @description
 * @date 2020/5/11 22:24
 */
@Slf4j
@Component
public class OrderlyConsumer extends BaseOrderlyConsumer {

    @Value("${rocketmq.namesrvAddress}")
    private String namesrvAddress;

    protected OrderlyConsumer() {
        super(MQConstant.Consumer.ORDERLY_TOPIC, MQConstant.Consumer.ORDERLY_GROUP);
    }

    @Override
    protected void init() {
        setNamesrvAddress(namesrvAddress);
        setConsumerAction(MQConstant.Consumer.ORDERLY_TAG, ConsumerAction.build(msg -> {
            log.info("receive msg:{} from topic:{}", msg, MQConstant.Consumer.ORDERLY_TOPIC);
            return true;
        }));
    }
}
