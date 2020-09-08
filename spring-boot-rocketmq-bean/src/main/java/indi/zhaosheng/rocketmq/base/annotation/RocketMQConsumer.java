package indi.zhaosheng.rocketmq.base.annotation;

import indi.zhaosheng.rocketmq.base.enums.ConsumeModel;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.lang.annotation.*;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/8 11:23 下午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RocketMQConsumer {

    String topic();
    String tags();
    String consumerGroup();
    ConsumeModel consumeModel() default ConsumeModel.CONCURRENTLY;
    MessageModel messageModel() default MessageModel.CLUSTERING;
}
