package indi.zhaosheng.springbootrocketmq.runner;

import indi.zhaosheng.rocktmq.consumer.BaseNormalConsumer;
import indi.zhaosheng.rocktmq.consumer.BaseOrderlyConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author muluo
 * @description
 * @date 2020/5/11 22:17
 */
@Slf4j
@Component
public class ConsumerRunners implements CommandLineRunner {

    @Autowired(required = false)
    private List<BaseNormalConsumer> normalConsumerList;

    @Autowired(required = false)
    private List<BaseOrderlyConsumer> orderlyConsumerList;

    @Override
    public void run(String... args) throws Exception {
        log.info("========= RocketMq producers starting...");
        if (null != normalConsumerList) {
            for (BaseNormalConsumer consumer : normalConsumerList) {
                consumer.start();
            }
        }
        if (null != orderlyConsumerList) {
            for (BaseOrderlyConsumer consumer : orderlyConsumerList) {
                consumer.start();
            }
        }
        log.info("========= RocketMq producers start success...");
    }
}
