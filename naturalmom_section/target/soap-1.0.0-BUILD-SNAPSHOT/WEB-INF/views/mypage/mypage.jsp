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
	<link rel="stylesheet" href="resources/css/mypage.css" />

	<title>자연맘</title>  
<%
	request.setCharacterEncoding("UTF-8");
	String submenu = request.getParameter("page");
	if(submenu==null){
		submenu = "interest";
	}
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
			<div id="sidebar">
				<ul>
					<li><a href="<c:url value = '/interest.nm' />">관심상품</a></li>
					<li><a href="<c:url value = '/mypage.nm?page=edit' />" onclick="to_edit_member()">회원정보 수정</a></li>
				</ul>
			</div>
			<div id="content_body">
<%
				if(submenu.equals("interest")){%>
					<%@include file="_interest.jsp" %>
<%				}else if(submenu.equals("edit")){%>
					<%@include file="_edit_member.jsp" %>
<%				}else{
					System.out.println(submenu);
				}
%>
				
			</div>
		</div>
		<!--------------------------------------------------end content--------->
	</div><!--end container-->


	<footer>
		<%@include file="../_default_footer.jsp" %>
	</footer>


  </body>
</html>

<!---------------------------------------------------------Script --------------------->
