/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028 并保留所有权利
 * Copyright 2024-2028, YCHS Information&Science Technology Co.,Ltd,
 * All right reserved
 */
package com.yckj.dao;

import com.yckj.entity.Users;

import java.util.List;

/**
 * @author yangchaoyu
 * @version 1.0
 */
public interface UserDao {
     boolean Login(String username, String userpsw);
     List<Users> getAllUsers();
     int insertUser(Users users);
     int deleteUser(int id);
     Users getUserById(int id);
     int updateUser(Users users);
}

