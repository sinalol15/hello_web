<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>InsertForm</title>
</head>
<body>

<Form id="insertForm"  action="users" method="post">
	<input type="hidden" id = "action" name="action" value="">
	<h1>게시물 정보 입력</h1><br>
	<label for="bwriter">작성자 : <input type = "text" id = "bwriter" name = "bwriter" required></label><br>
	<label for="btitle">제목 : <input type = "text" id = "btitle" name = "btitle" required></label><br>
	<label for="bcontent">내용 : <input type = "text" id = "bcontent" name = "bcontent" required></label><br><br>
	<input type="button" value="취소" onclick="jsCancle()">
	<input type="button" value="등록" onclick="jsInsert()">
</Form>

<script>
	function jsCancle() {
		action.value = "list";
		
		insertForm.submit();
	}
	
	function jsInsert() {
		if (confirm("정말로 등록 하시겠습니까?")) {
			//서버의 URL을 설정한다 
			action.value = "insert";
		
			//서버의 URL로 전송한다 
			insertForm.submit();
		}	
	}
</script>

</body>
</html>