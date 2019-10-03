package com.bootdemo.lmy.demo.dto;

import com.bootdemo.lmy.demo.model.User;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 李
 * @create 2019/10/3 9:18
 */
@Data
@Component
public class QuestionDTO {
    private int id;
    private int creator;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private String tag;
    private int likeCount;
    private int commentCount;
    private int viewCount;
    private User user;
}
