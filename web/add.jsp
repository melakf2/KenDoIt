<%--
  Created by IntelliJ IDEA.
  User: Sanad
  Date: 18/06/2017
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>add item</h1>
<%
    String status = (String)request.getAttribute("error");
    if(status==null) {
%>
<form method="get" action="http://localhost:8080/mvcdemo/webstore/user/add" >
    isbn: <input type="text" name="isbn">
    <br/>
    price: <input type="text" name="price">
    <br/>
    title: <input type="text" name="title">
    <br/>
    <input type="submit" />
</form>
<%
    }
    else{
        if(status.equals("0")) {
            out.println("success");
        } else {
            out.println("failure");
        }
    }
%>
</body>
</html>
