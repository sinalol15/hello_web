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

<Form id="updateForm" action="users" method="post">
	<h1>회원가입 수정 정보 입력</h1><br>
	<label for="id">id : <input type = "text" id = "id" name = "id" value = "${user.userid}" readonly></label><br>
	<label for="password">password : <input type = "password" id = "password" name = "password" value = "${user.userpassword}" required></label><br>
	<label for="name">name : <input type = "text" id = "name" name = "name" value = "${user.username}" required></label><br>
	<label for="age">age : <input type = "text" id = "age" name = "age" value = "${user.userage}" required></label><br>
	<label for="mail">email : <input type = "email" id = "mail" name = "mail" value = "${user.usermail}" required></label><br><br>
	<input type="hidden" id = "action" name="action" value="">
	<input type="hidden" name="userid" value="${user.userid}">
	<input type="button" value="취소" onclick="jsCancle()">
	<input type="button" value="수정" onclick="jsUpdate()">
</Form>

<script>
	function jsCancle() {
		action.value = "list";
		
		updateForm.submit();
	}
	
	function jsUpdate() {
		if (confirm("정말로 수정하시겠습니까?")) {
			//서버의 URL을 설정한다 
			action.value = "update";
		
			//서버의 URL로 전송한다 
			updateForm.submit();
		}	
	}
</script>

</body>
</html>