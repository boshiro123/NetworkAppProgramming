<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*, java.io.*" %>
<%@ page import="com.company.DataBaseController, com.company.User, com.company.Products"%>
<html>
<head>
    <title>Company sklad</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f4f4f4;
        }
        h2 {
            color: #333;
        }
        .product-container {
            border: 1px solid #ccc;
            margin-bottom: 20px;
            padding: 15px;
            background-color: #fff;
        }
        .product-container h2 {
            margin-top: 0;
            font-size: 20px;
        }
        .product-info {
            margin-bottom: 10px;
        }
        .product-buttons {
            display: flex;
            justify-content: space-between;
        }
        .product-buttons form {
            margin: 0;
            padding: 0;
            display: inline;
        }
        .product-buttons input[type="submit"] {
            padding: 5px 10px;
            cursor: pointer;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 3px;
        }
        .product-buttons input[type="submit"]:hover {
            background-color: #135688;
        }
        .product-buttons input[type="submit"]:last-child {
            background-color: #d9534f;
        }
        .product-buttons input[type="submit"]:last-child:hover {
            background-color: #b52b27;
        }
        .form-buttons {
            margin-top: 15px;
        }
        .form-buttons input[type="submit"] {
            padding: 8px 16px;
            cursor: pointer;
            background-color: #5cb85c;
            color: #fff;
            border: none;
            border-radius: 3px;
        }
        .form-buttons input[type="submit"]:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>
    <h2>Company sklad!</h2>
    <%
    ArrayList<Products> products = Products.getProducts();
    if(products.size()==0){
        products.add(new Products("Car",4));
        products.add(new Products("Plane",5));
        products.add(new Products("Board",6));
    }
    for(Products p : products){
    %>
    <div class="product-container">
        <div class="product-info">
            <h2>Наименование товара: <%= p.getProductTitle() %></h2>
            <p>Количество товара: <%= p.getCount() %></p>
        </div>
        <div class="product-buttons">
            <form action="editProduct.jsp" method="post">
                <input type="hidden" name="id" value="<%= p.getProductTitle() %>">
                <input type="submit" value="Редактировать">
            </form>

            <form action="DeleteProductServlet" method="post">
                <input type="hidden" name="id" value="<%= p.getProductTitle() %>">
                <input type="submit" value="Удалить">
            </form>
        </div>
    </div>
    <%
    }
    %>
    <div class="form-buttons">
        <form action="newProduct.jsp" method="post">
            <input type="submit" value="Новый">
        </form>
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Выйти">
        </form>
    </div>
</body>
</html>
