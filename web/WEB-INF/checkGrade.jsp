<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>成绩查询</title>
    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->


    <!--semantic CSS-->
    <link href="dist/css/semantic.min.css" rel="stylesheet">

    <!--DIY-->
    <link href="dist/css/theme.css" rel="stylesheet">


</head>
<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="indexJsp.action">Wanglinzhizhi OS</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="indexJsp.action">主 页</a></li>
                <li class="active"><a href="checkGradeJsp.action">成绩查询</a></li>
                <li><a href="chooseClassJsp.action">选课系统</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">更
                        多<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="account.html">用户信息</a></li>
                        <li><a href="contact.html">Contact</a></li>
                        <li><a href="about.html">About</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">系统相关</li>
                        <li><a href="#">bug报告</a></li>
                        <li><a href="#">Email to us</a></li>
                        <li><a href="signout.action">Sign out</a></li>

                    </ul>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<!-- main body -->
<div class="container theme-showcase" role="main">

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <h1>成绩查询模块</h1>

    <p>这是成绩查询模块.通过本模块进行成绩查询</p>
</div>

<!-- 搜索框 -->
<div class="ui action left icon input">
    <i class="search icon"></i>
    <input type="text" placeholder="Search..." id="filterName">

    <div class="ui teal button">Search</div>
</div>


<div class="page-header" id="index-page-header">
    <p>具体成绩查询</p>
</div>

<!-- 第一学年 -->
<table class="ui celled striped table">
    <thead>
    <tr>
        <th colspan="3">
            第一学年
        </th>
    </tr>
    <tr>
        <th class="disabled">课程名称</th>
        <th class="disabled">期中测试成绩</th>
        <th class="disabled">期末测试成绩</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <td>
            <i class="tag icon"></i> 高等数学
        </td>
        <td>90</td>
        <td class="right aligned collapsing">90</td>
    </tr>
    <tr class="warning">
        <td class="warning">
            <i class="tag icon"></i> 线性代数
            <i class="attention icon"></i>
        </td>
        <td>30</td>
        <td>30</td>
    </tr>
    <tr class="negative">
        <td>
            <i class="tag icon"></i> 概率论
        </td>
        <td>20</td>
        <td class="right aligned">20</td>
    </tr>
    <tr class="positive">
        <td>
            <i class="tag icon"></i> 英语
        </td>
        <td>100</td>
        <td>100</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 政治
        </td>
        <td>100</td>
        <td>100</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 数据结构
        </td>
        <td>40</td>
        <td>40</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 操作系统
        </td>
        <td>30</td>
        <td>30</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 计算机组成原理
        </td>
        <td>40</td>
        <td>40</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 计算机网络
        </td>
        <td>20</td>
        <td>20</td>
    </tr>
    </tbody>
</table>

<!-- 第二学年 -->
<table class="ui celled striped table">
    <thead>
    <tr>
        <th colspan="3">
            第二学年
        </th>
    </tr>
    <tr>
        <th class="disabled">课程名称</th>
        <th class="disabled">期中测试成绩</th>
        <th class="disabled">期末测试成绩</th>
    </tr>

    </thead>
    <tbody>

    <tr>
        <td class="disabled">
            <i class="tag icon"></i> 高等数学
        </td>
        <td>90</td>
        <td>90</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 线性代数
        </td>
        <td>30</td>
        <td>30</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 概率论
        </td>
        <td>20</td>
        <td>20</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 英语
        </td>
        <td>100</td>
        <td>100</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 政治
        </td>
        <td>100</td>
        <td>100</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 数据结构
        </td>
        <td>40</td>
        <td>40</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 操作系统
        </td>
        <td>30</td>
        <td>30</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 计算机组成原理
        </td>
        <td>40</td>
        <td>40</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 计算机网络
        </td>
        <td>20</td>
        <td>20</td>
    </tr>
    </tbody>
</table>

<!-- 第三学年 -->
<table class="ui celled striped table">
    <thead>
    <tr>
        <th colspan="3">
            第三学年
        </th>
    </tr>
    <tr>
        <th class="disabled">课程名称</th>
        <th class="disabled">期中测试成绩</th>
        <th class="disabled">期末测试成绩</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <td class="disabled">
            <i class="tag icon"></i> 高等数学
        </td>
        <td>90</td>
        <td>90</td>
    </tr>
    <tr class="warning">
        <td>
            <i class="tag icon"></i> 线性代数
            <i class="attention icon"></i>

        </td>
        <td>30</td>
        <td>30</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 概率论
        </td>
        <td>20</td>
        <td>20</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 英语
        </td>
        <td>100</td>
        <td>100</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 政治
        </td>
        <td>100</td>
        <td>100</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 数据结构
        </td>
        <td>40</td>
        <td>40</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 操作系统
        </td>
        <td>30</td>
        <td>30</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 计算机组成原理
        </td>
        <td>40</td>
        <td>40</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 计算机网络
        </td>
        <td>20</td>
        <td>20</td>
    </tr>
    </tbody>
</table>

<!-- 第四学年 -->
<table class="ui celled striped table">
    <thead>
    <tr>
        <th colspan="3">
            第四学年
        </th>
    </tr>
    <tr>
        <th class="disabled">课程名称</th>
        <th class="disabled">期中测试成绩</th>
        <th class="disabled">期末测试成绩</th>
    </tr>

    </thead>
    <tbody>

    <tr>
        <td class="disabled">
            <i class="tag icon"></i> 高等数学
        </td>
        <td>90</td>
        <td>90</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 线性代数
        </td>
        <td>30</td>
        <td>30</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 概率论
        </td>
        <td>20</td>
        <td>20</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 英语
        </td>
        <td>100</td>
        <td>100</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 政治
        </td>
        <td>100</td>
        <td>100</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 数据结构
        </td>
        <td>40</td>
        <td>40</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 操作系统
        </td>
        <td>30</td>
        <td>30</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 计算机组成原理
        </td>
        <td>40</td>
        <td>40</td>
    </tr>
    <tr>
        <td>
            <i class="tag icon"></i> 计算机网络
        </td>
        <td>20</td>
        <td>20</td>
    </tr>
    </tbody>
</table>

<table class="ui celled striped table">
    <thead>
    <tr>
        <th colspan="2">
            第OOXX学年
        </th>
    </tr>
    <tr>
        <th class="disabled">课程名称</th>
        <%--<th class="disabled">期中测试成绩</th>--%>
        <th class="disabled">期末测试成绩</th>
    </tr>
    </thead>

    <tbody>
   <%--

   <s:iterator value="#request.CourseList">
    <tr>
        <td>
            <i class="tag icon"></i><s:property value="name"/>
        </td>
        <td>20</td>
        <td>20</td>
    </tr>
    </s:iterator>

    --%>

     <s:iterator value="#request.couse_scroe">
    <tr>
        <td>
            <i class="tag icon"></i>
            <s:property value="key"/>
        </td>
        <td><s:property value="value"/></td>
        <%--<td>20</td>--%>
    </tr>
    </s:iterator>

    </tbody>
</table>

</div>
<!-- main end -->

<!-- footer -->
<footer class="footer">
    <div class="container">
        <p class="text-muted">copyright 2014-2015 wanglinzhizhi.</p>
    </div>
</footer>


<!--add jquery-->
<script src="dist/js/jquery-2.1.3.js" type="text/javascript"></script>

<script src="dist/js/bootstrap.min.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        $("#filterName").keyup(function () {
            $("table tbody tr")
                    .hide()
                    .filter(":contains('" + ( $(this).val() ) + "')")
                    .show();
        }).keyup();
    });
</script>
</body>
</html>
