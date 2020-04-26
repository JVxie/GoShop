package com.jvxie.goshop.exception.handler;

import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.exception.UserLoginException;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import static com.jvxie.goshop.enums.ResponseEnum.PARAM_ERROR;

/**
 * 统一异常处理
 * 返回Json
 */

@ControllerAdvice
public class RuntimeExceptionHandler {
    /**
     * 捕获运行异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody // 返回Json格式
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo runtimeHandle(RuntimeException e) {
        return ResponseVo.error(ResponseEnum.ERROR, e.getMessage());
    }

    /**
     * 捕获未登录异常
     */
    @ExceptionHandler(UserLoginException.class)
    @ResponseBody // 返回Json格式
    private ResponseVo UserLoginHandle() {
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }

    /**
     * 捕获表单异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody // 返回Json格式
    public ResponseVo notValidHandle(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return ResponseVo.error(PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
    }
}
