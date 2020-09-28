<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.std.sec.gallery.GalleryDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>
<title>Gallery</title>

</head>
<body>

<h1>my gallery</h1>

<c:choose>
	<c:when test="${not empty msg }">
		<p>${msg}</p>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${not empty Path }">
		<p>${Path}</p>
	</c:when>
</c:choose>

<form method="post" action="fileupload.do"  enctype="multipart/form-data">    
    <input type="file" class="form-control" id="uploadfile" name="uploadfile" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">upload</button>
</form>

<c:choose>
	<c:when test="${empty List }">
		<p>내용없음</p>
	</c:when>
	<c:otherwise>
		<c:forEach var="galleryDto" items="${List}" >			
			<a href="#" onClick="popup('${galleryDto.username}','${galleryDto.filename}');">
			<img src="resources/picture/${galleryDto.filename}" width="100px" height="100px"/>
			<img src="${Path}${galleryDto.filename}" width="100px" height="100px"/>
			</a>
		</c:forEach>
	</c:otherwise>
</c:choose>
<script>
       function popup(username,filename){
           var url = "popup.do?username="+username+"&filename="+filename;
           var name = "detail";
           var option = "top = 100, left = 200, location = no"
           window.href=url
           window.open(url, name, option);
       }
</script>
</body>
</html>