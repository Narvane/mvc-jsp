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
    <title>New Product</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="display-2">New Product</h1>
        <c:url var="new_product_url" value="/product/new"/>
        <form:form action="${new_product_url}" method="post" modelAttribute="product">
            <div class="form-group">
                <form:label path="name">Name: </form:label>
                <form:input class="form-control" placeholder="Product name" type="text" path="name"/>
            </div>
            <div class="form-group">
                <form:label path="value">Value: </form:label>
                <form:input class="form-control" placeholder="0,00" type="number" path="value"/>
            </div>
            <div class="form-group">
                <form:label path="categoryId">Category: </form:label>
                <form:select path="categoryId" class="form-control">
                    <c:forEach items="${categories}" var="category">
                        <form:option value="${category.id}">${category.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <input type="submit" class="btn btn-primary" value="Save"/>
        </form:form>
    </div>
</body>
</html>
