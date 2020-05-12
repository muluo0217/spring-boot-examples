package indi.zhaosheng.beandefinition.manual;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * @author muluo
 * @description
 * @date 2020/5/13 0:02
 */
public class ManualDIBean {
    private int id;

    @Autowired
    private OriginBean originBean;

    private String name;

    public ManualDIBean(String name) {
        Random random = new Random();
        this.id = random.nextInt(100);
        this.name = name;
    }

    public String print(String msg) {
        String o = originBean.print(" call by ManualDIBean! ");
        return "[ManualDIBean] print: " + msg + " id: " + id + " name: " + name + " originBean print:" + o;
    }
}
