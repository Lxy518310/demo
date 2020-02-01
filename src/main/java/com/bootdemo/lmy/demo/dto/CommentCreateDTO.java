package com.bootdemo.lmy.demo.dto;

import lombok.Data;

import javax.annotation.security.DenyAll;

/**
 * @author 李
 * @create 2019/10/21 23:02
 */
@Data
public class CommentCreateDTO {
    private String content;
    private Long parentId;
    private int type;
}
