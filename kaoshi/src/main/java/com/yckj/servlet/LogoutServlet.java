package com.yckj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
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

        HttpSession session = request.getSession();
        session.invalidate();
        // 退出后回到首页
        response.sendRedirect("index.jsp");

        // 4. 【把网页名换成自己的】渲染 student.html

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}