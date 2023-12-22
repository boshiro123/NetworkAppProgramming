<%@ page import="com.company.TemperatureDataHandler"%>
<%@ page import="com.company.TemperatureServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*, java.io.*" %>
<!DOCTYPE HTML>
<html>
<body>
<h2>Средняя температура за Июнь:</h2>
     <form action="MainServlet" method="post">
            <input type="submit" value="Показать среднюю температуру" />
     </form>
</body>
</html>