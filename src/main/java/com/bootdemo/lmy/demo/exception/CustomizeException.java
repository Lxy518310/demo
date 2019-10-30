package com.bootdemo.lmy.demo.exception;

/**
 * @author 李
 * @create 2019/10/19 15:42
 */
public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public CustomizeException(ICustomizeErrorCode iCustomizeErrorCode) {
        this.code=iCustomizeErrorCode.getCode();
        this.message = iCustomizeErrorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
