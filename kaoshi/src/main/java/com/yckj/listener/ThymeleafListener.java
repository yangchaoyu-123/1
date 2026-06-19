/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2024-2028 并保留所有权利
 * Copyright 2024-2028, YCHS Information&Science Technology Co.,Ltd,
 * All right reserved
 */
package com.yckj.listener;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 这个监听器用来加载并设置Thymeleaf，Tomcat一启动，这个监听器就执行了
 * 一执行，Thymeleaf就配置好了
 * @author yangchaoyu
 * @version 1.0
 */
@WebListener
public class ThymeleafListener implements ServletContextListener {
    //加载Thymeleaf并设置一些参数，也就是初始化
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            System.out.println("=====================================");

            // 1. 获取全局 Servlet 上下文（整个web项目的全局对象）
            ServletContext context = sce.getServletContext();

            // 2. 创建 Thymeleaf 模板解析器（负责读取HTML模板文件）：处理网页的一个对象
            ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context);

            // 3. 配置模板解析规则
            resolver.setPrefix("/"); // 模板文件前缀：从 webapp 根目录开始查找
            resolver.setSuffix(".html"); // 模板文件后缀：自动补充 .html 扩展名
            resolver.setCharacterEncoding("UTF-8"); // 设置模板编码为UTF-8，防止中文乱码
            resolver.setCacheable(false); // 关闭模板缓存，开发时修改HTML立即生效，无需重启服务器

            // 4. 创建 Thymeleaf 核心模板引擎（真正负责渲染页面的工具）
            TemplateEngine engine = new TemplateEngine();

            // 5. 给引擎设置上面配置好的模板解析器（让引擎知道去哪里、怎么读取HTML）
            engine.setTemplateResolver(resolver);

            // 6. 将配置好的 Thymeleaf 引擎存入全局上下文
            // 所有 Servlet 都可以通过 context.getAttribute("engine") 获取使用
            context.setAttribute("engine", engine);
        }
}


