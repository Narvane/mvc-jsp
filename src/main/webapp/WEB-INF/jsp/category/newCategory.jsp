<%--
  Created by IntelliJ IDEA.
  User: gusta
  Date: 6/11/2022
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Category</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="display-2">New Category</h1>
    <c:url var="new_category_url" value="/category/new"/>
    <form:form action="${new_category_url}" method="post" modelAttribute="category">
        <div class="form-group">
            <form:label path="name">Name: </form:label>
            <form:input class="form-control" placeholder="Category name" type="text" path="name"/>
        </div>
        <input type="submit" class="btn btn-primary" value="Save"/>
    </form:form>
</div>
</body>
</html>
