<%--
  Created by IntelliJ IDEA.
  User: wanglinzhizhi
  Date: 15-4-14
  Time: 上午8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String className = request.getParameter("className");


    out.println("您选择的课程是"+className);
%>
