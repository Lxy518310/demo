package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.mapper.QuestionMapper;
import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.Question;
import com.bootdemo.lmy.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李
 * @create 2019/9/29 22:58
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("publish")
    public String publish(){
        return "publish";
    }


    @PostMapping("publish")
    public String publish(Question question, HttpServletRequest request,HttpServletResponse response,Model model){
        Cookie[] cookies = request.getCookies();
        User user=null;
        if(cookies!=null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    user = userMapper.getUserByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
            if (user == null) {
                model.addAttribute("error", "请登录后再发布问题");
                return "publish";
            }
            question.setCreator(user.getId());

            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.addQuestion(question);
        }
        return "redirect:/";
    }
}
