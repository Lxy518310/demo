package com.bootdemo.lmy.demo.mail;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李
 * @create 2019/10/20 21:07
 */
@Data
public class MailEntity implements Serializable {
    //SMTP服务器
    private String smtpService;
    //设置端口号
    private String smtpPort;
    //设置发送邮箱
    private String fromMailAddress;
    //设置发送邮箱的STMP口令
    private String fromMailStmpPwd;
    //设置邮件标题
    private String title;
    //设置邮件内容
    private String content;
    //设置内容格式(默认采用html)
    private String contentType;
    //接收邮件地址集合
    private List<String> list=new ArrayList<>();
}
