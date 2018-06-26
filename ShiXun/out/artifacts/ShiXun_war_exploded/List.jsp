<%@ page import="com.wzg.shixun.dao.CatalogDao" %>
<%@ page import="com.wzg.shixun.dao.jdbc.CatalogDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.domin.Catalog" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wzg.shixun.dao.jdbc.NewsDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.dao.NewsDao" %>
<%@ page import="com.wzg.shixun.domin.News" %>
<%@ page import="com.wzg.shixun.domin.PageBean" %>
<%@ page import="com.wzg.shixun.domin.PageObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>新闻发布系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb18030"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta name="Keywords" content="关键字"/>
    <meta name="Description" content="描述"/>
    <link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>
</head>
<body>
<div id="wrapper">

    <%@ include file="Common/header.jsp" %>
    <div id="main" class="wrapfix">
        <div id="mostlyCon">
            <div class="newslist">
                <%

                    String pageStr = request.getParameter("page");
                    String idStr = request.getParameter("id");
                    int catalogIdInt = 0;
                    if (idStr != null) {
                        catalogIdInt = Integer.valueOf(idStr);
                    }

                    NewsDao newsDao = new NewsDaoJDBCImpl();
                    int newsNumber = newsDao.getNewsCountsByCatalogId(catalogIdInt);


                    PageObject<News> newsPageObject = new PageObject<News>(newsNumber, 5);

                    if (pageStr != null) {
                        int pageId = Integer.parseInt(pageStr);
                        newsPageObject.setCurrentPage(pageId);
                    }

                    int start = newsPageObject.getCurrentPage() * newsPageObject.getItemNumber();
                    int end = newsPageObject.getItemNumber();
                    List<News> newsList = newsDao.getNewsToRangeAndCatalogId(catalogIdInt, start, end);

                    int index = 0;
                    for (News news : newsList) {
                        if (index == 0) {
                            index = 1;
                %>


                <div class="hd"><h3><%=news.getCatalog().getName()%>
                </h3></div>

                <%
                    }
                %>

                <div class="bd">
                    <ul class="list">
                        <li><span class="category"><%=news.getCatalog().getName()%></span>
                            <a href="Info.jsp?id=<%=news.getId()%>" target="_blank"><%=news.getTitle()%>
                            </a><span class="date"><%=news.getPublishedTime()%></span></li>
                    </ul>
                </div>
                <%
                    }

                %>


            </div>
            <!--[if !IE]>newslist 结束<![endif]-->
            <div class="paging wrapfix">
                <div class="total">共有<%=newsNumber%>条记录&nbsp;<%=newsPageObject.getCurrentPage() + 1%>
                    / <%=newsPageObject.getAllPage()%>页
                </div>
                <div class="pn">
                    <a href="?page=<%=newsPageObject.getPreviousPage()%>&id=<%=catalogIdInt%>" title="上一页"
                       class="nobar">上一页</a>

                    <%
                        for (int i = 1; i <= newsPageObject.getAllPage(); i++) {
                            if (i == (newsPageObject.getCurrentPage() + 1)) {
                    %>
                    <a href="?id=<%=catalogIdInt%>&page=<%=i-1%>" class="nonce"><%=i%>
                    </a>
                    <%
                    } else {
                    %>

                    <a href="?id=<%=catalogIdInt%>&page=<%=i-1%>"><%=i%>
                    </a>

                    <%
                        }
                    %>
                    <%
                        }
                    %>
                    <a href="?page=<%=newsPageObject.getNextPage()%>&id=<%=catalogIdInt%>" title="下一页"
                       class="nobar">下一页</a>
                </div>
            </div>
            <!--[if !IE]>paging 结束<![endif]-->
        </div>
        <!--[if !IE]>mostlyCon 结束<![endif]-->
        <div id="sideCon">
            <div id="nav">
                <h3>新闻类别</h3>
                <ul>

                    <%
                        CatalogDao catalogDao = new CatalogDaoJDBCImpl();
                        List<Catalog> allCatalog = catalogDao.getAllCatalog();
                        for (Catalog catalog : allCatalog) {
                    %>

                    <li><a href="List.jsp?id=<%=catalog.getId()%>"><%=catalog.getName()%>
                    </a></li>
                    <%
                        }
                    %>

                </ul>
            </div>
        </div>
        <!--[if !IE]>sideCon 结束<![endif]-->
    </div>
    <!--[if !IE]>main 结束<![endif]-->
    <%@ include file="Common/footer.jsp" %>

</div>
</body>
</html>