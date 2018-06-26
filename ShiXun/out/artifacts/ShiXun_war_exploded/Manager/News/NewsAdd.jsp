<%@ page import="com.wzg.shixun.dao.jdbc.CatalogDaoJDBCImpl" %>
<%@ page import="com.wzg.shixun.domin.Catalog" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>

    <title>添加新闻</title>
    <link href="<%=request.getContextPath()%>/Style/Css.css" rel="stylesheet" type="text/css"/>

    <script language="javascript">
        String.prototype.Trim = function () {
            return this.replace(/(^\s*)|(\s*$)/g, "");
        }

        function goto() {
            if (check()) {
                document.example.submit();
            }
        }

        function check() {
            if (document.all.example.title.value.Trim() == "") {
                alert("请填写标题!");
                return false;
            }

            return true;
        }

        function back() {
            document.all.example.action = "NewsList.jsp";
            document.example.submit();
        }
    </script>

    <link rel="stylesheet" href="../../kindeditor/themes/default/default.css"/>
    <link rel="stylesheet" href="../../kindeditor/plugins/code/prettify.css"/>
    <script charset="utf-8" src="../../kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="../../kindeditor/lang/zh-CN.js"></script>
    <script charset="utf-8" src="../../kindeditor/plugins/code/prettify.js"></script>
    <script>
        KindEditor.ready(function (K) {
            var editor1 = K.create('textarea[name="content"]', {
                cssPath: '../../kindeditor/plugins/code/prettify.css',
                uploadJson: '../../kindeditor/jsp/upload_json.jsp',
                fileManagerJson: '../../kindeditor/jsp/file_manager_json.jsp',
                allowFileManager: true,
                afterCreate: function () {
                    var self = this;
                    K.ctrl(document, 13, function () {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function () {
                        self.sync();
                        document.forms['example'].submit();
                    });
                }
            });
            prettyPrint();
        });
    </script>


</head>
<body>
<h3 class="subTitle">添加新闻</h3>

<form id="example" name="example" action="<%=request.getContextPath()%>/AddNewsServlet" method="post">
    <table width="90%" border="0" align="center" cellpadding="0" class="table2" cellspacing="0">
        <tr>
            <th width="15%" align="right">新闻类别</th>
            <td>
                <select name="column">

                    <%

                        List<Catalog> allCatalog = new CatalogDaoJDBCImpl().getAllCatalog();
                        for (Catalog catalog : allCatalog) {

                    %>
                    <option value="<%=catalog.getId()%>" selected="selected"><%=catalog.getName()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <th align="right">文章标题</th>
            <td><input name="title" type="text" class="input1" id="header"/></td>
        </tr>

        <tr>
            <th align="right">文章作者</th>
            <td><input name="author" type="text" class="input1" id="header"/></td>
        </tr>

        <tr>
            <th align="right">文章来源</th>
            <td><input name="source" type="text" class="input1" id="header"/></td>
        </tr>

        <tr>
            <th align="right" valign="top">文章内容</th>
            <td>

                <textarea name="content" cols="100" rows="8"></textarea>
                <%--<input name="text" type="hidden" class="input1" id="text"/>--%>
                <%--<IFRAME ID="eWebEditor1" src="../eWebEditor/eWebEditor.jsp?id=text&style=standard" frameborder="0"--%>
                <%--scrolling="no" width="650" height="350"></IFRAME>--%>
            </td>
        </tr>
    </table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
                <input type="submit" name="Submit" value="添加"/>
                <input type="reset" name="Submit2" value="重置"/>
                <input type="button" name="Submit" value="取消" onclick="back()"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
