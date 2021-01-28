<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
<div class="container">
	<h1>HomePage</h1>
	<ul>
		<li><a href="member/list.do">회원 목록</a></li>
		<li><a href="json01.do">json01 테스트</a></li>
		<li><a href="json02.do">json02 테스트</a></li>
		<li><a href="json03.do">json03 테스트</a></li>
		<li><a href="json04.do">json04 테스트</a></li>
	</ul>
	<h2>파일 업로드 테스트</h2>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		제목 <input type="text" name="title"/>
		첨부 파일 <input type="file" name="myFile" />
		<button type="submit">업로드</button>
	</form>
	<h2>파일 업로드 테스트2</h2>
	<form action="upload2.do" method="post" enctype="multipart/form-data">
		제목 <input type="text" name="title"/>
		첨부 파일 <input type="file" name="myFile" />
		<button type="submit">업로드</button>
	</form>
</div>
</body>
</html>