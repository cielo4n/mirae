<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<title>자연맘</title>
  <script type = "text/javascript" src = "http://code.jquery.com/jquery-1.12.0.min.js"> </script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<style type = "text/css">
	
	#in 
	{ 
		width : 1000px; 
		margin : 0 auto; padding: 0 auto; 
		color: #85858d; 
		font-style: bold;
		font-family : "나눔바른고딕", "맑은 고딕"; 
	}
			
	#in h2 
	{ 
		margin : 5px; 
		color: #004523;
	}

	#review a { text-decoration : none; color : black; }
	#review a:hover  { opacity : 0.7; }
		
	#review { width: 100%; padding : 0px;}
	#review tr { border-top : 1px solid grey; }
	#review tr:nth-child(2) td { background-color: #CCCCCC; color: white; font-style:bold; }
	#review tr:not(:first-child) td { color: black; }
	#review tr td { border-bottom : 1px solid grey; }
	#review tr td { padding : 5px; color: black; border-bottom : 1px solid lightgrey;}
	
	#review tr:nth-child(2), #sub_title { text-align: center; }
	
	#no_review { text-align: center; height: 100px; }
	
	#write { text-align: right; }
	
	#write input
	{
		padding : 5px 20px; 
		background-color : #85858D;
		color : white;
		font-size : 16px;
		border-radius : 20px;
		border : 0px;
		margin-right : 5px;
		margin-top : 10px;
		margin-left : 10px;
	}
	#write input:hover, .review_buttons input:hover, 
	.reply_button input:hover, .reply_buttons input:hover, i:hover { opacity : 0.7; }
	
	.review td .review_body:not(:last-child) { border-bottom : 1px solid lightgrey; padding-bottom: 5px; margin-bottom: 5px; }
	.reply_content { background : #EAEAEA; margin : 0 20px; padding: 5px; border-bottom: 1px dotted white; }
	.review_content { padding: 20px 50px; }
	.review td .review_body:last-child { border-bottom: 1px solid lightgrey; padding-bottom: 10px; margin-bottom: 10px; }
	.review_content, .reply_write { display:inline-block; width : 70%; vertical-align: middle; }
	.review_buttons	{ display:inline-block; text-align:center; width : 15%; }	
	.reply_button { display: inline-block; width: 15%; }	
	.review_buttons { margin-bottom: 5px; }
	
	#line { margin-top: 10px; border-top: 1px solid lightgrey; }
	.reply_write { padding: 10px; width: 98%; }
	.reply_write { text-align:right; }
	.reply_write textarea { width: 100%; resize: none; }
	.reply_button input, .review_buttons input
	{
		padding: 3px;
		background : #cec5ce;
		border-radius : 5px;
		color : #635353;
		border : 1px solid #85858d;
		margin-right: 5px;
	}
	
	.reply_content div { display : inline-block; }
	.reply_content .reply_writer { width: 15%; text-align:center; }
	.reply_content .reply_sub { width: 65%; }
	.reply_content .reply_date { width : 10%; text-align: right; }
	.reply_content .reply_buttons { width : 5%; text-align:center; }
	
	.page { text-align : center; margin-bottom: 80px; margin-top: 50px; }
	</style>
 </head>
 <body>
<!--  Start header --------------------------------------------------------------------->
<header>

</header>
<!-----------------------------------------------------------end header ----------->	
<!---Start container----------------------------------------------------------------->
 <script>
	<% 
		String result = (String)request.getParameter("rst");
		if (result != null && result.equals("rrtrue")) {
	%>	write_result('rrtrue');
	<%  } else if (result != null && result.equals("rrfalse")) { %>
		write_result('rrfalse');
	<%  } else if (result != null && result.equals("dfalse")) { %>
		write_result('dfalse');
	<%  } else if (result != null && result.equals("rdtrue")) { %>
		write_result('rdtrue');
	<%  } else if (result != null && result.equals("rdfalse")) { %>
		write_result('rdfalse');
	<%  } else if (result != null && result.equals("login")) { %>
		write_result('login');
	<%  } %>
 
 
	$(document).ready(function(){
		
		// 초기화
		$("#review tr:not(:nth-child(2)):nth-child(even) td").css("display", "none");	

		$("#review tr:gt(1) td a").click(function(){
			if ($(this).parent().parent().next().children("td").css("display") == "none")
			{
				$("#review tr:not(:nth-child(2)):nth-child(even) td").slideUp(0);	
				$(this).parent().parent().next().children("td").slideDown(0);		
				$("#review tr:not(:nth-child(2)):nth-child(even) td").removeClass("selected");		
				$(this).parent().parent().next().children("td").addClass("selected");			
			}
			else
			{
				$("#review tr:not(:nth-child(2)):nth-child(even) td").slideUp(0);		
				$(this).parent().parent().next().children("td").removeClass("selected");
				$("#review tr:not(:nth-child(2)):nth-child(even) td").css("display", "none");
			}
		}).mouseover(function(){
			$(this).addClass("over");
		}).mouseout(function(){
			$(this).removeClass("over");
		});
	});
	
	function write_popup(product_no)
	{
		window.open("review_write_popup.nm?p_no=" + product_no, "상품후기 쓰기", "width = 800px, height = 600px, left = 200px, top = 200px, scrollbars = no, toobar = no, menubar = no, status = no, location = no, resizeable = no");
	}
	
	function modify_popup(review_no)
	{
		window.open("review_modify_popup.nm?r_no=" + review_no, "상품후기 수정", "width = 800px, height = 600px, left = 200px, top = 200px, scrollbars = no, toobar = no, menubar = no, status = no, location = no, resizeable = no");
	}
	function reg_reply()
	{
		var content = $('#rvw_re_content').val();
		if(content == '')
		{
			alert('댓글 내용을 입력해주세요.');
			$('#rvw_re_content').focus();		
		}
		else
		{
			document.reg_reply_form.submit();
		}
	}
	
	function write_result(result)
	{
		if(result == 'rrtrue')
		{
			alert('댓글이 등록되었습니다.');

		}
		else if (result == 'rrfalse')
		{
			alert('댓글 등록에 실패하였습니다.');
		}
		if(result == 'dfalse')
		{
			alert('게시물 삭제에 실패하였습니다.');

		}
		else if (result == 'rdtrue')
		{
			alert('댓글이 삭제되었습니다.');
		}
		else if (result == 'rdfalse')
		{
			alert('댓글 삭제에 실패하였습니다.');
		}
		else if(result == 'login')
		{
			alert('로그인 후 이용해주세요.');
			location.href="/soap/login.nm";
		}
	}
	function del_review(review_no, product_no)
	{
		if(confirm("글을 삭제하시겠습니까?")) 
		{
	       location.href="review_del_proc.nm?c=r&no=" + review_no + "&p_no=" + product_no; 
	    } 
	}
	function del_reply(re_no, product_no)
	{
		if(confirm("댓글을 삭제하시겠습니까?")) 
		{
	       location.href="review_del_proc.nm?c=rr&no=" + re_no + "&p_no=" + product_no; 
	    } 
	}
</script>
<!-- a name 태그를 생성하면 주소창 뒤에 #네임명으로 스크롤을 움직일 수 있음 -->
<a name = "review" />
 <div id ="in">
 
 <h2>구매 후기</h2>
  	<table id="review" cellspacing="0">
		<tr id = "write">
			<td colspan="4">
				<input type = "button" value = "글쓰기" onclick = "write_popup(${pvo.product_no});" />
			</td>
		</tr>
		<tr id = "title">
			<td style="width:600px;">제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>만족도</td>
		</tr>
		<c:if test = "${rvw_list != null}" >
		<c:forEach var = "review" items = "${rvw_list}" varStatus="stat">
		<tr id = "sub_title">
			<td>
				<a href="javascript:void();">
					${review.rvw_title}
					<c:if test="${fn:length(re_list[stat.index]) > 0}">
					&nbsp;&nbsp;[${fn:length(re_list[stat.index])}]
					</c:if>
				</a>
			</td>
			<td>${review.mem_id}</td>
			<td><fmt:formatDate value="${review.rvw_write_day}" type = "date" /></td>
			<td>
					<c:forEach var="i" begin="0" end="5" step="1">
						<c:if test="${i < review.rvw_satisfaction}">
							<i class="fa fa-star" aria-hidden="true"></i>
						</c:if>
						<c:if test="${i > review.rvw_satisfaction}">
							<i class="fa fa-star-o" aria-hidden="true"></i>
						</c:if>
					</c:forEach>
			</td>
		</tr>
		<tr id = "sub_content">
			<td colspan = "4">
				<div class = "review_body">
					<div class = "review_content">
					 	${review.rvw_content}
					 </div>
					 <div class = "review_buttons">
					 	<c:if test="${id eq review.mem_id || isAdmin}">
					 		<c:if test="${id eq review.mem_id}">
					 			<input type = "button" value = "수정" onclick = "modify_popup(${review.review_no});"/>
					 		</c:if>
						<input type = "button" value = "삭제" onclick = "del_review(${review.review_no}, ${pvo.product_no});"/>
						</c:if>
					</div>		 			 
				</div>
				<div class = "reply_body">
					<c:if test = "${re_list[stat.index] != null}" >
					<c:forEach var = "re" items = "${re_list[stat.index]}">
					<div class = "reply_content">
						<div class = "reply_writer">
							${re.mem_id}
						</div>
						<div class = "reply_sub">
							${re.rvw_re_content}
						</div>
						<div class = "reply_date">
							<fmt:formatDate value="${re.rvw_re_write_day}" type = "date" />
						</div>
						<div class = "reply_buttons">
							<c:if test="${id eq re.mem_id || isAdmin}">
							<i class="fa fa-times-circle" onclick="del_reply(${re.review_re_no}, ${pvo.product_no});"></i>
							</c:if>
						</div>
					</div>
					</c:forEach>
					</c:if>
					<div id = "line">
						<div class = "reply_write">
						<form action = "review_reg_re_proc.nm" method = "post" name = "reg_reply_form">
							<textarea rows="4" cols="100" name = "rvw_re_content" id = "rvw_re_content"></textarea>
							<input type = "hidden" name = "rvw_no" id = "rvw_no" value = "${review.review_no}" />
							<input type = "hidden" name = "product_no" id = "product_no" value = "${pvo.product_no}" />
							<span class = "reply_button">
							<input type = "submit" value = "댓글등록" />
							</span>
						</form>
						</div>
					</div>
				</div>
			</td>
		</tr>	
		</c:forEach>
		</c:if>
		<c:if test = "${(rvw_list == null) || (rvw_list != null && fn:length(rvw_list) == 0)}" >
			<tr>
				<td colspan = "4" id = "no_review">등록된 리뷰가 없습니다. 첫 리뷰의 주인공이 되어주세요.</td>
			</tr>
		</c:if>
	</table>
		<div class="page">
			<c:if test="${rp eq 1 && all_pages > 0}">
				&lt;
			</c:if>
			<c:if test="${rp gt 1}">
				<a href="detail.nm?pdno=${pvo.product_no}&page=${rp - 1}#review">&lt;</a>
			</c:if>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<c:forEach var = "i" begin="1" end="${all_pages}" step = "1">
				<c:if test="${rp == i}">
					<span>${i}</span>
				</c:if>
				<c:if test="${rp != i}">
					<a href="detail.nm?pdno=${pvo.product_no}&page=${i}#review">${i}</a>
				</c:if>
			</c:forEach>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${rp eq all_pages && all_pages > 0}">
				&gt;
			</c:if>
			<c:if test="${rp lt all_pages}">
				<a href="detail.nm?pdno=${pvo.product_no}&page=${rp + 1}#review">&gt;</a>
			</c:if>
		</div>
	</div>
 </body>
</html>
