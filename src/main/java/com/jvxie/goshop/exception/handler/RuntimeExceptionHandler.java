package com.jvxie.goshop.exception.handler;

import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.exception.UserLoginException;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 用于捕获运行错误
 * 返回Json
 */

@ControllerAdvice
public class RuntimeExceptionHandler {
    @ExceptionHandler(RuntimeException.class) // 捕获异常
    @ResponseBody // 返回Json格式
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo handle(RuntimeException e) {
        return ResponseVo.error(ResponseEnum.ERROR, e.getMessage());
    }

    @ExceptionHandler(UserLoginException.class) // 捕获异常
    @ResponseBody // 返回Json格式
    private ResponseVo UserLoginHandle() {
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }
}
