<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center" style = "width:400px">
		<c:forEach var = "vo" items = "${list }">
			<table border = "1">
				<tr>
					<th>제목</th>
					<td width = "80%">${vo.title }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${vo.name}</td>
				</tr>
				
				<tr>
					<td colspan = "2" style = "height:400px">
						<img src = "${pageContext.request.contextPath }/resources/images/${vo.filename}" width = "100%" height= "100%">
					</td>
				</tr>
			</table>	
			<hr/>
		</c:forEach>
	</div>
</body>
</html>