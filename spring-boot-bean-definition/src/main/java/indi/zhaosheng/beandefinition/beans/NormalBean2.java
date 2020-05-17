package indi.zhaosheng.beandefinition.beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author muluo
 * @description
 * @date 2020/5/17 21:10
 */
public class NormalBean2 {
    @Autowired
    private NormalBean1 normalBean1;

    public NormalBean2() {
        System.out.println("NormalBean2()");
    }

    public void print() {
        System.out.println("in NormalBean2.print()");
        System.out.println("调用NormalBean1.print()");
        normalBean1.print();
    }
}
