<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Отображение изображения</title>
</head>
<body>
<h1>Выбор изображения по тематике</h1>
<form action="ImageServlet" method="get">
    <select name="theme">
        <option value="природа">Природа</option>
        <option value="автомобили">Автомобили</option>
        <option value="дети">Дети</option>
    </select>
    <input type="submit" value="Показать изображение">
</form>



<h2>Изображение:</h2>

</body>
</html>

