/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028 并保留所有权利
 * Copyright 2024-2028, YCHS Information&Science Technology Co.,Ltd,
 * All right reserved
 */
package com.yckj.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

/**
 * 我写的监听器，测试一下他是怎么工作的
 * @author yangchaoyu
 * @version 1.0
 */
@WebServlet
public class MyTestListener implements ServletContextListener {
    //初始化一些事情（Tomcat启动时自动执行），我们用他加载Thymeleaf并初始化
    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("我的监听器启动了");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("我的监听器停止工作");
    }
}

