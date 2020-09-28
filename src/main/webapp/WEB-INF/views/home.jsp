<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<sec:authorize access="isAnonymous()">
<p><a href="<c:url value="/login/loginForm.do" />">로그인</a></p>
</sec:authorize>


<sec:authorize access="isAuthenticated()">
<c:url var="logoutUrl" value="/logout.do"/>
<form action="${logoutUrl}" method="post">
    <input type="submit" value="Logout"/>
</form>
</sec:authorize>

<h3>
	
    <sec:authorize access="isAuthenticated()"> [<a href="<c:url value="/gallery/gallery.do" />">나의 갤러리</a>] </sec:authorize>
    <sec:authorize access="isAuthenticated()"> [<a href="<c:url value="/loginhis/loginhistory.do" />">접속이력</a>] </sec:authorize>  
    <sec:authorize access="isAnonymous()"> [<a href="<c:url value="/login/signin.do" />">회원가입</a>]</sec:authorize>
    
    
</h3>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
<!-- 
isAnonymous()
익명의 사용자일 경우, 로그인, 회원가입 버튼을 노출합니다.
isAuthenticated()
인증된 사용자일 경우, 로그아웃 버튼을 노출줍니다.
hasRole()
특정 롤을 가진 사용자에 대해, 메뉴를 노출합니다.
 -->