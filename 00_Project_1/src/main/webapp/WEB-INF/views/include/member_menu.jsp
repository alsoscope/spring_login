<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- context 경로 -->
		<c:if test="${login.userId==null }">
			GUEST
		</c:if>
		<c:if test="${login.userId!=null}">
			${login.userId }님 로그인 중
		</c:if>
<c:set var="path" value="${pageContext.request.contextPath }"/>
	<div style="text-align:center";>
		<c:choose>
			<c:when test="${ login.userId!=null}">
				<a href="${path }/member/list.do">회원목록</a>
				<a href="${path }/member/logout.do" onclick="return confirm('로그아웃 하시겠습니까?');">로그아웃</a>
			</c:when>
			<c:otherwise>		
				<a href="${path }/member/loginGET.do">로그인</a>
				<a href="${path }/member/member_write.do">회원가입</a>
			</c:otherwise>
		</c:choose>
	</div>
	<hr>