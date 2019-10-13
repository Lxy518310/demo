package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.QuestionDTO;
import com.bootdemo.lmy.demo.model.Question;
import com.bootdemo.lmy.demo.model.User;
import com.bootdemo.lmy.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 李
 * @create 2019/9/29 22:58
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id",required = true) Integer id,Model model){
        QuestionDTO questionDTO=questionService.getQuestionById(id);
        model.addAttribute("tag",questionDTO.getTag());
        model.addAttribute("description",questionDTO.getDescription());
        model.addAttribute("title",questionDTO.getTitle());
        model.addAttribute("id",id);
        return "/publish";
    }



    @PostMapping("/publish")
    public String publish(Question question, HttpServletRequest request,Model model){
        User user= (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "请登录后再发布问题");
            return "/";
        }
        question.setCreator(user.getId());
        if(question.getId() == null){
            questionService.addQuestion(question);
        }else{
            questionService.updateQuestion(question);
        }
        return "redirect:/";


    }
}
