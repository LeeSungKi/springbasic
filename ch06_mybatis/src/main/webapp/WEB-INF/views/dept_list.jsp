<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--dept테이블 정보를 출력  -->
	<c:forEach var="v" items="${list}">
		${v.no} / ${v.name} / ${v.regdate} <button onclick="location.href='delete.do?no=${v.no}'">삭제</button><br>
	</c:forEach>
	<button onclick="location.href='write_view.do'">추가</button>
</body>
</html>