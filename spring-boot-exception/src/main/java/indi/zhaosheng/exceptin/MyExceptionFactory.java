package indi.zhaosheng.exceptin;

/**
 * @author muluo
 * @description
 * @date 2020/5/18 22:02
 */
public class MyExceptionFactory {

    private MyExceptionFactory() {
    }

    public static MyException create(String code, String msg) {
        return new MyException(code, msg);
    }

    public static MyException create(ErrorCodeEnum errorCodeEnum) {
        return new MyException(errorCodeEnum.getCode(), errorCodeEnum.getMsg());
    }

    public static MyException create(ErrorCodeEnum errorCodeEnum, String msg) {
        return new MyException(errorCodeEnum.getCode(), msg);
    }
}
