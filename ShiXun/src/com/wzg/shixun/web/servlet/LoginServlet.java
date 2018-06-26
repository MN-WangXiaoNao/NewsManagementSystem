package com.wzg.shixun.web.servlet;

import com.wzg.shixun.dao.UserDao;
import com.wzg.shixun.dao.jdbc.UserDaoJDBCImpl;
import com.wzg.shixun.utils.Constant;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");


            // System.out.println("用户名: " + username + " 密码: " + password);

            password = password + Constant.ENCRYPT_SALT;
            // 获得一个指定编码的信息摘要算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 获得数据的数据指纹
            byte[] digest = md.digest(password.getBytes());
            // 通过base64编码成明文字符
            BASE64Encoder encoder = new BASE64Encoder();
            password = encoder.encode(digest);
            //  System.out.println(password);


            UserDao userDao = new UserDaoJDBCImpl();
            String pwd = userDao.getPasswordToUsername(username);
            if (password.equals(pwd)) {
                // System.out.println("登录成功");

                HttpSession session = request.getSession();
                session.setAttribute("isLogin","success");


                response.sendRedirect(request.getContextPath() + "/Manager/Index.jsp");
            } else {
                //System.out.println("登录失败");
                request.getRequestDispatcher("/Login.jsp").forward(request, response);

            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage() + "密码进行MD5加密失败!");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
