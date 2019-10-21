package com.bootdemo.lmy.demo.service;

import com.bootdemo.lmy.demo.dto.PageDTO;
import com.bootdemo.lmy.demo.dto.QuestionDTO;
import com.bootdemo.lmy.demo.exception.CustomizeErrorCode;
import com.bootdemo.lmy.demo.exception.CustomizeException;
import com.bootdemo.lmy.demo.mapper.QuestionExtMapper;
import com.bootdemo.lmy.demo.mapper.QuestionMapper;
import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.Question;
import com.bootdemo.lmy.demo.model.QuestionExample;
import com.bootdemo.lmy.demo.model.User;
import org.apache.ibatis.session.RowBounds;
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
    private QuestionExtMapper questionExtMapper;

    @Autowired
    private UserMapper userMapper;

    public PageDTO getPageDTO(Integer page, Integer size){
        PageDTO pageDTO=new PageDTO();
        int totalPage= (int) questionMapper.countByExample(new QuestionExample());
        totalPage=totalPage % size==0 ? totalPage / size:totalPage / size + 1;
        if(page<1){
            page=page;
        }else if((page>totalPage||page==totalPage) && totalPage>0){
            page=totalPage;
        }

        QuestionExample questionExample = new QuestionExample();
        questionExample.setOrderByClause("gmt_modified desc");
        List<Question> questionList = questionMapper.selectByExampleWithRowbounds(questionExample, new RowBounds((size * (page - 1)), size));
        List<QuestionDTO> questionDTOList=new ArrayList<QuestionDTO>();
        for(Question question:questionList){
            QuestionDTO questionDTO=new QuestionDTO();
            User user=userMapper.selectByPrimaryKey(question.getCreator());
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
        QuestionExample example = new QuestionExample();
        example.createCriteria().andCreatorEqualTo(id);
        int totalPage= (int) questionMapper.countByExample(example);
        totalPage=totalPage % size==0 ? totalPage / size:totalPage / size + 1;
        if(page<1){
            page=page;
        }else if((page>totalPage||page==totalPage) && totalPage>0){
            page=totalPage;
        }
        example.createCriteria().andCreatorEqualTo(id);
        example.setOrderByClause("gmt_modified desc");
        List<Question> questionList = questionMapper.selectByExampleWithRowbounds(example, new RowBounds((size * (page - 1)), size));
//        List<Question> questionList=questionMapper.getQusetionListByCreator(id,(size*(page-1)),size);
        List<QuestionDTO> questionDTOList=new ArrayList<QuestionDTO>();
        for(Question question:questionList){
            QuestionDTO questionDTO=new QuestionDTO();
            User user=userMapper.selectByPrimaryKey(question.getCreator());
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
            questionMapper.insertSelective(question);
        }
    }

    public QuestionDTO getQuestionById(Integer id){
        QuestionDTO questionDTO=new QuestionDTO();
        Question question = questionMapper.selectByPrimaryKey(id);
        if(question==null){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        BeanUtils.copyProperties(question,questionDTO);
        User user=userMapper.selectByPrimaryKey(questionDTO.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void updateQuestion(Question question) {
        Question dbQuestion = questionMapper.selectByPrimaryKey(question.getId());
        if(dbQuestion != null){
            question.setGmtModified(question.getGmtCreate());
            question.setGmtModified(System.currentTimeMillis());
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria().andIdEqualTo(dbQuestion.getId());
            questionMapper.updateByExampleSelective(question, questionExample);
        }else{
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        }
    }

    public void addViewCount(Integer id) {
        Question question = new Question();
        question.setViewCount(1);
        question.setId(id);
        questionExtMapper.addViewCount(question);
//        Question question = questionMapper.selectByPrimaryKey(id);
//        Question updateQuestion=new Question();
//        updateQuestion.setViewCount(question.getViewCount()+1);
//        QuestionExample questionExample=new QuestionExample();
//        questionExample.createCriteria().andIdEqualTo(id);
//        questionMapper.updateByExampleSelective(updateQuestion,questionExample);
    }
}
