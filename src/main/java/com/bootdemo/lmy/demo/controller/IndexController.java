package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.PageDTO;
import com.bootdemo.lmy.demo.dto.QuestionDTO;
import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.User;
import com.bootdemo.lmy.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 李
 * @create 2019/9/24 23:14
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(@RequestParam(name = "page",defaultValue = "1") Integer page,
            @RequestParam(name="size",defaultValue = "5")Integer size,
            HttpServletRequest request,Model model){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length != 0){
            for(Cookie cookie:cookies){
                if("token".equals(cookie.getName())){
                    String token=cookie.getValue();
                    User user=userMapper.getUserByToken(token);
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        PageDTO pageDTO =questionService.getPageDTO(page,size);
        model.addAttribute("questions",pageDTO);
        return "index";
    }
}
