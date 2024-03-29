<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="resources/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="../resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="../resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="../resources/css/mypage.css" />

	<title>자연맘</title>  
<%
	request.setCharacterEncoding("UTF-8");
	String submenu = request.getParameter("page");

	int r = request.getParameter("r")!=null? Integer.parseInt(request.getParameter("r")) : 0;
	
%>
  </head>

  <body>


	<header>
		<%@include file="../../_default_header.jsp" %>
	</header>

	
	<div id="container">
		<%@include file="../../_default_menu.jsp" %>
		<!-------------Start content--------------------------------------------------->
		<div id="content">
			<div id="sidebar">
				<ul>
					<li><a href="<c:url value = '/board/notice.nm'/>">공지사항</a></li>
					<li><a href="<c:url value = '/board/event.nm'/>">이벤트</a></li>
					<li><a href="<c:url value = '/board/qna.nm'/>">Q&A</a></li>
					<li><a href="<c:url value = '/board/faq.nm'/>">자주하는 질문</a></li>
				</ul>
			</div>
			<div id="content_body">

<%				if(r == 0){%>
					<%@include file="_notice_list.jsp" %>
<% 					}else if(r > 0){%>
					<%@include file="_notice_read.jsp" %>					
<%					} %>	
			
			</div>	
		</div>
		<!--------------------------------------------------end content--------->
	</div><!--end container-->


	<footer>
		<%@include file="../../_default_footer.jsp" %>
	</footer>


  </body>
</html>


<!---------------------------------------------------------Script --------------------->
