package indi.zhaosheng.beandefinition.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * @author muluo
 * @description
 * @date 2020/5/17 21:28
 */
@Setter
@Getter
public class MyBean {

    private String name;

    public MyBean() {
    }

    public MyBean(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("MyBean:" + name);
    }

}
