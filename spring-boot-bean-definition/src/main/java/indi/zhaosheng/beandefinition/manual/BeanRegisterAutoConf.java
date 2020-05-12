package indi.zhaosheng.beandefinition.manual;

import indi.zhaosheng.beandefinition.manual.ManualBean;
import indi.zhaosheng.beandefinition.manual.ManualDIBean;
import indi.zhaosheng.beandefinition.manual.ManualRegisterBeanUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author muluo
 * @description
 * @date 2020/5/13 0:03
 */
@Configuration
public class BeanRegisterAutoConf {

    public BeanRegisterAutoConf(ApplicationContext applicationContext) {
        System.out.println("BeanRegisterAutoConf init: " + System.currentTimeMillis());
        registerManualBean((ConfigurableApplicationContext) applicationContext);
    }

    /**
     * 手动注册自定义地bean
     *
     * @param applicationContext
     */
    private void registerManualBean(ConfigurableApplicationContext applicationContext) {
        // 主动注册一个没什么依赖的Bean
        ManualBean manualBean = ManualRegisterBeanUtil.registerBean(applicationContext, "manualBean", ManualBean.class);
        manualBean.print("test print manualBean");

        // manualDIBean 内部，依赖由Spring容器创建的OriginBean
        ManualDIBean manualDIBean = ManualRegisterBeanUtil.registerBean(applicationContext, "manualDIBean",
                ManualDIBean.class, "依赖OriginBean的自定义Bean");
        manualDIBean.print("test print manualDIBean");
    }
}
