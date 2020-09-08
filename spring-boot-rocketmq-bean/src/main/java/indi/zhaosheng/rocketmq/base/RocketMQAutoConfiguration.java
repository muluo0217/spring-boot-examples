package indi.zhaosheng.rocketmq.base;

import indi.zhaosheng.rocketmq.base.annotation.RocketMQConsumer;
import indi.zhaosheng.rocketmq.base.handler.RocketMQMsgHandler;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhaosheng
 * @version v1.0
 * @description:
 * @date 2020/9/8 11:22 下午
 */
@Configuration
@EnableConfigurationProperties(RocketMQProperties.class)
@ConditionalOnProperty(prefix = "rocketmq", value = "namesrvAddr")
public class RocketMQAutoConfiguration implements ApplicationContextAware, InitializingBean {

    private ConfigurableApplicationContext applicationContext;

    private AtomicLong counter = new AtomicLong(0);

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> beans = this.applicationContext.getBeansWithAnnotation(RocketMQConsumer.class);
        beans.forEach(this::registerConsumers);
    }

    private void registerConsumers(String name, Object bean) {
        Class<?> clazz = AopUtils.getTargetClass(bean);

        if (!RocketMQMsgHandler.class.isAssignableFrom(bean.getClass())) {
            throw new IllegalStateException(clazz + " is not instance of " + RocketMQMsgHandler.class.getName());
        }

        RocketMQMsgHandler rocketMQMsgHandler = (RocketMQMsgHandler) bean;
        RocketMQConsumer annotation = clazz.getAnnotation(RocketMQConsumer.class);
        BeanDefinitionBuilder beanBuilder = BeanDefinitionBuilder.genericBeanDefinition(DefaultRocketMQConsumer.class);
        beanBuilder.addPropertyValue("namesrvAddr", namesrvAddr);
        beanBuilder.addPropertyValue("topic", annotation.topic());
        beanBuilder.addPropertyValue("consumerGroup", annotation.consumerGroup());
        beanBuilder.addPropertyValue("consumeModel", annotation.consumeModel());
        beanBuilder.addPropertyValue("tags", annotation.tags());
        beanBuilder.addPropertyValue("messageModel", annotation.messageModel());
        beanBuilder.addPropertyValue("rocketMQMsgHandler", rocketMQMsgHandler);
//        beanBuilder.setDestroyMethodName("destroy");

        String containerBeanName = String.format("%s_%s", DefaultRocketMQConsumer.class.getName(), counter.incrementAndGet());
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        beanFactory.registerBeanDefinition(containerBeanName, beanBuilder.getBeanDefinition());

        DefaultRocketMQConsumer consumer = beanFactory.getBean(containerBeanName, DefaultRocketMQConsumer.class);
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @Bean
    public DefaultMQProducer defaultMQProducer() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setProducerGroup("beanProducerGroup");
        producer.setNamesrvAddr(namesrvAddr);
        producer.start();
        return producer;
    }
}
