<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	제목 : ${resultVo.title }<br>
	${pageContext.request.contextPath }/resources/images/${resultVo.filename}<br>
	<img src="${pageContext.request.contextPath }/resources/images/${resultVo.filename}"
		 width="200px"> <br>
	<a href="insert_form.do">또 등록하기</a>
</body>
</html>