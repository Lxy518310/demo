package com.bootdemo.lmy.demo.service;

import com.bootdemo.lmy.demo.dto.ResultDTO;
import com.bootdemo.lmy.demo.enums.CommentTypeEnum;
import com.bootdemo.lmy.demo.exception.CustomizeErrorCode;
import com.bootdemo.lmy.demo.exception.CustomizeException;
import com.bootdemo.lmy.demo.exception.ICustomizeErrorCode;
import com.bootdemo.lmy.demo.mapper.CommentMapper;
import com.bootdemo.lmy.demo.mapper.QuestionExtMapper;
import com.bootdemo.lmy.demo.mapper.QuestionMapper;
import com.bootdemo.lmy.demo.model.Comment;
import com.bootdemo.lmy.demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李
 * @create 2019/10/23 21:07
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    public void insert(Comment comment) {
        if(comment.getParentId()==null || comment.getParentId()==0){
            throw  new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if(comment.getType()==null || !CommentTypeEnum.isExist(comment.getType())){
            throw  new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if(comment.getType().equals(CommentTypeEnum.COMMENT.getType())){
            Comment dbcomment=commentMapper.selectByPrimaryKey(comment.getParentId());
            if(dbcomment == null){
                throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
            }
            commentMapper.insert(comment);
        }else{
            Question question=questionMapper.selectByPrimaryKey(comment.getParentId());
            if(question==null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            questionExtMapper.intCommentCount(question);
        }
    }
}
