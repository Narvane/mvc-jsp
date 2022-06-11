<%--
  Created by IntelliJ IDEA.
  User: gusta
  Date: 6/10/2022
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:url var="new_product_url" value="/product/new"/>
    <form:form action="${new_product_url}" method="post" modelAttribute="product">
        <form:label path="name">Product Name: </form:label> <form:input type="text" path="name"/>
        <input type="submit" value="submit"/>
    </form:form>
</body>
</html>
