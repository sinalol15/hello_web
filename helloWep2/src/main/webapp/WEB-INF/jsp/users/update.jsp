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
	회원 정보 수정<br>
	
	<script>
		function jsList() {
			action.value = "list";
			
			update.submit();
		}
		
		function jsView() {
			//서버의 URL을 설정한다 
			action.value = "view";
		
			//서버의 URL로 전송한다 
			update.submit();
		}
	</script>
	
	<form id="update" action="users" method="post">
		<input type="hidden" id = "action" name="action" value="">
		<input type="hidden" name="userid" value="${param.userid}">
		<input type="button" value="목록" onclick="jsList()">
		<input type="button" value="상세 보기" onclick="jsView()">
	</form>
	
</body>
</html>