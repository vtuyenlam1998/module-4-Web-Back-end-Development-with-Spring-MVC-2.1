<%--
  Created by IntelliJ IDEA.
  User: defaultuser0
  Date: 5/6/2023
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<fieldset>
    <legend>Chuyển đổi tỉ giá usd thành vnđ</legend>
    <form action="/convert" method="get">
        <label for="numberUSD">USD</label>
        <input type="number" name="numberUSD" value="" id="numberUSD" step="any">
        <label for="rate">Rate</label>
        <input type="number" name="rate" placeholder="25000đ" id="rate" step="any">
        <input type="submit" name="submit" value="Convert">
        <p>Kết quả của bạn là: ${convert}</p>
    </form>
</fieldset>

</body>
</html>
