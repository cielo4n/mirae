<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="/soap/resources/admin/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="../resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="../resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="../resources/admin/css/admin_common.css"/>
		
	<title>자연맘</title>
	
   </head>
  <body>

	<header>
		<%@include file="../_default_header.jsp" %>
	</header>

<!---Start container----------------------------------------------------------------->
	
	<div id="container">

		<div id = "result_box">
			<c:if test="${param.rslt eq 'true'}">
				<p>상품 등록(수정)에 성공하였습니다.</p>
			</c:if>
			<c:if test="${param.rslt eq 'false'}">
				<p>상품 등록(수정)에 실패하였습니다.</p>
			</c:if>
			
		</div>

	</div>
	
	
<!--------------------------------------------------------end container------------->
  </body>

</html>
