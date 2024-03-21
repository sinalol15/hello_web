<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
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
       나의페이지
    </h1>
   
      <label>아이디 : ${loginVO.userid}</label> <br/>
      <label>이름 : ${loginVO.username}</label><br/>
      <label>나이: ${loginVO.userage}</label><br/>
      <label>이메일: ${loginVO.usermail}</label><br/>

<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
<script>
function jsDelete() {
	if (confirm("정말로 탈퇴하시겠습니까?")) {
		action.value = "delete";
		myFetch("user.do", "viewForm", json => {
			if(json.status == 0) {
				//성공
				alert("회원정보를 삭제 하였습니다");
				location = "user.do?action=list";
			} else {
				alert(json.statusMessage);
			}
		});
	}
}

function jsUpdateForm() {
	if (confirm("정말로 수정하시겠습니까?")) {
		//서버의 URL을 설정한다 
		action.value = "updateForm";
	
		//서버의 URL로 전송한다 
		viewForm.submit();
	}	
}

</script>
<!-- 두개의 폼을 하나로 합치는 방법 , js를 사용하여 처리  -->
	<form id="viewForm" method="post" action="user.do">
		<input type="hidden" id="action" name="action" value="">
		<input type="hidden" id="userid" name="userid" value="${user.userid}">
		<input type="button" value="삭제" onclick="jsDelete()">
		<input type="button" value="수정" onclick="jsUpdateForm()">
	</form>     
 
</body>
</html>