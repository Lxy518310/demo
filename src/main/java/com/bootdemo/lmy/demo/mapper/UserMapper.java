package com.bootdemo.lmy.demo.mapper;

import com.bootdemo.lmy.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 李
 * @create 2019/9/27 20:46
 */
@Mapper
@Component
public interface UserMapper {
    @Insert("INSERT INTO T_USER(name,account_id,token,gmt_create,gmt_modified,avatar_url)" +
            "VALUES(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void addUser(User user);

    @Select("SELECT * FROM t_user WHERE account_id=#{accountId}")
    User getUserByAccoundId(String accountId);

    @Select("SELECT * FROM t_user WHERE token=#{token}")
    User getUserByToken(String token);

    @Update("UPDATE T_USER SET name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl}WHERE account_id=#{accountId}")
    int updateUser(User user);

    @Delete("DELETE FROM t_user WHERE id=#{accountId}")
    int deleteUser(String accountId);

    @Select("SELECT * FROM t_user WHERE id=#{id}")
    User getUserById(int id);
}
