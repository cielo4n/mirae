<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="/soap/resources/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="/soap/resources/js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="/soap/resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="/soap/resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="/soap/resources/css/mypage.css" />

	<title>자연맘</title>  
<%
	request.setCharacterEncoding("UTF-8");
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
				<c:choose>
					<c:when test="${not empty qwa}">
						<%@ include file = "_qna_add_form.jsp" %>
					</c:when>
					<c:when test="${not empty qwe}">
						<%@ include file = "_qna_edit_form.jsp" %>
					</c:when>
					<c:when test="${not empty secret}">
						<%@ include file = "_qna_read_secret.jsp" %>
					</c:when>
					<c:when test="${not empty param.qr_no}">
						<%@ include file = "_qna_read.jsp" %>
					</c:when>
					<c:otherwise>
						<%@include file="_qna_list.jsp" %>
					</c:otherwise>
				</c:choose>
		
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
