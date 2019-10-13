package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.PageDTO;
import com.bootdemo.lmy.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 李
 * @create 2019/9/24 23:14
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(@RequestParam(name = "page",defaultValue = "1") Integer page,
            @RequestParam(name="size",defaultValue = "7")Integer size,
            Model model){
        PageDTO pageDTO =questionService.getPageDTO(page,size);
        model.addAttribute("questions",pageDTO);
        return "index";
    }
}
