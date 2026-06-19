package com.yckj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.yckj.entity.Users;
import com.yckj.service.UserService;
import com.yckj.service.UserServiceImpl;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("utf-8");
        // 1. 获取模板引擎
        TemplateEngine engine = (TemplateEngine) getServletContext().getAttribute("engine");

        // 2. 创建 Thymeleaf 上下文
        WebContext context = new WebContext(request, response, getServletContext(), request.getLocale());
// 登录权限校验
        HttpSession session = request.getSession();
        Object loginFlag = session.getAttribute("loginUser");
        if(loginFlag == null){
            // 未登录，跳转登录页并提示
            response.sendRedirect("login.html");
            return; // 终止后续代码执行
        }
        // 3. 【这里按自己需要定，无此内容即删除】传数据到页面
        UserService userservice = new UserServiceImpl();
        String username = request.getParameter("username");
        String userpsw = request.getParameter("userpsw");
        Users users = new Users(username, userpsw);
        int flag = userservice.AddUser(users);
        if (flag > 0){
            context.setVariable("flag", "添加成功");
            response.sendRedirect("FindAllUserServlet");
        }
        else {
            context.setVariable("flag", "添加失败");
            engine.process("addUser", context, response.getWriter());
        }

        // 4. 【把网页名换成自己的】渲染 student.html

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}