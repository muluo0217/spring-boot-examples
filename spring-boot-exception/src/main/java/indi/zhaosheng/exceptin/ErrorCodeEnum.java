package indi.zhaosheng.exceptin;

import lombok.Getter;

/**
 * @author muluo
 * @description 异常信息枚举
 * @date 2020/5/18 21:58
 */
@Getter
public enum ErrorCodeEnum {

    //
    ILLEGAL_PARAM("001", "参数错误"),
    ;
    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
