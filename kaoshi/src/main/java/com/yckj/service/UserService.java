/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028 并保留所有权利
 * Copyright 2024-2028, YCHS Information&Science Technology Co.,Ltd,
 * All right reserved
 */
package com.yckj.service;

import com.yckj.entity.Users;

import java.util.List;

/**
 * @author yangchaoyu
 * @version 1.0
 */
public interface UserService {
    boolean Login(String username,String userpsw);
    List<Users> FindAllUsers();
    int AddUser(Users users);
    int DeleteUser(int id);
    Users getUserById(int id);
    int updateUser(Users users);
}

