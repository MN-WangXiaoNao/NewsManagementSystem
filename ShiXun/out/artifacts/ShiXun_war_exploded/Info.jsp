<%@ page import="com.wzg.shixun.dao.jdbc.NewsDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.dao.NewsDao" %>
<%@ page import="com.wzg.shixun.domin.News" %>
<%@ page import="com.wzg.shixun.domin.Reply" %>
<%@ page import="com.wzg.shixun.dao.jdbc.ReplyDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.dao.ReplyDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新闻发布系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta name="Keywords" content="关键字"/>
    <meta name="Description" content="描述"/>
    <link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div id="logo"><a href="Index.jsp" title="新闻发布系统">新闻发布系统</a></div>
        <!--[if !IE]>logo 结束<![endif]-->
        <%--<div class="search">--%>
            <%--<form id="form1" method="post" action="Search.jsp">--%>
                <%--<input type="text" name="textfield" id="textfield" class="iText"/>--%>
                <%--<input type="submit" name="Submit" class="btn" value="搜索"/>--%>
            <%--</form>--%>
        <%--</div>--%>
        <!--[if !IE]>search 结束<![endif]-->
    </div>

    <!--[if !IE]>header 结束<![endif]-->


    <div id="main">
        <%
            NewsDao newsDao = new NewsDaoJDBCImpl();
            News news = newsDao.getNewsById(Integer.parseInt(request.getParameter("id")));
        %>

        <div class="doc-info-view">
            <div class="hd"><h1><%=news.getTitle()%>
            </h1></div>
            <hr class="double"/>
            <!--[if !IE]>文章属性<![endif]-->
            <div class="doc-parameter">
                <div>作者：<%=news.getAuthor()%>
                </div>
                <div>时间：<%=news.getPublishedTime()%>
                </div>
                <div>来源：<%=news.getSource()%>
                </div>
            </div>
            <!--[if !IE]>正文<![endif]-->
            <div class="doc-text">
                <%=news.getContent()%>
            </div>
            <!--[if !IE]>评论<![endif]-->
            <hr class="double"/>
            <div class="comment">

                <div class="hd"><h3>最新评论</h3></div>
                <!--[if !IE]>评论列表 开始<![endif]-->
                <ol class="com-list">
                    <%
                        ReplyDao replyDao = new ReplyDaoJDBCImpl();
                        List<Reply> replyList = replyDao.getReplyByNewsId(Integer.parseInt(request.getParameter("id")));
                        int index = 1;
                        for (Reply reply : replyList) {
                    %>


                    <li>
                        <p class="title wrapfix"><span class="num"><%=index++%></span><span
                                class="name"><%=reply.getAuthor()%></span><span
                                class="time"><%=reply.getPublishedTime()%></span></p>
                        <div class="com-body">
                            <%=reply.getContent()%>
                        </div>
                    </li>

                    <%
                        }
                    %>

                </ol>
                <!--[if !IE]>评论列表 结束<![endif]-->

                <!--[if !IE]>填写评论 开始<![endif]-->
                <div class="com-form">
                    <hr class="double"/>
                    <div class="hd"><h3>发表评论</h3></div>
                    <p class="tips">请自觉遵守互联网相关政策法规，评论不得超过250字。</p>

                    <form method="post" action="${pageContext.request.contextPath}/CommentServlet">
                        <input type="hidden" value="<%=Integer.parseInt(request.getParameter("id"))%>" name="newsId">
                        <p><textarea name="textarea" id="textarea" rows="5" class="textarea"></textarea></p>
                        <p>
                            <label for="username">昵称</label><input type="text" name="username" size="10" id="username"
                                                                   class="iText"/>
                            <input type="submit" name="Submit" class="btn" value="发表评论"/>
                        </p>
                    </form>

                </div>
                <!--[if !IE]>填写评论 开始<![endif]-->
            </div>
        </div>
        <!--[if !IE]>新闻详情 结束<![endif]-->
    </div>
    <!--[if !IE]>main 结束<![endif]-->
    <div id="footer">
        <p>版权所有 &copy;<a href="http://www.cnstrong.com.cn/" target="_blank">山东XXX软件工程有限公司 </a></p>
    </div>
    <!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>