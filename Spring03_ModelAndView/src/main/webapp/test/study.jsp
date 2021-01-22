<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test/study.jsp</title>
</head>
<body>
<h1>스터디 카페</h1>
<p>조용히 해주세요!</p>
<a href="../home.do">home</a>
<a href="${pageContext.request.contextPath }/home.do">home</a><br />
<a href="${pageContext.request.contextPath }/">home</a>
</body>
</html>