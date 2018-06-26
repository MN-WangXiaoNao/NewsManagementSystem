package com.wzg.shixun.web.servlet;

import com.wzg.shixun.dao.jdbc.CatalogDaoJDBCImpl;
import com.wzg.shixun.domin.Catalog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCatalogServlet")
public class AddCatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Catalog catalog = new Catalog();
        catalog.setName(name);
        catalog.setDescription(description);

        new CatalogDaoJDBCImpl().insertCatalog(catalog);

        response.sendRedirect(request.getContextPath() + "/Manager/News/CategoryList.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
