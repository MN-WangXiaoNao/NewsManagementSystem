
<%--
  Created by IntelliJ IDEA.
  User: WangZhiGang
  Date: 2018/6/12
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header">
    <div id="logo"><a href="Index.jsp" title="新闻发布系统">新闻发布系统</a></div>
    <!--[if !IE]>logo 结束<![endif]-->
    <div class="search">
        <form id="form1" method="post" action="${pageContext.request.contextPath}/SearchServlet">
            <input type="text" name="textfield" id="textfield" class="iText" />
            <select name="select">
                <option selected="selected">标题</option>
                <option>内容</option>
            </select>
            <input type="submit" name="Submit" class="btn" value="搜索" />
        </form>
    </div>
    <!--[if !IE]>search 结束<![endif]-->
</div>
<!--[if !IE]>header 结束<![endif]-->


</body>
</html>
