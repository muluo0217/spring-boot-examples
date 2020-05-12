package indi.zhaosheng.beandefinition.manual;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author muluo
 * @description
 * @date 2020/5/13 0:01
 */
@Service
public class OriginBean {

    private LocalDateTime time;

    public OriginBean() {
        time = LocalDateTime.now();
    }

    public String print(String msg) {
        return "[OriginBean] print msg: " + msg + ", time: " + time;
    }

}
