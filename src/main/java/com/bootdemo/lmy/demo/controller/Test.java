package com.bootdemo.lmy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 李
 * @create 2019/9/24 23:14
 */
@Controller
public class Test {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",required = true,defaultValue = "张三")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }

}
