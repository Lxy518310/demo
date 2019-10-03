package com.bootdemo.lmy.demo.model;

import lombok.Data;

/**
 * @author 李
 * @create 2019/10/1 21:33
 */
@Data
public class Question {
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
}
