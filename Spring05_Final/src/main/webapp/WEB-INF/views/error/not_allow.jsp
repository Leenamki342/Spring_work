<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/error/db_fail.jsp</title>
</head>
<body>
<div class="container">
	<h1>허용되지 않는 요청입니다.</h1>
	<p>${exception.message }</p>
	<a href="${pageContext.request.contextPath }/">home</a>
</div>
</body>
</html>