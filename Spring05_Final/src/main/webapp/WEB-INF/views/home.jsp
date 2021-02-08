<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/index.jsp</title>
<jsp:include page="include/resource.jsp"></jsp:include>
</head>
<body>
<jsp:include page="include/navbar.jsp"></jsp:include>
<div class="container">
	<%-- 만일 id 가 null 이 아니면 로그인을 한 상태이다. --%>
	<c:if test="${not empty id }">
		<p>
			<a href="users/private/info.do">로그인 정보</a><br />
			<a href="users/logout.do">로그아웃</a>
		</p>
	</c:if>
	<h1>인덱스 페이지입니다.</h1>
	<ul>
		<li><a href="users/signup_form.do">회원가입</a></li>
		<li><a href="cafe/private/insertform.do">카페 글쓰러 가기</a></li>
	</ul>
</div>
</body>
</html>