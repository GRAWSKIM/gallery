<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign in</title>
</head>
<body>
<h1>Register</h1>

<c:if test="${errmsg!= null}">
	<p><c:out value="${errmsg}" /></p>
   
</c:if>

<form action="${pageContext.request.contextPath}/login/resister.do" method="post">
	<div> id <input type="text" name="id" /> </div> 
	<div> pw <input type="password" name="pw" /> </div> 	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	<div> <input type="submit" value="회원가입"/> </div> 
</form>
</body>
</html>