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
	<h1>게시물 수정 정보 입력</h1><br>
	<label for="bno">게시물 번호 : <input type = "text" id = "bno" name = "bno" value = "${board.bno}" readonly></label><br>
	<label for="bwriter">글쓴이 : <input type = "text" id = "bwriter" name = "bwriter" value = "${board.bwriter}" required></label><br>
	<label for="btitle">제목 : <input type = "text" id = "btitle" name = "btitle" value = "${board.btitle}" required></label><br>
	<label for="bcontent">내용 : <input type = "text" id = "bcontent" name = "bcontent" value = "${board.bcontent}" required></label><br>
	<label for="bdate">작성일 : <input type = "text" id = "bdate" name = "bdate" value = "${board.bdate}" readonly></label><br><br>
	<input type="hidden" id = "action" name="action" value="">
	<input type="hidden" name="userid" value="${board.bno}">
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