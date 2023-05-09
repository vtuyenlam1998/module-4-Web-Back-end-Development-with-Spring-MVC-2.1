<%--
  Created by IntelliJ IDEA.
  User: defaultuser0
  Date: 5/6/2023
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product Form</title>
    <style type="text/css">@import url(com/example/springmvcintro1/css/main.css);</style>
</head>
<body>

<div id="global">
    <form action="save-product" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <label for="name">Product Name: </label>
            <input type="text" id="name" name="name" value=""
                   tabindex="1">
            <label for="description">Description: </label>
            <input type="text" id="description" name="description"
                   tabindex="2">
            <label for="price">Price: </label>
            <input type="text" id="price" name="price" tabindex="3">
            <div id="buttons">
                <%--@declare id="dummy"--%><label for="dummy"> </label>
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5"
                       value="Add Product">
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
