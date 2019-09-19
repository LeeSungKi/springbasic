<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	function func(select) {
		if(select == 1){
			f.action = "result_pokemon1";
		}else if(select == 2){
			f.action = "result_pokemon2";
		}
		f.submit();
		
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form name="f" method="POST">
		<table border="1">
			<tr>
				<td >이름</td>
				<td>레벨</td>
				<td>체력</td>
			</tr>
			<tr>
				<td><input type="text" name="name"></td>
				<td><input type="text" name="level"></td>
				<td><input type="text" name="hp"></td>
			</tr>
		</table>
				<button onclick="func(1)">이름만</button>
				<button onclick="func(2)">모두</button>
	</form>

</body>
</html>