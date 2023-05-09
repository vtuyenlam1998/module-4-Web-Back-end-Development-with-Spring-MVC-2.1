<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Từ điển thông Minh</title>
</head>
<body>
<fieldset>
  <legend>Từ điển Anh - Việt xịn nhất hiện nay</legend>
  <form action="/translate" method="get">
    <label for="english">Từ tiếng Anh</label>
    <input type="text" placeholder="Thailand" name="english" id="english">
    <input type="submit" name="submit" value="Translate">
    <p style="color: blue;font-weight: bold">Từ tiếng việt: ${message}</p>
  </form>
</fieldset>
</body>
</html>