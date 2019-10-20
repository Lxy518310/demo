package com.bootdemo.lmy.demo.exception;

/**
 * @author 李
 * @create 2019/10/19 16:05
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    //枚举信息
    QUESTION_NOT_FOUND("你找的问题不存在，要不要换个试试");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
