<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View</title>
    <style>
		th, td {
		  border: 1px solid;
		}
		th {
			border-color : #96D4D4;
		}
		td {
			border-color : #D6EEEE;
		}
		tr:nth-child(even) {
		  background-color: #D6EEEE;
		  color:#96D4D4;
		}
		tr:nth-child(odd) {
		  background-color: #96D4D4;
		  color:white;
		}
	</style>
</head>
<body>
    <h1>
        게시물 상세 화면
    </h1> 
    <table>
        <tr>
            <th>게시물 번호</th>
            <th>글쓴이</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성일</th>
        </tr>
        <tr>
            <td onclick="jsView('${board.bno}')" style="cursor:pointer;">${board.bno}</td>
            <td>${board.bwriter}</td>
            <td>${board.btitle}</td>
            <td>${board.bcontent}</td>
            <td>${board.bdate}</td>	            
        </tr>
    </table>
	
<script>
	function jsList() {
		action.value = "list";
		
		viewForm.submit();
	}
	
	function jsView(uid) {
	   //인자의 값을 설정한다 
	   userid.value = uid;
	   
	   //양식을 통해서 서버의 URL로 값을 전달한다
	   viewForm.submit();   
	}
	
	function jsDelete() {
		if (confirm("정말로 삭제하시겠습니까?")) {
			//서버의 URL을 설정한다 
			action.value = "delete";
		
			//서버의 URL로 전송한다 
			viewForm.submit();
		}
	}
	
	function jsUpdateForm() {
		//서버의 URL을 설정한다 
		action.value = "updateForm";
	
		//서버의 URL로 전송한다 
		viewForm.submit();
	}
</script>
    <!-- 두개의 폼을 하나로 합치는 방법 , js를 사용하여 처리  -->
	<form id="viewForm" action="users" method="post">
		<input type="hidden" id = "action" name="action" value="">
		<input type="hidden" name="bno" value="${board.bno}">
		<input type="button" value="목록" onclick="jsList()">
		<input type="button" value="삭제" onclick="jsDelete()">
		<input type="button" value="수정" onclick="jsUpdateForm()">
	</form>
</body>
</html>