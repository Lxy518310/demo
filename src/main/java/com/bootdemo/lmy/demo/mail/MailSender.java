package com.bootdemo.lmy.demo.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.List;
import java.util.Properties;

/**
 * @author 李
 * @create 2019/10/20 21:10
 */
public class MailSender {
    //邮件实体
    private static MailEntity mailEntity=new MailEntity();

    //设置邮件标题
    public MailSender title(String title){
        mailEntity.setTitle(title);
        return this;
    }

    public MailSender content(String content){
        mailEntity.setContent(content);
        return this;
    }
    public MailSender contentType(MailContentTypeEnum typeEnum){
        mailEntity.setContentType(typeEnum.getValue());
        return this;
    }
    public MailSender targets(List<String> targets){
        mailEntity.setList(targets);
        return this;
    }

    public void send() throws Exception{
        if(mailEntity.getContentType() == null){
            mailEntity.setContentType(MailContentTypeEnum.HTML.getValue());
        }
        if(mailEntity.getTitle()==null || mailEntity.getTitle().trim().length() ==0){
            throw new Exception("邮件标题没有设置，调用title方法设置");
        }
        if(mailEntity.getContent()==null||mailEntity.getContent().trim().length()==0){
            throw new Exception("邮件标题没有设置，调用content方法设置");
        }
        if(mailEntity.getList().size() == 0){
            throw new Exception("没有接收者邮箱地址，调用targets方法设置");
        }

        //读取/resource/mail_zh_CN.properties文件内容
        final PropertiesUtil propertiesUtil=new PropertiesUtil("mail");
        final Properties props=new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.host",propertiesUtil.getValue("mail.smtp.service"));
        props.put("mail.smtp,port",propertiesUtil.getValue("mail.smtp.prot"));
        props.put("mail.user",propertiesUtil.getValue("mail.from.address"));
        props.put("mail.password",propertiesUtil.getValue("mail.form.smtp.pwd"));

        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName=props.getProperty("mail.user");
                String password=props.getProperty("mail.password");
                return new PasswordAuthentication(userName,password);
            }
        };

        Session mailSession=Session.getInstance(props,authenticator);

        MimeMessage mimeMessage=new MimeMessage(mailSession);

        String nickName= MimeUtility.encodeText(propertiesUtil.getValue("mail.from.nickname"));
        InternetAddress form=new InternetAddress(nickName+"<"+props.getProperty("mail.user")+">");
        mimeMessage.setFrom(form);

        mimeMessage.setSubject(mailEntity.getTitle());

        if(mailEntity.getContentType().equals(MailContentTypeEnum.HTML.getValue())){
            mimeMessage.setContent(mailEntity.getContent(),mailEntity.getContentType());
        }else if(mailEntity.getContentType().equals(MailContentTypeEnum.TEXT.getValue())){
            mimeMessage.setText(mailEntity.getContent());
        }
        List<String> targets=mailEntity.getList();
        for(int i=0;i<targets.size();i++){
            try{
                InternetAddress to =new InternetAddress(targets.get(i));
                mimeMessage.setRecipient(Message.RecipientType.TO,to);
                Transport.send(mimeMessage);
            }catch (Exception e){
                continue;
            }
        }
    }
}
