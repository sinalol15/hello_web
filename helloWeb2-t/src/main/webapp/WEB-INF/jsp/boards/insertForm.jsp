<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>등록화면</title>
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
<body>
    <h1>
        게시물 등록양식 
    </h1>
    <form action="boards" method="post">
    	<input type="hidden" name="action" value="insert">
        <label>제목 : </label><input type="text" id="btitle" name="btitle" ><br/>
        <label>내용 : </label><input type="text" id="bcontent" name="bcontent" ><br/>
        <label>작성자 : </label>   <input type="text" id="bwriter" name="bwriter" required="required"><br/>
    <div>
        <input type="submit" value="등록">
        <a href="boards?action=list">취소</a>
    </div>
    
    </form>
    
</body>
</html>
