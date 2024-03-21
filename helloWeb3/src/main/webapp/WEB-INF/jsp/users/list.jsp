<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List</title>
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
    <h1>게시물 목록</h1>
    
    <form id="listForm" action="users" method="post">
       <input type="hidden" id="action" name="action" value = "view">
       <input type="hidden" id="bno" name="bno">
    </form>
    <table>
        <tr>
            <th>게시물 번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성 날짜</th>
        </tr>
        <c:forEach var="board" items="${list}">
        <tr>
            <td onclick="jsView('${board.bno}')"  style="cursor:pointer;">${board.bno}</td>
            <td>${board.bwriter}</td>
            <td>${board.btitle}</td>
            <td>${board.bcontent}</td>
            <td>${board.bdate}</td>
        </tr>
        </c:forEach>
    </table>
<script>
function jsView(bn) {
   //인자의 값을 설정한다 
   bno.value = bn;
   
   //양식을 통해서 서버의 URL로 값을 전달한다
   listForm.submit();
   
}
</script>      
<form action = "users" method = "post">
	<input type = "hidden" name = "action" value="insertform">
	<input type = "submit" value = "등록">
</form>
</body>
</html>
