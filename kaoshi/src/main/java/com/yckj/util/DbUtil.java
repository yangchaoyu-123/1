/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028 并保留所有权利
 * Copyright 2024-2028, YCHS Information&Science Technology Co.,Ltd,
 * All right reserved
 */
package com.yckj.util;

import java.sql.*;

/**
 * 数据库实用类，获得数据库连接和关闭资源，针对MySQL8
 * @author yangchaoyu
 * @version 1.0
 */
public class DbUtil {
    public static void main(String[] args) {
        System.out.println(DbUtil.getConnection());
    }
    /**
     * 获得数据库连接
     * @return 数据库连接
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            //注册MySQL驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java1036db?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(url,"root","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭资源
     * @param rs 结果集
     * @param pstmt 预编译对象
     * @param conn 数据库连接
     */
    public static void close(ResultSet rs, PreparedStatement pstmt,Connection conn){
        try {
            if (rs != null){
                rs.close();
            }
            if (pstmt != null){
                pstmt.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

