<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理系统 - 后台首页</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Microsoft YaHei", sans-serif;
        }
        body {
            /* 渐变动态深色背景，不再单调纯白 */
            background: linear-gradient(-45deg, #0f172a, #1e293b, #334155, #0f172a);
            background-size: 400% 400%;
            animation: bgMove 12s ease infinite;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding-top: 130px;
            color: #fff;
        }
        /* 背景缓慢流动动画 */
        @keyframes bgMove {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }
        .title-box {
            text-align: center;
            margin-bottom: 70px;
        }
        h1 {
            font-size: 42px;
            letter-spacing: 3px;
            margin-bottom: 14px;
            /* 文字微光效果 */
            text-shadow: 0 0 12px rgba(37, 99, 235, 0.5);
        }
        .sub-title {
            font-size: 17px;
            color: #cbd5e1;
            letter-spacing: 1px;
        }
        .welcome {
            color: #38bdf8;
            margin-top: 14px;
            font-size: 18px;
        }
        .menu-box {
            display: flex;
            gap: 36px;
        }
        .menu-item {
            width: 220px;
            height: 180px;
            background: rgba(255, 255, 255, 0.08);
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.12);
            border-radius: 16px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-decoration: none;
            transition: all 0.3s ease;
        }
        /* 悬浮上浮+发光特效 */
        .menu-item:hover {
            transform: translateY(-12px);
            box-shadow: 0 12px 40px rgba(37, 99, 235, 0.35);
            border-color: rgba(37, 99, 235, 0.4);
            background: rgba(255, 255, 255, 0.12);
        }
        .menu-item span:first-child {
            font-size: 48px;
            margin-bottom: 14px;
        }
        .menu-item span:last-child {
            font-size: 19px;
            color: #f1f5f9;
        }
        .query { color: #38bdf8; }
        .add { color: #34d399; }
        .login { color: #fb923c; }
        .logout { color: #f87171; }
        /* 底部装饰小字 */
        .footer-desc {
            position: fixed;
            bottom: 30px;
            font-size: 13px;
            color: #64748b;
        }
    </style>
</head>
<body>
<div class="title-box">
    <h1>用户信息管理后台系统</h1>
    <div class="sub-title">一站式实现账号登录、用户增删改查全功能</div>
    <%
        String loginUser = (String)session.getAttribute("loginUser");
        if(loginUser != null){
    %>
    <p class="welcome">👋 欢迎登录，<%=loginUser%></p>
    <%
        }
    %>
</div>

<div class="menu-box">
    <%
        String loginName = (String)session.getAttribute("loginUser");
        if(loginName == null){
    %>
    <a class="menu-item" href="login.html">
        <span class="login">🔐</span>
        <span>系统登录</span>
    </a>
    <%
    }else{
    %>
    <a class="menu-item" href="FindAllUserServlet">
        <span class="query">📋</span>
        <span>用户列表管理</span>
    </a>
    <a class="menu-item" href="addUser.html">
        <span class="add">➕</span>
        <span>新增用户账号</span>
    </a>
    <a class="menu-item" href="LogoutServlet">
        <span class="logout">🚪</span>
        <span>退出登录</span>
    </a>
    <%
        }
    %>
</div>

<div class="footer-desc">Java Servlet + Thymeleaf 后台管理实训项目</div>
</body>
</html>