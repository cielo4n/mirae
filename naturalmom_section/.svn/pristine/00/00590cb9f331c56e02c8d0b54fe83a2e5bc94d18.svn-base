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
	boolean write = request.getParameter("w")!=null? true : false;
	
	if(submenu==null){ submenu = "notice"; }
	
	// 게시글 내용 보기인지 글쓰기인지 확인하는 부분
	String w = request.getParameter("w");
	if (w == null || w.isEmpty()) w = "false"; //여기도 boolean형으로 처리 안해놨음
	String r = request.getParameter("r");	// 일단 int형 처리 안함
	if (r == null) r = "";
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
					<li><a href="<c:url value = '/customer_center.nm?page=notice'/>">공지사항</a></li>
					<li><a href="<c:url value = '/customer_center.nm?page=event'/>">이벤트</a></li>
					<li><a href="<c:url value = '/customer_center.nm?page=qna'/>">Q&A</a></li>
					<li><a href="<c:url value = '/customer_center.nm?page=faq'/>">자주하는 질문</a></li>
				</ul>
			</div>
			<div id="content_body">
<%
				if(submenu.equals("notice")){%>
<%				if(r.equals("")&& w.equals("false")){%>
					<%@include file="notice/_notice_list.jsp" %>
<% 					}else if(w.equals("true")){%>
					<%@include file="notice/_notice_write.jsp" %>
<%					}else if(r.equals("2")){%>
					<%@include file="notice/_notice_read.jsp" %>					
<%					} %>	
<%				}else if(submenu.equals("event")){
					if(r.equals("")&& w.equals("false")){%>
					<%@include file="event/_event_list.jsp" %>
<% 					}else if(w.equals("true")){%>
					<%@include file="event/_event_write.jsp" %>
<%					}else if(r.equals("1")){%>
					<%@include file="event/_event_read.jsp" %>					
<%					} %>					
<%				}else if(submenu.equals("qna")){%>
					<% if(r.equals("") && w.equals("false")){ %>
					<%@include file="qna/_qna_list.jsp" %>	
					<% } else if(r.equals("3")){ %>
					<%@include file="qna/_qna_read.jsp" %>		
					<% } else if(r.equals("2")){ %>
					<%@include file="qna/_qna_read_secret.jsp" %>
					<% } else if(w.equals("true")){ %>
					<%@include file="qna/_qna_write.jsp" %>
					<% } %>
<%				}else if(submenu.equals("faq")){%>
					<% if(submenu.equals("faq") && r.equals("1")) { %>
					<%@ include file = "faq/_faq_read.jsp" %>
					<% } else { %>
					<%@include file="faq/_faq_list.jsp" %>
					<% } %>			
<%				}else{
					System.out.println("board submenu error");
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
