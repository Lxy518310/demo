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
}
