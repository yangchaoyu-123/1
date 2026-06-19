/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028 并保留所有权利
 * Copyright 2024-2028, YCHS Information&Science Technology Co.,Ltd,
 * All right reserved
 */
package com.yckj.dao;

import com.yckj.entity.Users;
import com.yckj.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchaoyu
 * @version 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public boolean Login(String username, String userpsw) {
        boolean flag = false;
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from users where username=? and userpsw=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,userpsw);
            rs = pstmt.executeQuery();
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs,pstmt,conn);
        }
        return flag;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from users";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Users users = new Users();
                users.setId(rs.getInt("userid"));
                users.setUsername(rs.getString("username"));
                users.setUserpsw(rs.getString("userpsw"));
                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs,pstmt,conn);
        }
        return usersList;
    }

    @Override
    public int insertUser(Users users) {
        int flag = 0;
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into users(username,userpsw) values(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,users.getUsername());
            pstmt.setString(2,users.getUserpsw());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(null,pstmt,conn);
        }
        return flag;
    }

    @Override
    public int deleteUser(int id) {
        int flag = 0;
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "delete from users where userid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(null,pstmt,conn);
        }
        return flag;
    }

    @Override
    public Users getUserById(int id) {
        Users users = new Users();
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from users where userid = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                users.setId(rs.getInt("userid"));
                users.setUsername(rs.getString("username"));
                users.setUserpsw(rs.getString("userpsw"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs,pstmt,conn);
        }
        return users;
    }

    @Override
    public int updateUser(Users users) {
        int flag = 0;
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update users set username=?,userpsw=? where userid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,users.getUsername());
            pstmt.setString(2,users.getUserpsw());
            pstmt.setInt(3,users.getId());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(null,pstmt,conn);
        }
        return flag;
    }
}

