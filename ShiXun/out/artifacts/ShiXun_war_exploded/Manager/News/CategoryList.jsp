<%@ page import="com.wzg.shixun.dao.jdbc.CatalogDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.dao.CatalogDao" %>
<%@ page import="com.wzg.shixun.domin.Catalog" %>
<%@ page import="java.util.List" %>

<%@ page import="com.wzg.shixun.domin.PageBean" %>
<%@ page import="com.wzg.shixun.domin.PageObject" %>
<%@ page import="com.wzg.shixun.dao.jdbc.ReplyDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.dao.jdbc.NewsDaoJDBCImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>

    <title>新闻类别管理</title>
    <link href="../Style/Css.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<h3 class="subTitle">
    新闻类别
</h3>

<ul class="button">
    <li><a href="CategoryAdd.jsp">添加类别</a></li>
</ul>


    <%

    String idStr = request.getParameter("id");
    //System.out.println(idStr + "=====");
    if (idStr != null) {
        int id = Integer.parseInt(idStr);

        // 删除 reply 表中的数据
        new ReplyDaoJDBCImpl().deleteReplyByCatalogId(id);

        // 删除 news 表中的数据
        new NewsDaoJDBCImpl().deleteNewsByCatalogId(id);

        // 删除 catalog 表中的数据
        new CatalogDaoJDBCImpl().deleteCatalogById(id);

        //System.out.println("删除的id = " + id);

    }


%>


<form id="form2" name="form2" method="post" action="">
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
        <tr>
            <th width="8%" nowrap="nowrap">序号</th>
            <th nowrap="nowrap">类别名称</th>
            <th width="12%" nowrap="nowrap">修改</th>
            <th width="12%" nowrap="nowrap">删除</th>
        </tr>


        <%

            String pageStr = request.getParameter("page");

            CatalogDao catalogDao = new CatalogDaoJDBCImpl();
            int catalogNumber = catalogDao.getCatalogCounts();

            PageObject<Catalog> catalogPageObject = new PageObject<Catalog>(catalogNumber, 5);

            if (pageStr != null) {
                int pageId = Integer.parseInt(pageStr);
                catalogPageObject.setCurrentPage(pageId);
            }

            int start = catalogPageObject.getCurrentPage() * catalogPageObject.getItemNumber();
            int end = catalogPageObject.getItemNumber();
            List<Catalog> catalogList = catalogDao.getCatalogToRange(start, end);

            int item = (catalogPageObject.getCurrentPage() * catalogPageObject.getItemNumber()) + 1;
            for (Catalog catalog : catalogList) {
        %>

        <tr>
            <td align="center"><%=item++%>
            </td>
            <td align="center"><%=catalog.getName()%>
            </td>
            <td align="center"><a href="CategoryModify.jsp?id=<%=catalog.getId()%>">修改</a></td>
            <td align="center"><a href="?id=<%=catalog.getId()%>" onclick="return del();">删除</a></td>
        </tr>

        <%
            }
        %>


    </table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="page">
        <tr>
            <td width="50%" align="left">共有<%=catalogPageObject.getAllDataNumber()%>条记录，<span
                    style="font-family:宋体; font-size:9.0pt; color:black; ">第</span><span
                    style="font-family:Tahoma; font-size:9.0pt; color:black; ">
                <%=catalogPageObject.getCurrentPage() + 1%> / <%=catalogPageObject.getAllPage()%> </span><span
                    style="font-family:宋体; font-size:9.0pt; color:black; ">页</span></td>
            <td width="50%" align="right">
                <a href="?page=<%=catalogPageObject.getStartPage()%>">首页</a>
                <a href="?page=<%=catalogPageObject.getPreviousPage()%>">上一页</a>
                <a href="?page=<%=catalogPageObject.getNextPage()%>">下一页</a>
                <a href="?page=<%=catalogPageObject.getEndPage()-1%>">末页</a>
                跳转到
                <select name="select2" onchange="jump()" id="select2">

                    <%
                        for (int i = 1; i <= catalogPageObject.getAllPage(); i++) {
                            if ((catalogPageObject.getCurrentPage() + 1) == i) {
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
</form>


<script type="text/javascript">


    function jump() {
        var myselect = document.getElementById("select2");
        var index = myselect.selectedIndex;
        var val = myselect.options[index].value;
        console.log(val);

        window.location.href = "http://localhost:8080/Manager/News/CategoryList.jsp?page=" + val;
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
