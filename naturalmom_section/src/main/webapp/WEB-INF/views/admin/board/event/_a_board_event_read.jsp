<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script src="/soap/resources/js/jquery-1.11.3.min.js"></script>
<style type = "text/css">
		#container { width : 764px; margin : 50px auto;}
		#inside { color: #85858d; font-size: 14px; }
		#inside a { text-decoration: underline; }

		h2 { margin-bottom : 15px; font-size: 24px; color: #004523;}
		
		table { width: 720px; padding : 0px; }
		#board tr:first-child td { border-top : 1px solid grey; }
		#board tr:last-child td { border-bottom : 1px solid grey; }
		#board tr td:first-child { border-left : 1px solid grey;}
		#board tr td:last-child { border-right : 1px solid grey; }
		#board tr td { padding : 10px;}
		#board tr:first-child td:first-child { border-right: 1px solid lightgrey; }
		#board tr:not(:last-child) td
		{
			border-bottom : 1px solid lightgrey;
			margin : 0px;
		}

		#board tr:first-child td
		{ 
			background-color: #918686; 
			color: white;
		}
		#board tr:first-child td:first-child
		{ 
			text-align: center;
		}

		#buttons { width: 720px; margin-top: 20px; }
		#buttons input
		{
			padding : 7px 20px;
			margin-left : 3px;
			margin-right : 3px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 10px; 
			border : 0px;
		}
		#buttons input:hover { opacity : 0.7; }

		#buttons tr td:last-child { text-align:right; }
		
		#event_content { height: 100px; vertical-align: top; color: black; }
		#re_submit { 
			padding: 15px 10px; 
			background-color: #85858d; 
			color : white;
			border-radius : 10px; 
		}
		.re_title{ width: 80px;}
		
	</style>
<html>
	<div id="inside">
		<h2 id = "reg_title">이벤트</h2>
		<form name="reply_form" action="event_reply.nm" method="post">
			<table cellspacing = "0" id = "board">
			
				<tr>
					<td id = "no" width="15%">${con.evt_rnum}</td>
					<td id = "title" width="55%" colspan="2" >${con.evt_title}</td>
					<td id = "id" width="13%">${con.mem_id}</td>
					<td id = "write_day" width="20%"><fmt:formatDate value="${con.evt_write_day}" pattern="yyyy-MM-dd" /></td>
					<td id = "hits" width="5%">${con.evt_hits}</td>
				</tr>
				<tr><td colspan="6" id="event_content">${con.evt_content}</td></tr>
				
				
			<c:forEach var="re" items="${re}">
				<tr>
					<td id = "re_id" class="re_title">${re.mem_id }</td>
					<td id = "re_con" colspan="3" width="55%">${re.evt_re_content}</td>
					<td id = "re_write_day" colspan="2" style="text-align: right">${re.evt_re_write_day }
						<span onclick="location.href='event_read.nm?r=${con.event_no}&rn=${con.evt_rnum}&d=${re.event_re_no}'">
							<i class="fa fa-times-circle"></i></span>
					</td>
				</tr>
			</c:forEach>
			
				<tr>
					<td class="re_title">댓글입력</td>
					<td colspan="4">
						<textarea style="width:100%; resize : none;" cols="30" rows="3" name="re_content" id="re_content"></textarea>
					</td>
					<td>
						<input type = "button" value = "등록" id = "re_submit" name = "re_submit" onclick="checkNull()" >
						
						<!-- hidden values -->
						<input type="hidden" name="r" value="${con.event_no}" />
					</td>
				</tr>
			</table>
		</form>
		<form action="event_edit.nm?w=true" method="post">
			<table cellspacing = "0" id = "buttons">
				<tr>
					<td>
						<c:if test="${con.evt_rnum gt 1 }">
							<input type = "button" value = "이전글" id = "prev" name = "prev" onclick="location.href='event_read.nm?next=y&r=${con.evt_rnum -1}'">
						</c:if>
						<c:if test="${con.evt_rnum eq 1 }">
							<input type = "button" value = "이전글" id = "prev" name = "prev" onclick="lastRead()">
						</c:if>
						
						<c:if test="${con.evt_rnum lt total_page }">
							<input type = "button" value = "다음글" id = "next" name = "next" onclick="location.href='event_read.nm?next=y&r=${con.evt_rnum +1}'">
						</c:if>
						<c:if test="${con.evt_rnum eq total_page }">
							<input type = "button" value = "다음글" id = "next" name = "next"onclick="lastRead()">
						</c:if>
					</td>
					<td>
						<input type = "submit" value = "수정" id = "mod" name = "mod">
						<input type = "button" value = "삭제" id = "del" name = "del" onclick="location.href='event_del.nm?d=${con.event_no}';">
						<input type = "button" value = "목록" id = "list" name = "list"  onclick="location.href='event.nm';">
						
						
						<!-- hidden values -->
						<input type="hidden" id="title" name="title" value="${con.evt_title}"/>
						<input type="hidden" id="content" name="content" value='${con.evt_content}'/>
						<input type="hidden" id="no" name="no" value="${con.event_no}"/>
						
						
					</td>
				</tr>
			</table>
		</form>
	</div>
	
<script type="text/javascript">

	function checkNull() {
		
		var content = $('#re_content').val();
		
		if(content==null || content== ""){
			alert("댓글을 입력해주세요");
		}else{
			document.reply_form.submit();
		}
	}
	
	function lastRead() {
		alert("마지막 게시글입니다");
	}

</script>
