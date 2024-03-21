<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update</title>
    <style>
        label {
            display: inline-block;
            width: 200px;
        }
        input {
            margin-bottom: 10px; 
        }
    </style>
</head>
<body>
    <h1>
        수정 결과 화면
    </h1>
	<c:if test="${updated != 0}">
		수정되었습니다 
	</c:if>
	
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
	
	<form id="update" action="boards" method="post">
		<input type="hidden" id = "action" name="action" value="">
		<input type="hidden" name="bno" value="${param.bno}">
		<input type="button" value="목록" onclick="jsList()">
		<input type="button" value="상세 보기" onclick="jsView()">
	</form>
	
</body>
</html>

