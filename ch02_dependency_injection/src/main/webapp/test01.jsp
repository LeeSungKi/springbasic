<%@page import="vo.PokemonVo"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
    	//root-context.xml 에 등록된 bean 객체 받기
    	WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
    	
    	PokemonVo pok1 = (PokemonVo)ctx.getBean("p1");
    	PokemonVo pok2 = (PokemonVo)ctx.getBean("p2");
    	PokemonVo pok3 = (PokemonVo)ctx.getBean("p3");
    	
    	//PokemonVo pok3 = ctx.getBean("p3",PokemonVo.class); 다른방법
    	
    	//받아온 bean을 attr로 등록
    	pageContext.setAttribute("pk1", pok1);
    	pageContext.setAttribute("pk2", pok2);
    	pageContext.setAttribute("pk3", pok3);
    	
    	
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
포켓몬1 : ${pk1}<br>
${pk1.name } / ${pk1.level } / ${pk1.hp }<br>

포켓몬2 : ${pk2}<br>
${pk2.name } / ${pk2.level } / ${pk2.hp }<br>

포켓몬3 : ${pk3}<br>
${pk3.name } / ${pk3.level } / ${pk3.hp }<br>
</body>
</html>