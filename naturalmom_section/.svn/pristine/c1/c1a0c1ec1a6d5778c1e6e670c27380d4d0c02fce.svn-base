<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="resources/admin/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="../../resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="../../resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="../../resources/admin/css/admin_common.css"/>
	
	<title>자연맘</title>
<% 
	request.setCharacterEncoding("UTF-8");
	String submenu = (String)request.getParameter("page");
	if(submenu==null){
		submenu= "notice";
	}
	// 게시글 내용 보기인지 글쓰기인지 확인하는 부분
	String w = request.getParameter("w");
	if (w == null || w.isEmpty()) w = "false"; //여기도 boolean형으로 처리 안해놨음
	String stR = request.getParameter("r");
	int r = (stR != null && !stR.isEmpty() && !stR.equals("")) 
			? Integer.parseInt(stR) : 0;	//
%>
	
   </head>

  <body>

	<header>
		<%@include file="../../_default_header.jsp" %>
	</header>

<!---Start container----------------------------------------------------------------->
	
	<div id="container">

<%				if(r == 0 && w.equals("false")){  %>
				<%@include file="_a_board_notice_list.jsp" %>	
<%			}else if(w.equals("true")){ %>
				<%@include file="_a_board_notice_write.jsp" %>
<%			}else if(r > 0){ %>
				<%@include file="_a_board_notice_read.jsp" %>
<%			}%>

	</div>
<!--------------------------------------------------------end container------------->
  </body>

</html>
