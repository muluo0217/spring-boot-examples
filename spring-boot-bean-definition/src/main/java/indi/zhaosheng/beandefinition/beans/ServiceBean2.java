package indi.zhaosheng.beandefinition.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muluo
 * @description
 * @date 2020/5/17 21:12
 */
@Service
public class ServiceBean2 {
    @Autowired
    private NormalBean1 normalBean1;

    public ServiceBean2() {
        System.out.println("ServiceBean2()");
    }

    public void print() {
        System.out.println("in ServiceBean2.print()");
        System.out.println("调用NormalBean1.print()");
        normalBean1.print();
    }
}