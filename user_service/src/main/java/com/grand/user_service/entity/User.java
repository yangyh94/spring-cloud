package com.grand.user_service.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：yanghuanyu
 * @date ：Created in 2019-08-07 10:00
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class User implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Date createTime;

    private Date updateTime;
}
