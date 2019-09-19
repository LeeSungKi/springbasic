<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
		href="${pageContext.request.contextPath }/resources/css/visit.css">
<script src = "${pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
<script>
	function del(f){ // 삭제할 때 비번확인용
		var pwd = f.pwd.value;
		var c_pwd = f.c_pwd.value;
		if(pwd != c_pwd){
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
		if(!confirm("정말 삭제하시겠습니까?")) { // confirm() : 예/아니오 선택하는 alert() 창.
											// '예' 선택하면 true 리턴. 취소누르면 false 리턴
			return;
		}
		
		var url = "delete.do";
		var param = "idx=" + f.idx.value;
		sendRequest( url, param, resultFn, "GET");//ajax통신
	}
	//비동기통신끝나면 callBack메서드부분
	function resultFn() {
		console.log(xhr.readyState+"/"+xhr.status);
		if(xhr.readyState == 4 && xhr.status == 200){
			// 도착된 데이터를 읽어옴 
			var data = xhr.responseText;//도착한 응답 메시지 body를 text 로 읽어들임
					//xhr.responseXML//도착한 응답 메시지 body를 XML 로 읽어들임
			if(data == 'no'){
				alert("삭제 실패");
				return;
			}
			alert("삭제 성공");
			location.href='list.do';
		}
	}
	function modify(f) {
		var pwd = f.pwd.value; // 원래 비번
		var c_pwd = f.c_pwd.value; // 방금 입력한 비번
		if(pwd != c_pwd){
			alert('입력한 비밀번호가 틀립니다.');
			return;
		}
		f.action = "modify_form.do";
		f.submit();
	
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${pageContext.request.contextPath } <br>
	<div id = "main_box">
		<div align = "center">
			<input type = "button" value = "글쓰기" 
					onclick = "location.href='insert_form.do'">
			<h1>::: 방명록 리스트 :::</h1>
		</div>
		<c:forEach var = "vo" items="${list }">
			<div class = "visit_box">
				<div class = "type_content">${vo.content }</div>
				<div class = "type_name">작성자 : ${vo.name }(${vo.ip })</div>
				<div class = "type_regdate">작성일자 : ${vo.regdate }</div>
				<div>
					<form>
						<input type = "hidden" name = "idx" value = "${vo.idx }">
						<input type = "hidden" name = "pwd" value ="${vo.pwd }">
						비밀번호(${vo.pwd }) <input type = "password" name = "c_pwd">
						<input type = "button" value = "수정" onclick="modify(this.form)">
						<input type = "button" value = "삭제" onclick="del(this.form)">
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>