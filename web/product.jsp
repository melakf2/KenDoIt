<%@ page import="il.ac.hit.mvcdemo.model.Product" %><%--
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
<%
    Product prod = (Product)request.getAttribute("product");
%>
<h1>Product Details</h1>
<h3>title: <%= prod.getTitle() %></h3>
<h3>id: <%= prod.getIsbn() %></h3>
<h3>price: <%= prod.getPrice() %></h3>
</body>
</html>
