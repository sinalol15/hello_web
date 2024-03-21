<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
<form action = "users" method = "post">
	<c:if test="${not empty board}">
		게시물 삭제<br>
	</c:if>
	<input type = "hidden" name = "action" value="list">
	<input type = "submit" value = "목록">
</form>
</body>
</html>