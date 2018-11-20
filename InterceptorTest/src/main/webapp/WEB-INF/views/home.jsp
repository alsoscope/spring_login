<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
기존의 home.jsp는 session이 false로 처리되어 HttpSession을 이용할 수 없기 때문에 제거한다.
<%@ page session="false" %> --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h2>${result }</h2>
</body>
</html>
