package indi.zhaosheng.transaction.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author muluo
 * @description
 * @date 2020/5/19 21:43
 */
@Setter
@Getter
@TableName("tb_user")
public class UserPo {

    private Long id;

    private String name;
}
