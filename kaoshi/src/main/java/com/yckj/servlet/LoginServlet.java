package com.yckj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.yckj.service.UserService;
import com.yckj.service.UserServiceImpl;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
        
        String username = request.getParameter("username");
        String userpsw = request.getParameter("userpsw");
        
        UserService userservice = new UserServiceImpl();
        boolean flag = userservice.Login(username, userpsw);
        

        
        if (flag){
            // 登录成功后跳转到用户列表
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", username);
            response.sendRedirect("FindAllUserServlet");
        }else {
            context.setVariable("tip", "用户名或密码错误");
            // 登录失败，用Thymeleaf渲染login.html并显示错误信息
            engine.process("login", context, response.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}