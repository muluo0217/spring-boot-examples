package indi.zhaosheng.beandefinition;

import indi.zhaosheng.beandefinition.beans.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootBeanDefinitionApplicationTests {

    @Autowired
    NormalBean1 normalBean1;
    @Autowired
    NormalBean2 normalBean2;
    @Autowired
    NormalBean3 normalBean3;
    @Autowired
    ServiceBean1 serviceBean1;
    @Autowired
    ServiceBean2 serviceBean2;

    @Test
    public void test() {
        normalBean1.print();
        normalBean2.print();
        normalBean3.print();
        serviceBean1.print();
        serviceBean2.print();
    }

    @Resource(name = "myBean1")
    MyBean myBean1;
    @Resource(name = "myBean2")
    MyBean myBean2;
    @Resource(name = "myBean3")
    MyBean myBean3;
    @Resource(name = "myBean4")
    MyBean myBean4;

    @Test
    public void test1() {
        myBean1.print();
        myBean2.print();
        myBean3.print();
        myBean4.print();
    }

}
