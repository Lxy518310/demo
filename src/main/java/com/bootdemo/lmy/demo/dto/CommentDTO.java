package com.bootdemo.lmy.demo.dto;

import com.bootdemo.lmy.demo.model.User;
import lombok.Data;

/**
 * @author 李
 * @create 2020/1/31 16:30
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private String content;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer type;
    private Integer likeCount;
    private Long commentator;
    private User user;
}
