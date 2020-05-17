package indi.zhaosheng.beandefinition.beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author muluo
 * @description
 * @date 2020/5/17 21:10
 */
public class NormalBean3 {
    @Autowired
    private ServiceBean1 serviceBean1;

    public NormalBean3() {
        System.out.println("NormalBean3()");
    }

    public void print() {
        System.out.println("in NormalBean3.print()");
        System.out.println("调用ServiceBean1.print()");
        serviceBean1.print();
    }
}
