<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="resources/admin/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="/soap/resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="/soap/resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="/soap/resources/admin/css/admin_common.css"/>
	
	<title>자연맘</title>
<% 
	request.setCharacterEncoding("UTF-8");
	String submenu = (String)request.getParameter("page");
	if(submenu==null){
		submenu= "notice";
	}
	String r = (String)request.getParameter("r");
	if (r == null) r = "";
	String w = (String)request.getParameter("w");
	if (w == null || w.isEmpty()) w = "false";
%>
	
   </head>

  <body>

	<header>
		<%@include file="../_default_header.jsp" %>
	</header>

<!---Start container----------------------------------------------------------------->
	
	<div id="container">
<%
			if(submenu.equals("notice")){
				if(r.equals("") && w.equals("false")){  %>
				<%@include file="notice/_a_board_notice_list.jsp" %>	
<%			}else if(w.equals("true")){ %>
				<%@include file="notice/_a_board_notice_write.jsp" %>
<%			}else if(r.equals("2")){ %>
				<%@include file="notice/_a_board_notice_read.jsp" %>
<%			}%>
<%		}else if(submenu.equals("event")){
				if(r.equals("") && w.equals("false")){  %>
				<%@include file="event/_a_board_event_list.jsp" %>		
<%			}else if(w.equals("true")){ %>
				<%@include file="event/_a_board_event_write.jsp" %>
<%			}else if(r.equals("1")){ %>
				<%@include file="event/_a_board_event_read.jsp" %>
<%			}%>					
<%		}else if(submenu.equals("qna")){%>
			<% if(r.equals("") && w.equals("false")){ %>
			<%@include file="qna/_a_board_qna_list.jsp" %>	
			<% } else if(r.equals("3")){ %>
			<%@include file="qna/_a_board_qna_read.jsp" %>		
			<% } else if(r.equals("2")){ %>
			<%@include file="qna/_a_board_qna_read_secret.jsp" %>
			<% } else if(w.equals("true")){ %>
<!-- 			%@include file="qna/_a_board_qna_write.jsp" % -->
			<% } %>	
			

<%		}else if(submenu.equals("review")){
			if(r.equals("") && w.equals("false")){ %>
			<%@include file="review/_a_board_review.jsp" %>	
			<% }else if(r.equals("1")){%>
			<%@include file="review/_a_board_review_read.jsp" %>		
			<% } else if(w.equals("true")){ %>
			<%@include file="review/_a_board_review_write.jsp" %>
			<% } %>		
		
				
<%		}else if(submenu.equals("faq")){%>
			<%if (r.equals("1")) {%>
				<%@include file = "faq/_a_board_faq_read.jsp" %>
			<%} else if (w.equals("true")) { %>
<%-- 				<%@include file = "faq/_a_board_faq_write.jsp" %> --%>
			<%} else { %>
				<%@include file="faq/_a_board_faq_list.jsp" %>
			<%} %>			
<%		}else{
			System.out.println("board page submenu error");
		}
%>
	</div>
<!--------------------------------------------------------end container------------->
  </body>

</html>
