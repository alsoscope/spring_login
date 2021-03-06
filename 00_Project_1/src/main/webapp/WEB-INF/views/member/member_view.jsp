<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 상세보기</title>
<%@ include file="../include/member_header.jsp" %>
<script>
//수정. 삭제 버튼 클릭 이벤트 jQuery코드 작성. 비밀번호 일치할 때 요청 처리 불일치하면 div에 불일치 문ㄴ구 출력
	$(document).ready(function(){
		$("#btnUpdate").click(function(){
			//확인 대화 상자
			if(confirm("수정하시겠습니까?")){				
			document.form1.action="${path}/member/update.do";
			document.form1.submit();
			}
		});
	});
	$(document).ready(function(){
		$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.form1.action="${path}/member/delete.do";
				document.form1.submit();
			}
		});
	});
</script>
</head>
<body>
<%@ include file="../include/member_menu.jsp" %>
	


	<h2>회원정보 상세보기</h2>
	<form name="form1" method="post">
	<table border="1" width="400px">
		<tr>
			<td>아이디</td>
			<!-- 아이디는 수정이 불가능 하도록 readonly 속성 추가 -->
			<td><input name="userId" value="${dto.userId }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPw"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input name="userName" value="${dto.userName }"></td>
		</tr>
		<tr>
			<td>회원가입일자</td>
			<td><fmt:formatDate value="${dto.userRegdate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td>회원정보 수정일자</td>
			<td><fmt:formatDate value="${dto.userUpdatedate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="삭제" id="btnDelete">
				<div style="color:red";>${message }</div>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>