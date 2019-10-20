package com.bootdemo.lmy.demo.mail;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author 李
 * @create 2019/10/20 21:16
 */
public enum MailContentTypeEnum {
    //
    HTML("text/html;charset=UTF-8"),
    TEXT("text");

    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
