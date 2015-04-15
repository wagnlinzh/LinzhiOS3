<%--
  Created by IntelliJ IDEA.
  User: wanglinzhizhi
  Date: 15-4-15
  Time: 下午6:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <!-- Main jumbotron for a primary marketing message or call to action -->



    <div class="jumbotron" id="classes">
        <p>Now Time:<%=session.getAttribute("classTime")%> 。</p>
        <p><%= request.getParameter("classTime")%></p>
    </div>

</body>
</html>
