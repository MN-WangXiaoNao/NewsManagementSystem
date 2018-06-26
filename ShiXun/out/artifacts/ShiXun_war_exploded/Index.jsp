<%@ page import="com.wzg.shixun.domin.News" %>
<%@ page import="com.wzg.shixun.dao.NewsDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wzg.shixun.dao.jdbc.NewsDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.dao.CatalogDao" %>
<%@ page import="com.wzg.shixun.dao.jdbc.CatalogDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.domin.Catalog" %><%--
  Created by IntelliJ IDEA.
  User: WangZhiGang
  Date: 2018/6/19
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Style/Main.css" type="text/css"
          media="screen, projection"/>

</head>
<body>
<div id="wrapper">

    <%--头部--%>
    <div id="header">
        <div id="logo"><a href="Index.jsp" title="新闻发布系统">新闻发布系统</a></div>
        <!--[if !IE]>logo 结束<![endif]-->
        <div class="search">
            <form id="form1" method="post" action="${pageContext.request.contextPath}/SearchServlet">
                <input type="text" name="textfield" id="textfield" class="iText"/>
                <select name="select">
                    <option selected="selected">标题</option>
                    <option>内容</option>
                </select>
                <input type="submit" name="Submit" class="btn" value="搜索"/>
            </form>
        </div>
        <!--[if !IE]>search 结束<![endif]-->
    </div>
    <!--[if !IE]>header 结束<![endif]-->

    <div id="main" class="wrapfix">
        <div id="mostlyCon">
            <div class="newslist">

                <%
                    int index = 1;
                    int second = 1;

                    List<News> newsList;
                    NewsDao newsDao = new NewsDaoJDBCImpl();

                    Object obj = request.getAttribute("data");


                    if (obj == null) {
                        newsList = newsDao.getAllNews();

                    } else {
                        newsList = (List<News>) obj;
                    }


                    System.out.println(newsList.size());


                    for (News news : newsList) {

                %>


                <%
                    if (second == 1) {
                        second++;
                %>

                <div class="hd"><h3><%=news.getCatalog().getName()%>
                </h3></div>

                <%
                    }
                %>

                <%
                    if (news.getCatalog().getId() != index) {
                        index++;
                %>

                <div class="hd"><h3><%=news.getCatalog().getName()%>
                </h3></div>

                <%
                    }
                %>

                <div class="bd">
                    <ul class="list">
                        <li><a href="Info.jsp?id=<%=news.getId()%>" target="_blank"><%=news.getTitle()%>
                        </a><span
                                class="date"><%=news.getPublishedTime()%></span></li>
                    </ul>
                </div>

                <%
                    }
                %>

            </div>
            <!--[if !IE]>newslist 结束<![endif]-->

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


    <%--尾部--%>
    <div id="footer">
        <p>版权所有 &copy;<a href="http://www.cnstrong.com.cn/" target="_blank">山东XXX软件工程有限公司 </a></p>
    </div>

</div>
</body>
</html>
