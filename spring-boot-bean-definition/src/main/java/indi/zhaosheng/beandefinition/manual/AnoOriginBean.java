package indi.zhaosheng.beandefinition.manual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muluo
 * @description
 * @date 2020/5/13 0:02
 */
@Service
public class AnoOriginBean {
    @Autowired
    private ManualBean manualBean;

    public AnoOriginBean() {
        System.out.println("AnoOriginBean init: " + System.currentTimeMillis());
    }

    public String print() {
        return "[AnoOriginBean] print！！！ manualBean == null ? " + (manualBean == null);
    }
}
