package indi.zhaosheng.rocketmq;

import indi.zhaosheng.rocketmq.producer.RocketMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRocketmq1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRocketmq1Application.class, args);
    }

    @Autowired
    private RocketMqProducer rocketMqProducer;
    @Override
    public void run(String... args) throws Exception {
        rocketMqProducer.sendMsg("starter-test", "starter-tag", "hello world");
    }
}
