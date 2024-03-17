package com.atguigu.gulimall.product.exception;

import com.atguigu.gulimall.common.exception.BizCodeExceptionEnum;
import com.atguigu.gulimall.common.utils.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hhmm
 * @date 2024/3/17
 **/
@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
public class GuliMallGloableExceptionControllerAdvice {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidateException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(item -> {
                String field = item.getField();
                String message = item.getDefaultMessage();
                errorMap.put(field, message);
            });
        }
        return R.error(BizCodeExceptionEnum.Validate_Exception.getCode(), BizCodeExceptionEnum.Validate_Exception.getMessage()).put("data", errorMap);
    }


    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable e) {
        return R.error();
    }

}
