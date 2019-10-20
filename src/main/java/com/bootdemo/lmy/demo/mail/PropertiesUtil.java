package com.bootdemo.lmy.demo.mail;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author 李
 * @create 2019/10/20 21:27
 */
public class PropertiesUtil {
    private final ResourceBundle resourceBundle;
    private final String fileName;

    public PropertiesUtil(String fileName) {
        this.fileName = fileName;
        Locale locale=new Locale("zh","CN");
        this.resourceBundle=ResourceBundle.getBundle(this.fileName,locale);
    }
    public String getValue(String key){
        String message=this.resourceBundle.getString(key);
        return message;
    }
}
