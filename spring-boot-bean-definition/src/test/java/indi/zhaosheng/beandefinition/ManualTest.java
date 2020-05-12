package indi.zhaosheng.beandefinition;

import indi.zhaosheng.beandefinition.manual.AnoOriginBean;
import indi.zhaosheng.beandefinition.manual.ManualBean;
import indi.zhaosheng.beandefinition.manual.ManualDIBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author muluo
 * @description
 * @date 2020/5/13 0:06
 */
public class ManualTest extends SpringBootBeanDefinitionApplicationTests {

    @Autowired
    private ManualBean manualBean;
    @Autowired
    private ManualDIBean manualDIBean;
    @Autowired
    private AnoOriginBean anoOriginBean;

    @Test
    public void test() {
        System.out.println(manualBean.print("manualBean"));
        System.out.println(manualDIBean.print("manualBean"));
        System.out.println(anoOriginBean.print());
    }
}
