package com.zhanhong.dao;

import com.zhanhong.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询用户名数量
     *
     * @return
     */
    int queryUsernameNum(String username);
    /**
     * 查询登录方法
     * @param username
     * @param password
     * @return
     */
    User queryLogin(@Param("username")String username,@Param("password") String password);
}