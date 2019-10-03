package com.bootdemo.lmy.demo.dto;

import lombok.Data;

/**
 * @author 李
 * @create 2019/9/26 20:26
 */
@Data
public class GithubUser {
    //获取GitHub用户的昵称
    private String name;
    //获取GitHub用户的ID
    private Long id;
    //获取GitHub用户的个人介绍
    private String bio;
    //获取GitHub用户的头像地址
    private String avatar_url;
    public String getAvatar_url() {
        return avatar_url;
    }
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
