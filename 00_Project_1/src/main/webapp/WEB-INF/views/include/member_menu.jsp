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
		<a href="${path }/member/list.do">회원목록</a>
		<a href="${path }/member/loginGET.do">로그인</a>
		<a href="${path }/member/member_write.do">회원가입</a>
	</div>
	<hr>