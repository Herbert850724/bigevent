package com.news.mapper;

import com.news.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


public interface UserMapper extends Mapper<User> {

    @Select("select * from user where username = #{username}")
    public User findByUserName(String username);
}
