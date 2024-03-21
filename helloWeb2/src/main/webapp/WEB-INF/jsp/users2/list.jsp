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
	<h1>회원목록</h1>
	  
    <form id="searchForm" action="user.do" method="post" >
    	<input type="hidden" id="action" name="action" value="list">
    	<label>이름 : </label>
    	<input type="text" id="searchKey" name="searchKey" value="${param.searchKey}">
    	<input type="submit" value="검색">
    </form>
    
    <form id="listForm" action="user.do" method="post">
    	<input type="hidden" id="action" name="action" value="view">
    	<input type="hidden" id="userid" name="userid" >
    </form>
<!--     
    <form id="listForm2" action="users" method="get">
    	<input type="hidden" id="action" name="action" value="view">
    	<input type="hidden" id="userid" name="userid" >
    </form>
    <form id="listForm3" action="users?action=view" method="get">
    	<input type="hidden" id="userid" name="userid" >
    </form>
    <form id="listForm3" action="users?action=view" method="post">
    	<input type="hidden" id="userid" name="userid" >
    </form>
 -->    
    <table>
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>나이</th>
            <th>이메일</th>
        </tr>
        <c:forEach var="user" items="${list}">
        <tr>
            <td onclick="jsView('${user.userid}')"  style="cursor:pointer;">${user.userid}</td>
            <td>${user.username}</a></td>
            <td>${user.userage}</td>
            <td>${user.usermail}</td>
        </tr>
        </c:forEach>
    </table>
<script>
function jsView(uid) {
	//인자의 값을 설정한다 
	userid.value = uid;
	
	//양식을 통해서 서버의 URL로 값을 전달한다
	listForm.submit();
	
}
</script>      
<form action = "user.do" method = "post">
	<input type = "hidden" name = "action" value="insertForm">
	<input type = "submit" value = "등록">
</form>
</body>
</html>

