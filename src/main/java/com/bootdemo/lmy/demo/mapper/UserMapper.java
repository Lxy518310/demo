package com.bootdemo.lmy.demo.mapper;

import com.bootdemo.lmy.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author 李
 * @create 2019/9/27 20:46
 */
@Mapper
@Component
public interface UserMapper {
    @Insert("INSERT INTO T_USER(name,account_id,token,gmt_create,gmt_modified)" +
            "VALUES(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void addUser(User user);

}
