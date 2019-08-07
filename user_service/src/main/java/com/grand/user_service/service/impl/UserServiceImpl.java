package com.grand.user_service.service.impl;

import com.grand.user_service.entity.User;
import com.grand.user_service.mapper.UserMapper;
import com.grand.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：yanghuanyu
 * @date ：Created in 2019-08-07 10:04
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {

        return userMapper.selectById(id);

    }
}
