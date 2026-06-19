/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028 并保留所有权利
 * Copyright 2024-2028, YCHS Information&Science Technology Co.,Ltd,
 * All right reserved
 */
package com.yckj.service;

import com.yckj.dao.UserDao;
import com.yckj.dao.UserDaoImpl;
import com.yckj.entity.Users;

import java.util.List;

/**
 * @author yangchaoyu
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    UserDao userdao = new UserDaoImpl();
    @Override
    public boolean Login(String username, String userpsw) {
        return userdao.Login(username,userpsw);
    }

    @Override
    public List<Users> FindAllUsers() {
        return userdao.getAllUsers();
    }

    @Override
    public int AddUser(Users users) {
        return userdao.insertUser(users);
    }

    @Override
    public int DeleteUser(int id) {
        return userdao.deleteUser(id);
    }

    @Override
    public Users getUserById(int id) {
        return userdao.getUserById(id);
    }

    @Override
    public int updateUser(Users users) {
        return userdao.updateUser(users);
    }
}

