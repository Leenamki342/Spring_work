<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Web -> JSP -> temp -> New JSP File (html5) -> edit -> 위의 코드 복붙 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h1>인덱스 페이지</h1>
	<ul>
		<!-- .do를 사용하지 않았기 때문에 DispatcherServlet을 거치지 않음 -->
		<li><a href="test/play.html">놀러가기(DispatcherServlet 을 거치지 않음)</a></li>
		<li><a href="test/study.jsp">공부하기(DispatcherServlet 을 거치지 않음)</a></li>
		<li><a href="friend/list.do">친구 목록</a></li>
		<li><a href="friend/list2.do">친구목록 2</a></li>
		<li><a href="${pageContext.request.contextPath }/friend/list3.do">친구목록 3</a></li>
		<li><a href="friend/delete.do?num=1">1번 친구 삭제</a></li>
		<li><a href="friend/delete.do?num=2">2번 친구 삭제</a></li>
	</ul>
	<h2>공지사항</h2>
	<ul>
		<c:forEach var="tmp" items="${noticeList }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>