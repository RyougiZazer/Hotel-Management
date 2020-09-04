package com.hotel.demo.mapper;


import com.hotel.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT username,password FROM user WHERE username = #{username}")
    User selectUser(String username);

}
