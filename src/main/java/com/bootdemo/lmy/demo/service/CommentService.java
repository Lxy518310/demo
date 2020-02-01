package com.bootdemo.lmy.demo.service;

import com.bootdemo.lmy.demo.dto.CommentDTO;
import com.bootdemo.lmy.demo.enums.CommentTypeEnum;
import com.bootdemo.lmy.demo.exception.CustomizeErrorCode;
import com.bootdemo.lmy.demo.exception.CustomizeException;
import com.bootdemo.lmy.demo.mapper.CommentMapper;
import com.bootdemo.lmy.demo.mapper.QuestionExtMapper;
import com.bootdemo.lmy.demo.mapper.QuestionMapper;
import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Autowired
    private UserMapper userMapper;

    //将评论存入数据库。
    @Transactional
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
            Question dbQuestion=questionMapper.selectByPrimaryKey(comment.getParentId());
            if(dbQuestion==null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            Question question=new Question();
            question.setId(dbQuestion.getId());
            question.setCommentCount(1);
            commentMapper.insert(comment);
            questionExtMapper.intCommentCount(question);
        }
    }

    //获取对应问题下所有的评论信息。
    public List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type) {
        //获取该主题下所有的comment信息。
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria()
                    .andParentIdEqualTo(id)
                .andTypeEqualTo(type.getType());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        if(comments.size() == 0){
            return new ArrayList<>();
        }
        Set<Long> commentators = comments.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());
        List<Long> userIds = new ArrayList<>();
        userIds.addAll(commentators);

        //获取comment对应的user信息。
        UserExample userExample=new UserExample();
        userExample.createCriteria().andIdIn(userIds);
        List<User> users=userMapper.selectByExample(userExample);
        Map<Long,User> userMap=users.stream().collect(Collectors.toMap(user -> user.getId(),user -> user));

        //将comment和对应的user信息放入CommentDTO List中，返回List。
        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment,commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentator()));
            return commentDTO;
        }).collect(Collectors.toList());

        return commentDTOS;
    }

    //通过id获取评论。
    public Comment getCommentById(Long parentId) {
        Comment comment=commentMapper.selectByPrimaryKey(parentId);
        if(comment==null){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        return comment;
    }
}
