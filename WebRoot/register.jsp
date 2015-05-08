<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE HTML>
<html>
<head>


<title>My JSP 'register.jsp' starting page</title>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
  <form action="user!query.action" method="post">
    用户名:<input type="text" name="user.username" /><br /> 密码:<input
      type="password" name="user.password" /><br /> 昵称:<input
      type="text" name="user.agname" /><br /> <input type="submit"
      value="注册" />
  </form>
  <c:forEach items="${users }" var="user">
    	${user.username }--${user.agname }--<br />
  </c:forEach>
</body>
</html>
