package com.wzg.shixun.web.servlet;

import com.wzg.shixun.dao.NewsDao;
import com.wzg.shixun.dao.jdbc.NewsDaoJDBCImpl;
import com.wzg.shixun.domin.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String textfield = request.getParameter("textfield");
        String select = request.getParameter("select");


        NewsDao newsDao = new NewsDaoJDBCImpl();
        if (select.equals("标题")) {

            List<News> newsByTitle = newsDao.getNewsByTitle(textfield);
            request.setAttribute("data", newsByTitle);


        } else {
            List<News> newsByContent = newsDao.getNewsByContent(textfield);
            request.setAttribute("data", newsByContent);

        }
        request.getRequestDispatcher("/Index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
