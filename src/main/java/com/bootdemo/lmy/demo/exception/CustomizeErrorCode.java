package com.bootdemo.lmy.demo.exception;

/**
 * @author 李
 * @create 2019/10/19 16:05
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    //枚举信息
    QUESTION_NOT_FOUND(2001,"你找的问题不存在，要不要换个试试"),
    USER_NOT_FOUND(2002,"未登录,无法进行此操作"),
    TARGET_PARAM_NOT_FOUND(2003,"未选中任何问题进行评论"),
    SYS_ERROR(2004,"服务器爆炸了,要不你稍后再试试！！"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在");

    ;

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
