package indi.zhaosheng.exceptin;

import indi.zhaosheng.RespResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author muluo
 * @description
 * @date 2020/5/18 22:08
 */
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MyException.class)
    public <T> RespResult<T> handleMyException(MyException e) {
        return RespResult.error(e.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public <T> RespResult<T> handleMyException(IllegalArgumentException e) {
        return RespResult.error(e.getMessage());
    }
}
