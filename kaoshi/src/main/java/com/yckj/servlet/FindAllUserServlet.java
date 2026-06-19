package com.yckj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.yckj.entity.Users;
import com.yckj.service.UserService;
import com.yckj.service.UserServiceImpl;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/FindAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
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
        UserService userservice = new UserServiceImpl();
        List<Users> usersList = userservice.FindAllUsers();
        
        context.setVariable("ulist", usersList);

        // 3. 渲染 display.html
        engine.process("display", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}