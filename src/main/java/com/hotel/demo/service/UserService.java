package com.hotel.demo.service;

import com.hotel.demo.entity.User;

public interface UserService {
    User selectUser(String username);
}
