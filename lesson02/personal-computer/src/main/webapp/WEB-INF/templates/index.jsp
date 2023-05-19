<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1><%= "Calculator!" %></h1>
<div>
  <fieldset>
    <legend>Calcultor</legend>
    <form action="/calculate" method="get">
      <label for="firstOperand">Số thứ nhất</label>
      <input type="number" step="any" name="firstOperand" id="firstOperand">
      <label for="secondOperand">Số thứ hai</label>
      <input type="number" step="any" name="secondOperand" id="secondOperand">
      <br>
      <button name="operator" id="addition" value="addition">Addition(+)</button>
      <button name="operator" id="subtraction" value="subtraction">Subtraction(-)</button>
      <button name="operator" id="multiplication" value="multiplication">Multiplication(*)</button>
      <button name="operator" id="division" value="division">Divison(/)</button>
    </form>
  </fieldset>
</div>

</body>
</html>