<%@page import="com.test.ch04.MyProp"%>
<%@page import="com.test.ch04.MyMap"%>
<%@page import="com.test.ch04.MyList"%>
<%@page import="com.test.ch04.MySet"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		WebApplicationContext ctx =
			WebApplicationContextUtils.getWebApplicationContext(application);
		MySet s = ctx.getBean("mySetBean", MySet.class);
		MyList l = (MyList)ctx.getBean("myListBean");
		MyMap m = (MyMap)ctx.getBean("myMapBean");
		MyProp p = ctx.getBean("myPropBean", MyProp.class);
		
		pageContext.setAttribute("my1", s.getTestSet());
		pageContext.setAttribute("my2", l.getTestList());
		pageContext.setAttribute("my3", m.getTestMap());
		pageContext.setAttribute("my4", p.getTestProp());
	%>
	<h1>MySetBean</h1>
	<ul>
		<c:forEach var = "e" items = "${my1 }">
			<li>${ e}</li>
		</c:forEach>
	</ul>
	
	<h1>MyListBean</h1>
	<ul>
		<c:forEach var = "e" items = "${my2 }">
			<li>${ e}</li>
		</c:forEach>
	</ul>
	
	<h1>MyMapBean</h1>
	<ul>
		<li>${ my3.pok1 }</li>
		<li>${ my3.pok2 }</li>
		<li>${ my3['pok3'] }</li>
		<li>${ my3['pok4'] }</li>
	</ul>
	
	<h1>MyPropBean</h1>
	<ul>
		<li>${ my4.driver }</li>
		<li>${ my4.url }</li>
		<li>${ my4['user'] }</li>
		<li>${ my4['password'] }</li>
	</ul>
</body>
</html>









