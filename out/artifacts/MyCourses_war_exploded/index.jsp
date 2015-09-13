<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 11.09.2015
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<%@page errorPage="error.jsp" %>
<html>
  <head>
    <title>Курсы StreamLine</title>
  </head>
  <body>
    <div class="header-panel">Приложение для курсов Streamline</div>
  <form  action="" method="post" class="form-horizontal">
   Login :<input autofocus="true" required="true" type="text" name="login"><br>
   Password :<input required="true" type="password" name="password"><br>
    <button style="margin-top:20px;" type="reset" name="reset" value="Cancel" class="btn btn-default">Отменить</button>
      <button style="margin-top:20px;" type="submit" name="submit" value="Submit" class="btn btn-primary">Войти</button>
  </form>
  </body>
</html>
