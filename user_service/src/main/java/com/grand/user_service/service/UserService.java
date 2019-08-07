package com.grand.user_service.service;

import com.grand.user_service.entity.User;

/**
 * @author ：yanghuanyu
 * @date ：Created in 2019-08-07 10:03
 * @description：
 * @modified By：
 * @version:
 */
public interface UserService {
    /**
     * 功能描述
     * @author yanghuanyu
     * @date 2019-08-07
     * @param id
     * @return com.grand.user_service.entity.User
     */
    User getUser(Long id);
}
