package com.wzg.shixun.web.servlet;

import com.wzg.shixun.dao.jdbc.NewsDaoJDBCImpl;
import com.wzg.shixun.domin.Catalog;
import com.wzg.shixun.domin.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateNewsServlet")
public class UpdateNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        News news = new News();
        news.setId(Integer.parseInt(request.getParameter("id")));
        news.setTitle(request.getParameter("title"));
        news.setContent(request.getParameter("content"));
        news.setAuthor(request.getParameter("author"));
        news.setSource(request.getParameter("source"));
        Catalog catalog = new Catalog();
        catalog.setId(Integer.parseInt(request.getParameter("column")));
        news.setCatalog(catalog);

        new NewsDaoJDBCImpl().updateNewsById(news);


        response.sendRedirect(request.getContextPath() + "/Manager/News/NewsList.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

