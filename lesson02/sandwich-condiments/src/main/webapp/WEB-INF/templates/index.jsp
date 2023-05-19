<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
Sandwich Condiments
<form method="get" action="/save">
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" value="Lettuce" name="condiment" id="lettuce">
    <label for="tomato">Tomato</label>
    <input type="checkbox" value="Tomato" name="condiment" id="tomato">
    <label for="mustard">Mustard</label>
    <input type="checkbox" value="Mustard" name="condiment" id="mustard">
    <label for="sprouts">Sprouts</label>
    <input type="checkbox" value="Sprouts" name="condiment" id="sprouts">
    <input type="submit" value="Save" name="submit">
</form>
</body>
</html>