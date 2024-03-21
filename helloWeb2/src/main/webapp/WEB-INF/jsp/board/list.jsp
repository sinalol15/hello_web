<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 목록</title>
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
	<h1>게시물목록</h1>
	<h3>로그인 : ${loginVO.username}</h3>
    <form id="searchForm" action="boards" method="post" >
    	<input type="hidden" id="action" name="action" value="list">
    	<label>제목</label>
    	<input type="text" id="searchKey" name="searchKey" value="${param.searchKey}">
    	<input type="submit" value="검색">
    </form>
    
    <form id="listForm" action="boards" method="post">
    	<input type="hidden" id="action" name="action" value="view">
    	<input type="hidden" id="bno" name="bno" >
    </form>
   
    <table>
        <tr>
            <th>게시물번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        <c:forEach var="board" items="${list}">
        <tr>
            <td onclick="jsView('${board.bno}')"  style="cursor:pointer;">${board.bno}</td>
            <td>${board.btitle}</td>
            <td>${board.bwriter}</td>
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
<form action = "boards" method = "post">
	<input type = "hidden" name = "action" value="insertForm">
	<input type = "submit" value = "등록">
</form>
</body>
</html>

