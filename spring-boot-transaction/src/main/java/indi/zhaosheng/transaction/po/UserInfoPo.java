package indi.zhaosheng.transaction.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author muluo
 * @description
 * @date 2020/5/19 21:43
 */
@Setter
@Getter
@TableName("tb_user_info")
public class UserInfoPo {

    private Long id;

    private Long userId;

    private Boolean sex;

    private LocalDateTime birthday;

    private String address;
}
