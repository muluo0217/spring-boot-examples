package indi.zhaosheng.springbootrocketmq.mq.producer;

import indi.zhaosheng.rocktmq.producer.BaseNormalProducer;
import indi.zhaosheng.springbootrocketmq.constants.MQConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author muluo
 * @description
 * @date 2020/5/11 22:09
 */
@Component
public class TestNormalProducer extends BaseNormalProducer {

    @Value("${rocketmq.namesrvAddress}")
    private String namesrvAddress;

    protected TestNormalProducer() {
        super(MQConstant.Producer.NORMAL_TOPIC, MQConstant.Producer.NORMAL_GROUP);
    }

    @Override
    protected void init() {
        setNamesrvAddress(namesrvAddress);
    }
}
