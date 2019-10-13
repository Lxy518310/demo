package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.QuestionDTO;
import com.bootdemo.lmy.demo.model.Question;
import com.bootdemo.lmy.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 李
 * @create 2019/10/13 14:00
 */
@Controller
public class ProblemController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/problem/{id}")
    public String problem(@PathVariable(name = "id") Integer id, Model model){

        QuestionDTO questionDTO=questionService.getQuestionById(id);
        model.addAttribute("problems",questionDTO);
        return "/problem";
    }

}
