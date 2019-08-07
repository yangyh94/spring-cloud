package com.grand.user_service.controller;

import com.grand.user_service.entity.User;
import com.grand.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：yanghuanyu
 * @date ：Created in 2019-08-07 09:58
 * @description：用户模块
 * @modified By：
 * @version: 1
 */
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("get")
    public User getUser(Long id){

       return userService.getUser(id);
    }
}
