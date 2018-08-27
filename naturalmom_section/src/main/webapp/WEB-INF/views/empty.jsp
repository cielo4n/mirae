<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="resources/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="resources/css/index.css"/>
	
	<style type="text/css">
	button { 
	padding : 7px 30px;
	margin : auto;
	background-color : #85858D;
	color : white;
	font-family : "나눔바른고딕", "맑은 고딕";
	font-size : 16px;
	border-radius : 10px; 
	border : 0px;
	}
	
	p { text-align: center; }
	</style>
		
	<title>자연맘</title>
	
   </head>
	<body>

	<header>
		<%@include file="_default_header.jsp" %>
	</header>

	<div id="container" style="padding: 50px;">
		<hr>
		<h2 style="text-align: center; padding: 80px;">${flash_msg}</h2>
		
		<p>
		<button onclick="location.href='index.nm'">홈으로</button>
		</p>
	</div>
<!--Start footer---------------------------------------------------------------------->
	<footer>
		
		<%@include file="_default_footer.jsp" %>
		
	</footer>
<!-------------------------------------------------------------end footer----------->
  </body>
</html>
