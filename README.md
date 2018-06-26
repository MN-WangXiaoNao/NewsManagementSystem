# NewsManagementSystem

在学习本项目之前，请阅读以下内容 !!!

该项目雏形基本完成，但项目中存在着细节的Bug，若发现Bug请联系我，后面有时间，我将继续完善，现在的项目的程度适合入门学者学习。

联系方式：
`QQ`:2567919800
`Email`:2567919800@qq.com

## 开发环境

IDEA + MySql + Tomcat8.5

---

## 导入项目

1.首先将`NewsManagementSystem\ShiXun\SQL.txt`导入到数据库中

数据库结构目录：
![](https://i.imgur.com/DpDUoeX.png)

2.将`ShiXun`导入到`IDEA`中，配置环境，请自行百度(遇到百度解决不了的错误，请Google)。

3.运行项目
* 用户： `http://localhost:8080/Index.jsp`
* 管理者： `http://localhost:8080/Login.jsp`
	* 管理者的用户名：`admin` 密码：`123456`
---

## 技术分析
* 数据库(MySql)：
	* `多表查询(特别重要)`
	* 关键字`LIMIT`的使用
	* `ORDER BY` 的使用
	* CRUD 的基本操作
	* 连接数据库：JDBC [连接MySql jar下载地址](https://dev.mysql.com/downloads/connector/j/)
	* 数据库配置文件：使用传统的`propertoes`文件格式
* 界面
	* 第三方富文本编辑器 [kingeditor 官网](http://kindeditor.net/demo.php)

* 权限管理
路径`/Manager/*`下都是保护路径，这是使用`Filter`判断用户是否已经登录，若未登录，重定向到登录界面。

* 分页管理
使用自己的方法但存在bug，建议大家使用第三方包。

* 用户密码加密
使用 `MD5` 加密 + `加密盐`

* 项目目录

![](https://i.imgur.com/nJjKfsv.png)   
![](https://i.imgur.com/GYyZgDo.png)

## 项目截图

### 用户

主页面
![](https://i.imgur.com/39ZAC7s.png)

新闻类别
![](https://i.imgur.com/hIhxKRj.png)

文章内容+评论
![](https://i.imgur.com/vbcvuLh.png)

### 管理者

管理者登录页面
![](https://i.imgur.com/NxEXPkG.png)

管理主页面
![](https://i.imgur.com/22vfJeB.png)

类别管理
![](https://i.imgur.com/WL5t7M1.png)

类别添加
![](https://i.imgur.com/OLEIPfi.png)

类别修改
![](https://i.imgur.com/uWAF05W.png)

新闻管理
![](https://i.imgur.com/Q9COGRQ.png)

添加新闻
![](https://i.imgur.com/uoVCUsw.png)

修改新闻
![](https://i.imgur.com/mT6jvUH.png)

---

## END

除了本项目，你还可以通过文章提高自己的能力。
* [作者的掘金](https://juejin.im/user/5aa39855f265da239611fec2)
* [作者的简书](https://www.jianshu.com/u/22fcc87d6e5d)

如果本项目对你有帮助，请作者喝杯咖啡吧！

* 支付宝
![](https://i.imgur.com/5liur0U.png)

* 微信
![](https://i.imgur.com/suW7chN.png)

---
