package indi.zhaosheng.beandefinition.beans;

import org.springframework.stereotype.Service;

/**
 * @author muluo
 * @description
 * @date 2020/5/17 21:12
 */
@Service
public class ServiceBean1 {
    public ServiceBean1() {
        System.out.println("ServiceBean1()");
    }

    public void print() {
        System.out.println("in ServiceBean1.print()");
    }
}
