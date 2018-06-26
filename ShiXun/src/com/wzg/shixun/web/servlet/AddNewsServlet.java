package com.wzg.shixun.web.servlet;

import com.wzg.shixun.dao.NewsDao;
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
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String catalogId = request.getParameter("column");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String source = request.getParameter("source");
        String content = request.getParameter("content");

        System.out.println("CatalogId = " + catalogId + " title = " + title + "author = " + author + "source = " + source + "content = " + content);

        News news = new News();

        news.setTitle(title);
        news.setContent(content);
        news.setAuthor(author);

        String nowTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        news.setPublishedTime(nowTime);
        news.setSource(source);
        Catalog calalog = new Catalog();
        calalog.setId(Integer.parseInt(catalogId));
        news.setCatalog(calalog);


        NewsDao newsDao = new NewsDaoJDBCImpl();
        newsDao.addNews(news);


        response.sendRedirect(request.getContextPath() + "/Manager/News/NewsList.jsp");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
