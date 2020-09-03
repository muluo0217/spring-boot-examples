package indi.zhaosheng.rocketmq.template.base.producer;

import lombok.Setter;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/3 1:19 下午
 */
@Setter
@Configuration
public class DefaultRocketMQProducer {

    @Value("${rocketMq.namesrvAddr:}")
    private String namesrvAddr;
    @Value("${rocketMq.producer.producerGroup:}")
    private String producerGroup;

    @Bean
    public DefaultMQProducer defaultMQProducer() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setProducerGroup(producerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        producer.start();
        return producer;
    }
}
