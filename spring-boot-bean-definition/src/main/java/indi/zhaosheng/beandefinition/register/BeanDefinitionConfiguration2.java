package indi.zhaosheng.beandefinition.register;

import indi.zhaosheng.beandefinition.beans.NormalBean1;
import indi.zhaosheng.beandefinition.beans.NormalBean2;
import indi.zhaosheng.beandefinition.beans.NormalBean3;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author muluo
 * @description
 * @date 2020/5/17 21:16
 */
@Configuration
public class BeanDefinitionConfiguration2 implements ApplicationContextAware, InitializingBean {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        registerBean(applicationContext);
    }

    private void registerBean(ConfigurableApplicationContext applicationContext) {
        registerBean(applicationContext, "normalBean1", NormalBean1.class);
        registerBean(applicationContext, "normalBean2", NormalBean2.class);
        registerBean(applicationContext, "normalBean3", NormalBean3.class);
    }

    public <T> T registerBean(ConfigurableApplicationContext applicationContext, String name, Class<T> clz, Object... args) {
        if (applicationContext.containsBean(name)) {
            Object bean = applicationContext.getBean(name);
            if (bean.getClass().isAssignableFrom(clz)) {
                return (T) bean;
            } else {
                throw new RuntimeException("BeanName 重复 " + name);
            }
        }

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clz);
        for (Object arg : args) {
            beanDefinitionBuilder.addConstructorArgValue(arg);
        }
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) applicationContext.getBeanFactory();
        beanDefinitionRegistry.registerBeanDefinition(name, beanDefinition);
        return applicationContext.getBean(name, clz);
    }
}
