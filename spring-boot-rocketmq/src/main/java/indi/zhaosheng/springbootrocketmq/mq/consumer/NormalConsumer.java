package indi.zhaosheng.springbootrocketmq.mq.consumer;

import indi.zhaosheng.rocktmq.consumer.BaseNormalConsumer;
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
public class NormalConsumer extends BaseNormalConsumer {

    @Value("${rocketmq.namesrvAddress}")
    private String namesrvAddress;

    protected NormalConsumer() {
        super(MQConstant.Consumer.NORMAL_TOPIC, MQConstant.Consumer.NORMAL_GROUP);
    }

    @Override
    protected void init() {
        setNamesrvAddress(namesrvAddress);
        setConsumerAction(MQConstant.Consumer.NORMAL_TAG, ConsumerAction.build(msg -> {
            log.info("receive msg:{} from topic:{}", msg, MQConstant.Consumer.NORMAL_TOPIC);
            return true;
        }));
    }
}
