package com.hotel.demo.mapper;


import com.hotel.demo.entity.User;
import com.hotel.demo.provider.UserSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT username,password,level FROM user WHERE username = #{username}")
    User selectUser(String username);

    @Insert("INSERT  INTO user(username,password,level) VALUES (#{username},#{password},#{level})")
    void insertUser(User user);

    @Delete("DELETE FROM user WHERE username = #{usename}")
    void deleteUser(String username);

    @SelectProvider(type= UserSQLProvider.class, method = "createSelectAllSQL")
    List<User> selectAllUsers(User user);

    @UpdateProvider(type = UserSQLProvider.class,method = "createUpdateSQL")
    void updateUser(User user);

}
