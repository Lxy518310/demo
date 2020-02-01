package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.CommentDTO;
import com.bootdemo.lmy.demo.dto.QuestionDTO;
import com.bootdemo.lmy.demo.enums.CommentTypeEnum;
import com.bootdemo.lmy.demo.model.User;
import com.bootdemo.lmy.demo.service.CommentService;
import com.bootdemo.lmy.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 李
 * @create 2019/10/13 14:00
 */
@Controller
public class ProblemController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/problem/{id}")
    public String problem(@PathVariable(name = "id") Long id, Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        QuestionDTO questionDTO=questionService.getQuestionDTOById(id);
        if(user!=null && !questionDTO.getUser().getId().equals(user.getId()) ){
            questionService.addViewCount(id);
        }
        List<CommentDTO> commentList=commentService.listByTargetId(id, CommentTypeEnum.QUESTION);
        model.addAttribute("problems",questionDTO);
        model.addAttribute("comments",commentList);
        return "/problem";
    }

}
