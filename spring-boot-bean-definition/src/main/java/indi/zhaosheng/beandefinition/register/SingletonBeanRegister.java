package indi.zhaosheng.beandefinition.register;

import indi.zhaosheng.beandefinition.beans.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author muluo
 * @description
 * @date 2020/5/17 21:29
 */
@Configuration
public class SingletonBeanRegister implements BeanFactoryAware, InitializingBean {

    private ConfigurableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableBeanFactory) beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        beanFactory.registerSingleton("myBean3", new MyBean("MyBean3"));
        beanFactory.registerSingleton("myBean4", new MyBean("MyBean4"));
    }
}
