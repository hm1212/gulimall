package com.atguigu.gulimall.common.exception;

import lombok.Getter;

/**
 * @Author hhmm
 * @date 2024/3/17
 **/
@Getter
public enum BizCodeExceptionEnum {
    UnKnown_Exception(1000, "系统未知异常"),
    Validate_Exception(10001, "参数格式检验异常");
    int code;
    String message;

    BizCodeExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
