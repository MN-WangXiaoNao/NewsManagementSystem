package com.wzg.shixun.web.servlet;

import com.wzg.shixun.dao.ReplyDao;
import com.wzg.shixun.dao.jdbc.ReplyDaoJDBCImpl;
import com.wzg.shixun.domin.Reply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String contect = request.getParameter("textarea");
        String username = request.getParameter("username");
        String newsId = request.getParameter("newsId");


        ReplyDao replyDao = new ReplyDaoJDBCImpl();
        Reply reply = new Reply();
        reply.setContent(contect);
        reply.setAuthor(username);
        reply.setPublishedTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        replyDao.toInsertReply(Integer.parseInt(newsId), reply);


        request.getRequestDispatcher("/Info.jsp?id=" + newsId).forward(request, response);


    }
}
