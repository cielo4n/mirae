<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="apple-touch-icon" href="/soap/resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="/soap/resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="/soap/resources/css/index.css"/>
		
	<title>자연맘</title>
<%
	request.setCharacterEncoding("UTF-8");
	String orderPage = (String)request.getParameter("page");
	
	if(orderPage==null){ orderPage = "order"; }
%>
  </head>
  <body>


	<header>
		<%@include file="../_default_header.jsp" %>
	</header>

	
	<div id="container">
		<%@include file="../_default_menu.jsp" %>
		<!-------------Start content--------------------------------------------------->
		<div id="content">
		<c:if test="${page.equals('order') }">
			<%@include file="_order.jsp" %>
		</c:if>
		<c:if test="${page.equals('order_complete') }">
			<!-- 결제하기 버튼을 누르면 주문완료페이지 include -->
			<%@include file="_order_complete.jsp" %>
		</c:if>
		</div>
		<!--------------------------------------------------end content--------->
	</div><!-- end container -->


	<footer>
		<%@include file="../_default_footer.jsp" %>
	</footer>

  </body>
</html>
