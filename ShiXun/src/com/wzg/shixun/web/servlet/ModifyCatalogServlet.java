package com.wzg.shixun.web.servlet;

import com.wzg.shixun.dao.CatalogDao;
import com.wzg.shixun.dao.jdbc.CatalogDaoJDBCImpl;
import com.wzg.shixun.domin.Catalog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.JavaCompiler;
import java.io.IOException;

@WebServlet(name = "ModifyCatalogServlet")
public class ModifyCatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        System.out.println("id = " + id + " name = " + name + "description = " + description);

        Catalog catalog = new Catalog();
        catalog.setId(id);
        catalog.setName(name);
        catalog.setDescription(description);
        CatalogDao catalogDao = new CatalogDaoJDBCImpl();
        catalogDao.updateCatalogById(catalog);

        response.sendRedirect(request.getContextPath() + "/Manager/News/CategoryList.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
