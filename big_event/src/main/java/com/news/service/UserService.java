package com.news.service;

import com.news.pojo.User;

public interface UserService {
    User findByUserName(String username);

    void addUser(String username, String password);
}
