package com.bootdemo.lmy.demo.mapper;

import com.bootdemo.lmy.demo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 李
 * @create 2019/10/1 21:36
 */
@Mapper
@Component
public interface QuestionMapper {

    @Insert("insert into t_question(title,description,gmt_create,gmt_modified,tag,creator) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{tag},#{creator})")
    void addQuestion(Question question);

    @Select("select * from t_question ORDER BY id DESC limit #{page},#{size}")
    List<Question> getQusetionList(Integer page, Integer size);

    @Select("select count(1) from t_question")
    int getCount();
}
