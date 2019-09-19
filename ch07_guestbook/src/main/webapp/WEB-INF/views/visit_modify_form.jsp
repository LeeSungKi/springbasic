<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function send(f) {
		
		var pwd = f.pwd.value;
		
		if(pwd != "${vo.pwd}"){
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
		var url = "modify.do";
		var param = "idx=" + ${vo.idx}
				  + "&name=" + encodeURIComponent(f.name.value)
				  + "&content=" + encodeURIComponent(f.content.value)
				  + "&pwd=" + encodeURIComponent(f.pwd.value)
				  sendRequest(url,param,resultFn,"GET");
				//( 요청할url,요청할 때 동봉할 파라미터, 응답메시지가 오면 실행할 js함수, 요청방식)
	}
	function resultFn() {
		console.log(xhr.readyState + "," + xhr.status);
		if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
							//4랑같은의미
			var data = xhr.responseText;// response 메시지의 body를 일반 text로인식
						//xhr.responseXM;// response 메시지의 body를 일반 XML로인식
			if(data == "no"){
				alert("수정 실패");
				return;
			}
			alert("수정 완료");
			location.href = "list.do";
		}
	}
</script>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
</head>
<body>
	<form>
		<table border="1" align="center">
			<tr>
				<th>작성자</th>
				<td><input type = "text" name = "name" value = "${vo.name}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" name="content">${vo.content}</textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${vo.pwd}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value ="수정하기" onclick="send(this.form)">
					<input type="button" value="취소" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>





















