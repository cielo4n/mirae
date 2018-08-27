<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<script type="text/javascript" src="/soap/resources/js/nicEdit.js"></script>
	<script type="text/javascript">
		bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
	</script>

	<title>자연맘</title>  
<%
	request.setCharacterEncoding("UTF-8");
	/* String submenu = request.getParameter("page");
	boolean write = request.getParameter("w")!=null? true : false;
	
	
	// 게시글 내용 보기인지 글쓰기인지 확인하는 부분
	String w = request.getParameter("w");
	if (w == null || w.isEmpty()) w = "false"; //여기도 boolean형으로 처리 안해놨음
	String r = request.getParameter("r");	// 일단 int형 처리 안함
	if (r == null) r = ""; */
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
					<c:when test="${not empty param.fr_no}">
						<%@ include file = "_faq_read.jsp" %>
					</c:when>
					<c:otherwise>
						<%@include file="_faq_list.jsp" %>
					</c:otherwise>
				</c:choose>
		
<%-- 					<% if(r.equals("1")) { %>
					<%@ include file = "_faq_read.jsp" %>
					<% } else { %>
					<%@include file="_faq_list.jsp" %>
					<% } %>			 --%>
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
