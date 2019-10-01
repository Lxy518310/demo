package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 李
 * @create 2019/9/24 23:14
 */
@Controller
public class IndexController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if("token".equals(cookie.getName())){
                String token=cookie.getValue();
                User user=userMapper.getUserByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user);
                    return "index";
                }
                break;
            }
        }
        return "index";
    }
}
