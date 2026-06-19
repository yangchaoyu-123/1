/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028 并保留所有权利
 * Copyright 2024-2028, YCHS Information&Science Technology Co.,Ltd,
 * All right reserved
 */
package com.yckj.entity;

/**
 * @author yangchaoyu
 * @version 1.0
 */
public class Users {
    private int id;
    private String username;
    private String userpsw;

    public Users() {
    }

    public Users(String username, String userpsw) {
        this.username = username;
        this.userpsw = userpsw;
    }

    public Users(int id, String username, String userpsw) {
        this.id = id;
        this.username = username;
        this.userpsw = userpsw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpsw() {
        return userpsw;
    }

    public void setUserpsw(String userpsw) {
        this.userpsw = userpsw;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpsw='" + userpsw + '\'' +
                '}';
    }
}

