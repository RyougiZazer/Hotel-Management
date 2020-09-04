package com.hotel.demo.service.impl;

import com.hotel.demo.entity.User;
import com.hotel.demo.mapper.UserMapper;
import com.hotel.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUser(String username){
        return userMapper.selectUser(username);
    }
}
