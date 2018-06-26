<%@ page import="com.wzg.shixun.domin.Catalog" %>
<%@ page import="com.wzg.shixun.dao.CatalogDao" %>
<%@ page import="com.wzg.shixun.dao.jdbc.CatalogDaoJDBCImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新闻类别</title>
    <link href="../Style/Css.css" rel="stylesheet" type="text/css"/>
    <script language="javascript">
        String.prototype.Trim = function () {
            return this.replace(/(^\s*)|(\s*$)/g, "");
        }

        function back() {
            //document.all.form1.action = "CategoryList.jsp";
            window.location.href = "http://localhost:8080/Manager/News/CategoryList.jsp";

            // document.form1.submit();
        }
    </script>
</head>
<body>
<h3 class="subTitle">新闻类别</h3>
<%

    CatalogDao catalogDao = new CatalogDaoJDBCImpl();
    Catalog catalog = catalogDao.getCatalogById(Integer.parseInt(request.getParameter("id")));

%>
<form id="form1" name="form1" action="<%=request.getContextPath()%>/ModifyCatalogServlet?id=<%=catalog.getId()%>" method="post">

    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table2">

        <tr>
            <th width="15%" align="right">类别编号</th>
            <td><input name="id" type="text" class="input1" value="<%=catalog.getId()%>" readonly="readonly"/></td>
        </tr>
        <tr>
            <th width="15%" align="right">类别名称</th>
            <td><input name="name" type="text" class="input1" value="<%=catalog.getName()%>"/></td>
        </tr>
        <tr>
            <th width="15%" align="right">类别描述</th>
            <td><input name="description" type="text" class="input1" value="<%=catalog.getDescription()%>"/></td>
        </tr>
    </table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
                <input type="submit" name="Submit1" value="修改"/>
                <input type="reset" name="Submit2" value="重置"/>
                <input type="button" name="Submit3" value="取消" onclick="back()"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>