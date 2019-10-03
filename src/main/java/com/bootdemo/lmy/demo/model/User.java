package com.bootdemo.lmy.demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author 李
 * @create 2019/9/27 20:49
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
