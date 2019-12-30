package com.example.springBoot.service;

import com.example.springBoot.domain.UserInfo;

public interface UserInfoService {

    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);
}
