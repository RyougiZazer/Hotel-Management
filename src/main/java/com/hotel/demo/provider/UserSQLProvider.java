package com.hotel.demo.provider;

import com.hotel.demo.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSQLProvider {

    public String createSelectAllSQL(User user){
        return new SQL(){{
            SELECT("username, password, level");
            FROM("user");
            if (null != user.getUsername()){
                WHERE("username = #{username}");
            }
            if (null != user.getPassword() && !"".equals(user.getPassword())){
                WHERE("password = #{password}");
            }
            if (null != user.getLevel()) {
                WHERE("lwvel = #{level}");
            }
        }}
                .toString();
    }

    public String createUpdateSQL(User user){
        return new SQL()
                .UPDATE("user")
                .SET("username = #{username}")
                .SET("password = #{password}")
                .SET("level=#{level}")
                .WHERE("username = #{username}")
                .toString();
    }
}
