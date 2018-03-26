package com.zhanhong.service;

import com.zhanhong.common.ServerResponse;
import com.zhanhong.pojo.User;

/**
 *
 */
public interface UserService {

    /**
     * 登录方法
     * @param username
     * @param pasword
     * @return
     */
    ServerResponse<User> login(String username, String pasword);

}
