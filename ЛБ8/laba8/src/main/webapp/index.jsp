<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*, java.io.*" %>
<%@ page import="com.company.DataBaseController, com.company.User, com.company.Products"%>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        form {
            display: inline-block;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            cursor: pointer;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 3px;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #135688;
        }
    </style>
</head>
<body>
    <form action="login.jsp" method="get">
        <input type="submit" value="Вход">
    </form>

    <form action="register.jsp" method="get">
        <input type="submit" value="Регистрация">
    </form>
</body>
</html>

