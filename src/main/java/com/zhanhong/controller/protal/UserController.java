package com.zhanhong.controller.protal;

import com.zhanhong.common.CommonConstant;
import com.zhanhong.common.ServerResponse;
import com.zhanhong.pojo.User;
import com.zhanhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpServletRequest request) {
        ServerResponse<User> response = userService.login(username, password);
        if(response.isSuccess()){
            HttpSession session = request.getSession();
            session.setAttribute(CommonConstant.CURRENT_USER,response.getData());
        }
        return response;
    }


}
