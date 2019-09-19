<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "insert.do" method = "post" enctype="multipart/form-data">
		작성자 : <input type = "text" name = "name" required><br>
		제목 : <input type = "text" name = "title" required><br>
		사진 : <input type = "file" name = "image" required><br>
		<input type = "submit" value = "전송">
	</form>
</body>
</html>