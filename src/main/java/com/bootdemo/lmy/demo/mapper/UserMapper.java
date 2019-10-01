package com.bootdemo.lmy.demo.mapper;

import com.bootdemo.lmy.demo.model.User;
import org.apache.ibatis.annotations.*;
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

    @Select("SELECT * FROM t_user WHERE account_id=#{accountId}")
    User getUserByAccoundId(String accountId);

    @Select("SELECT * FROM t_user WHERE token=#{token}")
    User getUserByToken(String token);

    @Update("UPDATE T_USER SET(name=#{name},account_id=#{accountId},token=#{token},gmt_modified=#{gmtModified})")
    int updateUser(User user);

    @Delete("DELETE FROM t_user WHERE id=#{accountId}")
    int deleteUser(String accountId);
}
