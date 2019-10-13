package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.PageDTO;
import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.User;
import com.bootdemo.lmy.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李
 * @create 2019/10/3 21:31
 */
@Controller
public class ProfileController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/profile")
    public String profile(Model model){
        if(!model.containsAttribute("sectionName")){
            model.addAttribute("sectionName","个人主页");
        }
        return "profile";
    }

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name="size",defaultValue = "5")Integer size,
                          @PathVariable(name="action")String action,
                          HttpServletResponse response,
                          Model model){
        if("myquestion".equals(action)){
            model.addAttribute("section","myquestion");
            model.addAttribute("sectionName","我的问题");
        }else if("mydraft".equals(action)){
            model.addAttribute("section","mydraft");
            model.addAttribute("sectionName","我的草稿");
        }else if("mycollection".equals(action)){
            model.addAttribute("section","mycollection");
            model.addAttribute("sectionName","我的收藏");
        }else if("myconcern".equals(action)){
            model.addAttribute("section","myconcern");
            model.addAttribute("sectionName","我关注的问题");
        }else if("alltopics".equals(action)){
            model.addAttribute("section","alltopics");
            model.addAttribute("sectionName","所有话题");
        }else if("allUser".equals(action)){
            model.addAttribute("section","allUser");
            model.addAttribute("sectionName","所有用户");
        }else if("invitefriends".equals(action)){
            model.addAttribute("section","invitefriends");
            model.addAttribute("sectionName","邀请好友");
        }
        User user= (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "请登录后再发布问题");
            return "/";
        }
        PageDTO pageDTO =questionService.getPageDTO(user.getId(),page,size);
        model.addAttribute("questionByUser",pageDTO);
        return "/profile";
    }
}
