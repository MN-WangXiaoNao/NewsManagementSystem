package com.wzg.shixun.web;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String isLoginStr = (String) session.getAttribute("isLogin");
        if (isLoginStr != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("http://localhost:8080/Login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
