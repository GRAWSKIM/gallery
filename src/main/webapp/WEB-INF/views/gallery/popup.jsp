<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.std.sec.gallery.GalleryDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>

<c:choose>
	<c:when test="${empty dto }">
		<p>조회실패</p>
	</c:when>
	<c:otherwise>
	<div><img src="${Path}${dto.filename}"/></div>
	<div><h3>파일명: ${dto.fileSize}, 업로드시간: ${dto.uploadDate}, 업로더 :${dto.username}</h3></div>
	</c:otherwise>
</c:choose>
</body>
</html>