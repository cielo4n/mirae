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
	<link rel="stylesheet" href="resources/css/login.css"/>
		
	<title>자연맘</title>
  </head>
  <body>


	<header>
		<%@include file="../_default_header.jsp" %>
	</header>

	
	<div id="container">
		<%@include file="../_default_menu.jsp" %>
		<!-------------Start content--------------------------------------------------->
		<div id="content">
		
		<!--로그인 폼-->
		<form action="#" method="post">
				<div id = "login_input">
				<table>
					<tr>
						<td colspan=3>
							회원 로그인
						</td>
					</tr>
					<tr>
						<td><label for="login_id">아이디</label></td>
						<td><input type="text" size="16" maxlength="16" id="login_id" autofocus = "true" /></td>
						<td rowspan=2><input type="submit" value="로그인" id="login_submit"/></td>
					</tr>
					<tr>
						<td><label for="login_pw">패스워드</label></td>
						<td><input type="password" size="16" maxlength="16" id="login_pw"/></td>
					</tr>
					<tr>
						<td colspan=3><br><a href="membership.jsp">신규회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" onclick="pop_idpw()">아이디·패스워드찾기</a></td>
					</tr>
				</table>
				</div>
		</form>
		
		</div>
		<!--------------------------------------------------end content--------->
	</div><!--end container-->


	<footer>
		<%@include file="../_default_footer.jsp" %>
	</footer>
  </body>
  <!-- -------------------------------------------------------------------------------------------------Script -->
 <script type="text/javascript">
 
 	function pop_idpw() {
		window.open("login_popup.jsp", "ID&PW", "width=402px, height=455px, left=200px, top=30px, scrollbars=no, toolbar=no, location=no");
	}
 
 </script>
  
</html>

