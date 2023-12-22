<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*, java.io.*" %>
<%@ page import="com.company.DataBaseController, com.company.User, com.company.Products"%>
<html>
<head>
    <title>Registration Menu</title>
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
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"] {
            width: calc(100% - 12px);
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 8px 16px;
            cursor: pointer;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 3px;
        }
        input[type="submit"]:hover {
            background-color: #135688;
        }
    </style>
</head>
<body>
    <h2>Registration menu!</h2>
    <form action="register" method="post">
        <label for="login">Логин:</label><br>
        <input type="text" id="login" name="login"><br>
        <label for="password">Пароль:</label><br>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Регистрация">
    </form>
</body>
</html>

