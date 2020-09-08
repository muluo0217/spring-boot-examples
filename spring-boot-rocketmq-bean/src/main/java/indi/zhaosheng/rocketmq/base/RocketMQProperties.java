package indi.zhaosheng.rocketmq.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/8 11:22 下午
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "rocketmq")
public class RocketMQProperties {

    private String namesrvAddr;

    private Producer producer;

    @Setter
    @Getter
    public static class Producer {
        private String producerGroup;
    }
}
