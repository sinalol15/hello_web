<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>UpdateForm</title>
</head>
<body>
	<c:if test="${not empty user}">
		회원 정보 등록<br>
	</c:if>

	<form action="users" method="post">
		<input type="hidden" name="action" value="list">
		<input type="submit" value="목록">
	</form>
	<form action="users" method="post">
		<input type="hidden" name="action" value="view">
		<input type="submit" value="상세보기">
	</form> 
</body>
</html>