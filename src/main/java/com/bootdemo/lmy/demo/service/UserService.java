package com.bootdemo.lmy.demo.service;

import com.bootdemo.lmy.demo.mapper.UserMapper;
import com.bootdemo.lmy.demo.model.User;
import com.bootdemo.lmy.demo.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()!=0){
            user.setToken(UUID.randomUUID().toString());
            user.setGmtModified(System.currentTimeMillis());
            user.setToken(user.getToken());
            userExample.createCriteria().andIdEqualTo(users.get(0).getId());
            userMapper.updateByExampleSelective(user,userExample);
        }else{
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }
    }
}
