package indi.zhaosheng.springbootrocketmq.runner;

import indi.zhaosheng.rocktmq.producer.BaseNormalProducer;
import indi.zhaosheng.rocktmq.producer.BaseOrderlyProducer;
import indi.zhaosheng.rocktmq.producer.BaseProducer;
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
public class ProducerRunners implements CommandLineRunner {

    @Autowired(required = false)
    private List<BaseNormalProducer> normalProducerList;

    @Autowired(required = false)
    private List<BaseOrderlyProducer> orderlyProducerList;

    @Override
    public void run(String... args) throws Exception {
        log.info("========= RocketMq producers starting...");
        if (null != normalProducerList) {
            normalProducerList.forEach(BaseProducer::start);
        }
        if (null != orderlyProducerList) {
            orderlyProducerList.forEach(BaseProducer::start);
        }
        log.info("========= RocketMq producers start success...");
    }
}
