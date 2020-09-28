<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.std.sec.log.LogDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력 조회</title>
</head>
<body>
	<table border="1">
	<th>날짜</th>
	<th>작업내용</th>
	<c:choose>
		<c:when test="${empty LIST}">
			<tr>
			<td></td>
			<td>조회실패</td>
			</tr>	
		</c:when>	
		<c:otherwise>
			<c:forEach var="item" items="${LIST}" >
				<tr>
				<td>${item.date}</td>
				<c:choose>
				<c:when test="${item.type eq '0'}"><td>회원가입</td></c:when>
				<c:when test="${item.type eq '1'}"><td>로그인</td></c:when>
				<c:when test="${item.type eq '2'}"><td>로그아웃</td></c:when>	
				</c:choose>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>	
	</table>
</body>
</html>