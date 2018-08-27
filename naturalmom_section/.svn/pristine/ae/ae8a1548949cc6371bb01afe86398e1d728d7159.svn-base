<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="/soap/resources/admin/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="/soap/resources/js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="/soap/resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="/soap/resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="/soap/resources/admin/css/admin_common.css" />
	
	<title>자연맘</title>
<% 
	request.setCharacterEncoding("UTF-8");
%>
	
   </head>

  <body>

	<header>
		<%@include file="../../_default_header.jsp" %>
	</header>

<!---Start container----------------------------------------------------------------->
	
	<div id="container">
		<c:choose>
			<c:when test="${not empty qwa}">
				<%@ include file = "_a_board_qna_add_form.jsp" %>
			</c:when>
			<c:when test="${not empty qwe}">
				<%@ include file = "_a_board_qna_edit_form.jsp" %>
			</c:when>
			<c:when test="${not empty secret}">
				<%@ include file = "_a_board_qna_read_secret.jsp" %>
			</c:when>
			<c:when test="${not empty param.qr_no}">
				<%@ include file = "_a_board_qna_read.jsp" %>
			</c:when>
			<c:otherwise>
				<%@include file="_a_board_qna_list.jsp" %>
			</c:otherwise>
		</c:choose>
	</div>
<!--------------------------------------------------------end container------------->
  </body>

</html>
