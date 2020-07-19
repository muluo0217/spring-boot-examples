package indi.zhaosheng.beandefinition.register;

import indi.zhaosheng.beandefinition.beans.MyBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author muluo
 * @description
 * @date 2020/5/20 21:57
 */
public class MyBeanFactory implements BeanFactoryAware, InitializingBean {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MyBean myBean = new MyBean("hello world");
        this.beanFactory.registerSingleton("");
    }
}
