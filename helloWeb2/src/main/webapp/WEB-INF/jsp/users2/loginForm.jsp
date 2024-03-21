<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인 화면</title>
    <style>
        label {
            display: inline-block;
            width: 120px;
        }
        input {
            margin-bottom: 10px; 
        }
    </style>
</head>
<c:if test="${not empty param.err}">
<script>
	alert("아이디 또는 비밀번호가 잘못되었습니다");
</script>	
</c:if>
<body>
    <h1>
        로그인 화면
    </h1>
    <form id="rForm" action="user.do" method="post">
    	<input type="hidden" name="action" value="login">
        <label>아이디 : </label> <input type="text" id="userid" name="userid" required="required"><br/>
        <label>비밀번호 : </label>   <input type="password" id="userpassword" name="userpassword" required="required"><br/>
    <div>
        <input type="submit" value="로그인">
        <a href="user.do?action=list">취소</a>
    </div>
    
    </form>
    
    <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
    
    <script type="text/javascript">
    /*
    const rForm = document.getElementById("rForm");
    
    rForm.addEventListener("submit", e => {
    	//서버에 form data를 전송하지 않는다 
    	e.preventDefault();
    	
		myFetch("user.do", "rForm", json => {
			if(json.status == 0) {
				//성공
				alert("로그인 되었습니다");
				location = "boards?action=list";
			} else {
				alert(json.statusMessage);
			}
		});
    });
    */
    </script>
    
</body>
</html>