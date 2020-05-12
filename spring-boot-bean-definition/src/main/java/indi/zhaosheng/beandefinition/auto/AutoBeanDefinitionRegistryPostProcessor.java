package indi.zhaosheng.beandefinition.auto;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author muluo
 * @description
 * @date 2020/5/13 0:16
 */
@Configuration
public class AutoBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
// 注册Bean定义，容器根据定义返回bean

        //构造bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
                .genericBeanDefinition(AutoBean.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        //注册bean定义
        registry.registerBeanDefinition("autoBean", beanDefinition);


        // AutoDIBean 的注入方式
        beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(AutoDIBean.class);
        beanDefinitionBuilder.addConstructorArgValue("自动注入依赖Bean");
        beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        registry.registerBeanDefinition("autoDiBean", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
// 注册Bean实例，使用supply接口, 可以创建一个实例，并主动注入一些依赖的Bean；当这个实例对象是通过动态代理这种框架生成时，就比较有用了

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(AutoFacDIBean.class, () -> {
            AutoFacDIBean autoFacDIBean = new AutoFacDIBean("autoFac");
            autoFacDIBean.setAutoBean(factory.getBean("autoBean", AutoBean.class));
            autoFacDIBean.setOriginBean(factory.getBean("originBean", OriginBean.class));
            return autoFacDIBean;
        });
        BeanDefinition beanDefinition = builder.getRawBeanDefinition();
        ((DefaultListableBeanFactory) factory).registerBeanDefinition("autoFacDIBean", beanDefinition);
    }
}
