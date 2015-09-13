<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 11.09.2015
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<head>
    <title>Курсы StreamLine</title>
</head>
<body>
<div class="header-panel">Приложение для курсов Streamline</div>
<div class="under-header">Зарегестрируйся для того что бы пользоваться приложением</div>
<form  action="Registry" method="post" class="form-horizontal">
  Id:<input required="true" type="number" name="id" autofocus="true" placeholder="Ваш ID"><br>
  Login:<input required="true" type="text" name="login" autofocus="true" pattern="[A-Za-z]{4,10}" placeholder="Логин от 4 до 10 символов" ><br>
  Password:<input required="true" type="password" name="password" pattern="[A-Za-z]{4,10}" autofocus="t" placeholder="Пароль от 4 до 10 символов"> <br>
  E-mail:<input required="true" type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" autofocus="t" placeholder="Введите ваш e-mail"><br>
  Age:<input required="true" type="number" name="age" min="11" max="20" autofocus="true"><br>
  Vk:<input type="url" name="vk" autofocus="true"  placeholder="Ссылка на vk"><br>
  <button style="margin-top:20px" type="reset" name="reset" class="btn btn-default">Отмена</button>
  <button style="margin-top:20px" type="submit" name="submit" class="btn btn-primary btn-sm">Зарегестрироваться</button>
</form>
</body>
</html>
