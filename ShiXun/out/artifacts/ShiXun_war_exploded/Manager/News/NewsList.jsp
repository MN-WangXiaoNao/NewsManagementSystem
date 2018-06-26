<%@ page import="com.wzg.shixun.dao.jdbc.NewsDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.domin.News" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wzg.shixun.dao.jdbc.ReplyDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.dao.NewsDao" %>
<%@ page import="com.wzg.shixun.domin.PageObject" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>

    <title>新闻列表</title>
    <link href="../Style/Css.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<h3 class="subTitle">新闻资讯</h3>
<ul class="button">
    <li><a href="NewsAdd.jsp">添加新闻</a></li>
</ul>


<%
    String idStr = request.getParameter("id");
    if (idStr != null) {
        int id = Integer.parseInt(idStr);
        // 删除 reply 表中的数据
        new ReplyDaoJDBCImpl().deleteReplyByNewsId(id);
        // 删除 news 表中的数据
        new NewsDaoJDBCImpl().deleteNewsBtyId(id);
        //request.getRequestDispatcher("/Manager/News/NewsList.jsp").forward(request, response);

    }
%>

<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table">

    <tr>
        <th width="8%" nowrap="nowrap">序号</th>
        <th nowrap="nowrap">标题</th>
        <th width="15%" nowrap="nowrap">日期</th>
        <th width="12%">修改</th>
        <th width="12%">删除</th>
    </tr>


    <%

        String pageStr = request.getParameter("page");

        NewsDao newsDao = new NewsDaoJDBCImpl();
        int newsNumber = newsDao.getNewsCounts();

        System.out.println("总数量" + newsNumber);

        PageObject<News> newsPageObject = new PageObject<News>(newsNumber, 5);

        if (pageStr != null) {
            int pageId = Integer.parseInt(pageStr);
            newsPageObject.setCurrentPage(pageId);
        }

        int start = newsPageObject.getCurrentPage() * newsPageObject.getItemNumber();
        int end = newsPageObject.getItemNumber();
        List<News> newsList = newsDao.getNewsToRange(start, end);

        System.out.println("总分页" + newsPageObject.getAllPage());

        int item = (newsPageObject.getCurrentPage() * newsPageObject.getItemNumber()) + 1;
        for (News news : newsList) {
    %>


    <tr>
        <td align="center"><%=item++%>
        </td>
        <td align="center"><%=news.getTitle()%>
        </td>
        <td align="center"><%=news.getPublishedTime()%>
        </td>
        <td align="center"><a href="NewsModify.jsp?id=<%=news.getId()%>">修改</a></td>
        <td align="center"><a href="?id=<%=news.getId()%>" onclick="return del();">删除</a></td>
    </tr>

    <%
        }
    %>

</table>

<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="page">


    <tr>
        <td width="50%" align="left">共有<%=newsPageObject.getAllDataNumber()%>条记录，<span
                style="font-family:宋体; font-size:9.0pt; color:black; ">第</span><span
                style="font-family:Tahoma; font-size:9.0pt; color:black; "> <%=newsPageObject.getCurrentPage() + 1%> / <%=newsPageObject.getAllPage()%> </span><span
                style="font-family:宋体; font-size:9.0pt; color:black; ">页</span></td>
        <td width="50%" align="right">
            <a href="?page=<%=newsPageObject.getStartPage()%>">首页</a>
            <a href="?page=<%=newsPageObject.getPreviousPage()%>">上一页</a>
            <a href="?page=<%=newsPageObject.getNextPage()%>">下一页</a>
            <a href="?page=<%=newsPageObject.getEndPage()-1%>">末页</a>
            跳转到
            <select name="select2" onchange="jump()" id="select2">
                <%
                    for (int i = 1; i <= newsPageObject.getAllPage(); i++) {
                        if ((newsPageObject.getCurrentPage() + 1) == i) {
                %>
                <option value="<%=i-1%>" selected>
                    <%=i%>
                </option>
                <%
                } else {
                %>
                <option value="<%=i-1%>">
                    <%=i%>
                </option>
                <%
                    }
                %>
                <%
                    }
                %>
            </select>
        </td>
    </tr>
</table>

<script type="text/javascript">


    function jump() {
        var myselect = document.getElementById("select2");
        var index = myselect.selectedIndex;
        var val = myselect.options[index].value;
        console.log(val);

        window.location.href = "http://localhost:8080/Manager/News/NewsList.jsp?page=" + val;
    }


    function del() {
        if (confirm('确认要删除？')) {
            return true;
        }
        return false;
    }

</script>


</body>
</html>
