<%--
  Created by IntelliJ IDEA.
  User: gusta
  Date: 6/13/2022
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Products</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container">

    <h1 class="display-2">All Products</h1>

    <a href="/product/new" class="btn btn-primary float-right mb-1">New Product</a>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col">Value</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.category}</td>
                        <td>${product.value}</td>
                        <td>
                            <c:url var="delete_product_url" value="/product/delete?id=${product.id}"/>
                            <c:url var="update_product_url" value="/product/update?id=${product.id}"/>

                                <a href="${update_product_url}" type="button" class="btn btn-info">
                                    <i class="fa fa-pencil"></i>
                                </a>

                                <a href="${delete_product_url}" type="button" class="btn btn-danger">
                                    <i class="fa fa-trash"></i>
                                </a>
                        </td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
