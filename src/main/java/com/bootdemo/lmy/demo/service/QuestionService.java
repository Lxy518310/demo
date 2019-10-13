package com.bootdemo.lmy.demo.service;

import com.bootdemo.lmy.demo.dto.PageDTO;
import com.bootdemo.lmy.demo.dto.QuestionDTO;
import com.bootdemo.lmy.demo.mapper.QuestionMapper;
import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.Question;
import com.bootdemo.lmy.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李
 * @create 2019/10/3 9:15
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PageDTO getPageDTO(Integer page, Integer size){
        PageDTO pageDTO=new PageDTO();
        int totalPage=questionMapper.getCount();
        totalPage=totalPage % size==0 ? totalPage / size:totalPage / size + 1;
        if(page<1){
            page=page;
        }else if(page>totalPage){
            page=totalPage;
        }
        List<Question> questionList=questionMapper.getQusetionList((size*(page-1)),size);
        List<QuestionDTO> questionDTOList=new ArrayList<QuestionDTO>();
        for(Question question:questionList){
            QuestionDTO questionDTO=new QuestionDTO();
            User user=userMapper.getUserById(question.getCreator());
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setQuestionDTOList(questionDTOList);
        pageDTO.setPage(totalPage,page,size);
        return pageDTO;
    }

    public PageDTO getPageDTO(Integer id,Integer page, Integer size){
        PageDTO pageDTO=new PageDTO();
        int totalPage=questionMapper.getCount();
        totalPage=totalPage % size==0 ? totalPage / size:totalPage / size + 1;
        if(page<1){
            page=page;
        }else if(page>totalPage){
            page=totalPage;
        }
        List<Question> questionList=questionMapper.getQusetionListByCreator(id,(size*(page-1)),size);
        List<QuestionDTO> questionDTOList=new ArrayList<QuestionDTO>();
        for(Question question:questionList){
            QuestionDTO questionDTO=new QuestionDTO();
            User user=userMapper.getUserById(question.getCreator());
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setQuestionDTOList(questionDTOList);
        pageDTO.setPage(totalPage,page,size);
        return pageDTO;
    }

    public void addQuestion(Question question) {
        if(question!=null){
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.addQuestion(question);
        }
    }

    public QuestionDTO getQuestionById(Integer id) {
        QuestionDTO questionDTO=questionMapper.getQusetionById(id);
        User user=userMapper.getUserById(questionDTO.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void updateQuestion(Question question) {
        if(questionMapper.getQusetionById(question.getId())!= null){
            question.setGmtModified(question.getGmtCreate());
            questionMapper.updateQuestion(question);
        }else{
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.addQuestion(question);
        }
    }
}
