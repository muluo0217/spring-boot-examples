package indi.zhaosheng;

import lombok.Getter;
import lombok.Setter;

/**
 * @author muluo
 * @description
 * @date 2020/5/18 22:03
 */
@Setter
@Getter
public class RespResult<T> {

    private String code;
    private String msg;
    private T data;

    public RespResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> RespResult<T> ok() {
        return ok(null);
    }

    public static <T> RespResult<T> ok(T data) {
        return new RespResult<>("000", "success", data);
    }

    public static <T> RespResult<T> error() {
        return error("500", "unknown error", null);
    }

    public static <T> RespResult<T> error(String msg) {
        return error("500", msg, null);
    }

    public static <T> RespResult<T> error(String code, String msg, T data) {
        return new RespResult<>(code, msg, data);
    }


}
