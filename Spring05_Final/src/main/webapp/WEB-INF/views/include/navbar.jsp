<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	// "thisPage" 라는 파라미터 명으로 전달된 문자열 읽어오기 
 	String thisPage=request.getParameter("thisPage");
 	//NullPointerException 방지 (500번 버스 안타기)
 	if(thisPage==null){
 		thisPage="";
 	}
 %>
 <nav class="navbar navbar-dark bg-primary navbar-expand-sm fixed-top">
	<div class="container">
	  	<a class="navbar-brand" href="${pageContext.request.contextPath }/">
	  		<img style="width:30px;height:30px" src="${pageContext.request.contextPath }/resources/images/water1.png"/>turtle's Cafe
	  	</a>
		<button class="navbar-toggler" data-toggle="collapse" data-target="#topNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="topNav">
			<ul class="navbar-nav mr-auto">
				
				<li class="nav-item ${param.thisPage eq 'cafe' ? 'active' : '' }">
					<a class="nav-link" href="${pageContext.request.contextPath }/cafe/list.do">카페 게시글 목록</a>
				</li>
				<li class="nav-item ${param.thisPage eq 'file' ? 'active' : '' }">
					<a class="nav-link" href="${pageContext.request.contextPath }/file/list.do">파일 목록</a>
				</li>
				<li class="nav-item ${param.thisPage eq 'gallery' ? 'active' : '' }">
					<a class="nav-link" href="${pageContext.request.contextPath }/gallery/list.do">갤러리 목록</a>
				</li>
				
			</ul>	
			<%
				// 로그인된 아이디가 있는지 읽어온다.
				String id=(String)session.getAttribute("id");
			%>
			<c:choose>
				<c:when test="${empty sessionScope.id }">
					<a class="btn btn-success btn-sm" 
					href="${pageContext.request.contextPath }/users/loginform.do">로그인</a>
					<a class="btn btn-danger btn-sm ml-1" 
					href="${pageContext.request.contextPath }/users/signup_form.do">회원가입</a>
				</c:when>
				<c:otherwise>
					<span class="navbar-text">
						<a href="${pageContext.request.contextPath }/users/private/info.do">${id }</a>
						<a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath }/users/logout.do ">로그아웃</a>
					</span>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>
