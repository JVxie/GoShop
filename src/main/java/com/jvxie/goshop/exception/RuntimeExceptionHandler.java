package com.jvxie.goshop.exception;

import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RuntimeExceptionHandler {
    @ExceptionHandler(RuntimeException.class) // 捕获异常
    @ResponseBody // 返回Json格式
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo handle(RuntimeException e) {
        return ResponseVo.error(ResponseEnum.ERROR, e.getMessage());
    }
}
