package com.zhanhong.service.impl;

import com.zhanhong.common.ServerResponse;
import com.zhanhong.dao.UserMapper;
import com.zhanhong.pojo.User;
import com.zhanhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.queryUsernameNum(username);
        if(resultCount <= 0){
            return ServerResponse.createByErrorMsg("用户名不存在");
        }

        // TODO md5 password
        User user = userMapper.queryLogin(username,password);
        if(user == null){
            return ServerResponse.createByErrorMsg("用户名或密码不正确");
        }
        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccessMsgData("登录成功",user);
    }

}
