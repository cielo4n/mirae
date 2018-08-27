<!-- 사용자 - 게시판 - 상품후기 - 상세보기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<style type="text/css">

	#container { width : 800px; margin : 50px auto; }
	#container h2 { color: #004523; margin-bottom : 15px; }
	
	table { width : 100%; margin : 0 auto; }
	table td { padding : 10px; }
	
	table tr:nth-child(1) td
	{ 
		text-align : center; 
		background: #918686;
		color : white; 
		border-right : solid 1px #cccccc;
		border-top : solid 1px #cccccc; 
		border-bottom : solid 1px #cccccc;
	}
	table tr:nth-child(2) td div
	{ 
		text-align : right; 
		color : gray; 
		font-size : 0.8em;
	}
	table tr:nth-child(3) td
	{ 
		border-bottom : solid 1px #CCCCCC; 
		padding : 10px 20px 30px 20px; 
	}
	table tr:last-child td:last-child { text-align : right; }
	
	table tr:last-child input
	{
		padding : 5px 30px;
		margin-right : 5px;
		margin-top : 10px;
		margin-left : 10px; 
		background-color : #85858D;
		color : white;
		font-size : 16px;
		border-radius : 20px;
		border : 0px;
	}
	table tr:last-child input:hover { opacity : 0.7; }
	
	.dat td { background-color : #F0F0F0; }
	.dat td:first-child { text-align : center; border-bottom : dotted 1px #cccccc; }
	.dat td:last-child { width : 120px; }
	.dat td { font-size : 0.9em; border-bottom : dotted 1px #cccccc; }

	.dat_write td:first-child { text-align : center; }
	.dat_write td
	{
		font-size : 0.9em;
		background-color : #F0F0F0;
		padding : 10px;	
	}
	.dat_write td textarea { font-family : "나눔바른고딕", "맑은 고딕"; }
	
	.dat span 
	{
		display : inline-block; 
		width: 20px; 
		text-align : right;
	}
	.dat span:hover { opacity : 0.7; }
	
	.dat_write input[type="button"] 
	{
		background : #cec5ce;
		border-radius : 5px;
		color : #635353;
		border : none;
		border : 1px solid #85858d;
		padding : 5px; 
	}
	.dat_write input[type="button"]:hover {	opacity : 0.7; }
	
</style>
<script type="text/javascript">
	<% 
		String result = (String)request.getParameter("rst");
		if (result != null && result.equals("rrfalse")) {
	%>		write_result('rrfalse');
	<%  } else if (result != null && result.equals("dfalse")) { %>
		write_result('rrfalse');
	<%  } else if (result != null && result.equals("rdfalse")) { %>
		write_result('rrfalse');
	<%  } %>
	
	
	function write_result(rst)
	{
		if(rst == 'rrfalse')
		{
			alert('댓글 등록에 실패했습니다.');
		}
		else if(rst == 'dfalse')
		{
			alert('게시글 삭제에 실패했습니다.');
		}
		else if(rst == 'rdfalse')
		{
			alert('댓글 삭제에 실패했습니다.');
		}
	}
	
	function del_review(review_no)
	{
		if(confirm("글을 삭제하시겠습니까?")) 
		{
	       location.href="review_del_proc.nm?c=r&no=" + review_no; 
	    } 
	}
	function del_reply(re_no)
	{
		if(confirm("댓글을 삭제하시겠습니까?")) 
		{
	       location.href="review_del_proc.nm?c=rr&no=" + re_no; 
	    } 
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
</script>
<h2>상품 후기</h2>
<form action = "review_reg_re_proc.nm" method="post" name = "reg_reply_form">
<table cellspacing = "0">
<!-- 제목 부분 -->
	<tr>
		<td style="width:100px;">${review.review_no}</td>
		<td style="width:150px;">${review.product_name}</td>
		<td>${review.rvw_title}</td>
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
<!-- 글쓴이 정보 -->
	<tr>
		<td colspan="4">
			<div>${review.mem_id} | <fmt:formatDate value="${review.rvw_write_day}" type = "date" /></div> 
		</td>
	</tr>
<!-- 내용 -->
	<tr>
		<td colspan = "4">
			${review.rvw_content}
		</td>
	</tr>
<!-- 댓글 부분 -->
	<c:forEach var = "reply" items = "${reply}">
	<tr class = "dat">
		<td>${reply.mem_id}</td>
		<td colspan="2">${reply.rvw_re_content}</td>
		<td>
			<fmt:formatDate value="${reply.rvw_re_write_day}" type = "date" />
			<span onclick="del_reply(${reply.review_re_no})"><i class="fa fa-times-circle"></i></span>
		</td>
	</tr>
	</c:forEach>
<!-- 댓글 쓰기 -->
	<tr class = "dat_write">

		<td><c:out value="${id}" /></td>
		<td colspan="2">
			<textarea style="width:100%; resize : none;" cols="30" name = "rvw_re_content" id = "rvw_re_content"></textarea>
		</td>
		<td>
			<input type="hidden" value="${review.review_no}" name="rvw_no"/>
			<input type="button" style="padding : 2px 10px; " value="댓글등록" onclick="reg_reply();">
		</td>
		
	</tr>
	
	<tr>
		<td colspan="2">
		<!-- 숫자 받아서 유효하지 않을 경우 다음, 이전 숫자로 넘어가도록 -->
			<c:if test="${review.rvw_rnum < count}">
				<input type="button" value="이전글" onclick="location.href='review_read_m.nm?d=p&r=${review.review_no}'">
			</c:if>
			<c:if test = "${review.rvw_rnum > 1}" >
				<input type="button" value="다음글" onclick="location.href='review_read_m.nm?d=n&r=${review.review_no}'">
			</c:if>
		</td>
		<td colspan="2">
			<input type="button" value="삭제" onclick = "del_review(${review.review_no});">
			<input type="button" value="목록" onclick = "location.href='review.nm';">
		</td>
	</tr>
</table>
</form>
