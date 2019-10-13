package com.bootdemo.lmy.demo.service;

import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author 李
 * @create 2019/10/11 21:53
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user){
        if(userMapper.getUserByAccoundId(user.getAccountId())!=null){
            user.setGmtModified(user.getGmtCreate());
            userMapper.updateUser(user);
        }else{
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.addUser(user);
        }
    }
}
