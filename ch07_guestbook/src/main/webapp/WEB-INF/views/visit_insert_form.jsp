<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
	function  send(f) {
		var name = f.name.value;
		var content = f.content.value;
		var pwd = f.pwd.value;
		if(name == ''){
			alert("작성자이름을 입력하세요");
			return;
		}
		if(content == ''){
			alert("내용을입력하세요");
			return;
		}
		if(pwd == ''){
			alert("비밀번호를 입력하세요");
			return;
		}
		f.action = "insert.do";
		f.submit();
	}
</script>
<style>
	#textfield{width: 100%;}
	textarea {
	width: 95%;
	height: 100%;
	resize: none;
	}
</style>
</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>::방명록 쓰기::</caption>
				<tr>
					<th>작성자</th>
					<td><input name="name" class="textfield"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td style="height: 200px">
						<textarea name="content"></textarea>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" class="textfield"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="글쓰기" onclick="send(this.form)">
						<input type="button" value="목록으로" onclick="location.href='list.do'">
					</td>
				</tr>
		</table>
	
	
	</form>



</body>
</html>

















