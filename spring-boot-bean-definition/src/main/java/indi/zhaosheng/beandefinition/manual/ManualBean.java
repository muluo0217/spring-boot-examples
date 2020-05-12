package indi.zhaosheng.beandefinition.manual;

import java.util.Random;

/**
 * @author muluo
 * @description
 * @date 2020/5/13 0:00
 */
public class ManualBean {
    private int id;

    public ManualBean() {
        Random random = new Random();
        id = random.nextInt(100);
    }

    public String print(String msg) {
        return "[ManualBean] print : " + msg + " id: " + id;
    }
}
