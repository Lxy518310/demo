package com.bootdemo.lmy.demo.controller;

import com.bootdemo.lmy.demo.dto.CommentCreateDTO;
import com.bootdemo.lmy.demo.dto.CommentDTO;
import com.bootdemo.lmy.demo.dto.ResultDTO;
import com.bootdemo.lmy.demo.enums.CommentTypeEnum;
import com.bootdemo.lmy.demo.exception.CustomizeErrorCode;
import com.bootdemo.lmy.demo.mapper.QuestionMapper;
import com.bootdemo.lmy.demo.model.Comment;
import com.bootdemo.lmy.demo.model.Question;
import com.bootdemo.lmy.demo.model.User;
import com.bootdemo.lmy.demo.service.CommentService;
import com.bootdemo.lmy.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 李
 * @create 2019/10/21 23:04
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionMapper questionMapper;

    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        if(user == null){
            return  ResultDTO.errorof(CustomizeErrorCode.USER_NOT_FOUND);
        }
        Comment comment=new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setCommentator(Long.valueOf(user.getId()));
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setLikeCount(0);
        commentService.insert(comment);
        if(comment.getType()== 1){
            Question question = questionService.getQuestionById(commentCreateDTO.getParentId());
            question.setGmtModified(comment.getGmtModified());
            questionService.updateQuestion(question);
        }
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}",method = RequestMethod.GET)
    public ResultDTO comments(@PathVariable(name = "id") Long id){
        Comment dbComment=commentService.getCommentById(id);
        if(dbComment==null){
            return ResultDTO.errorof(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}
