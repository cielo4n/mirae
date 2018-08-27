<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>

<style type="text/css">
	h2 { color: #004523; padding-top : 20px; padding-bottom : 30px;}
	td, th { padding : 10px; }
	
	table { width : 720px; 
		margin : 0 auto; 
	}
	tr:nth-child(2) th{ 
		text-align : center; 
		color : white; 
		font-weight : normal; 
		border-right : solid 1px #cccccc;
	}	
	tr:nth-child(2) th, tr:nth-child(2) td{ 
		border-top : solid 1px #cccccc; 
		border-bottom : solid 1px #cccccc;	
	}
	tr:nth-child(3) td div{ 
		text-align : right; color : gray; font-size : 0.8em;
	}
	tr:nth-child(4) td{ 
		border-bottom : solid 1px #CCCCCC; 
		padding : 10px 20px 30px 20px; 
	}
	.dat td{ background-color : #F0F0F0; }
	.dat td:first-child{ text-align : center; border-bottom : dotted 1px #cccccc; }
	.dat td{ font-size : 0.9em; border-bottom : dotted 1px #cccccc; }
	.dat_write td:first-child{ text-align : center;}
	.dat_write td{
		font-size : 0.9em;
		background-color : #F0F0F0;
		padding : 10px;
		
	}
	table tr:last-child input, tr:nth-child(1) td input{
		padding : 5px 20px;
		margin-right : 5px;
		margin-top : 10px;
		margin-left : 5px; 
		background-color : #85858D;
		color : white;
		font-size : 16px;
		border-radius : 20px;
		border : 0px;
	}
	tr:nth-child(1) td input {
		margin-top : 30px;
	}
	table tr:last-child td:last-child , tr:nth-child(1) td{
		text-align : right;
	}
	table tr:last-child input:hover, tr:nth-child(1) td input:hover{
		opacity : 0.7;
	}
	.dat span {
		display : inline-block; 
		width:20px; 
		text-align : right;
	}
	.dat span:hover {
		opacity : 0.7;
	}
	
	.dat_write input[type="submit"] {
		background : #cec5ce;
		border-radius : 5px;
		color : #635353;
		border : none;
		border : 1px solid #85858d;
		padding : 5px; 
	}
	
</style>

<table cellspacing="0">
<tr>
	<td colspan = "1"><h2>Q&A</h2></td>
	<c:if test="${not empty sessionScope.loggedin}">
	<td colspan="3"><input type="button" value="답변등록" onclick="location.href='/soap/board/qna/add_form.nm?ref=${qvo.qna_ref}&pos=${qvo.qna_pos}'"/></td>
	</c:if>
</tr>

<tr style="background: #918686; color: white;">
	<th style="width:80px;"><c:out value="${param.rn}"/></th>
	<td colspan="3">${qvo.qna_title}</td>
</tr>
<tr>
	<td colspan="4">
	<div>
	<c:choose>
		<c:when test='${fn:containsIgnoreCase(qvo.mem_id, "admin")}'>
			관리자
		</c:when>
		<c:otherwise>
			${qvo.mem_id}
		</c:otherwise>
	</c:choose> | <fmt:formatDate value="${qvo.qna_write_day}" pattern="yyyy/MM/dd"/> | 조회수 ${qvo.qna_hits}
	</div> 
	</td>
</tr>
<tr>
	<td colspan = "4">${qvo.qna_content}</td>
</tr>

<c:if test="${qnare_list !=null}">
	<c:forEach items="${qnare_list}" var="qrl" >
		<tr class="dat">
		
			<td>
			<c:choose>
				<c:when test='${fn:containsIgnoreCase(qrl.mem_id, "admin")}'>
					관리자
				</c:when>
				<c:otherwise>
					${qrl.mem_id}
				</c:otherwise>
			</c:choose>
			</td>
			
			<td colspan="2">${qrl.qna_re_content}</td>
			
			<td style="width:120px;">
			<fmt:formatDate value="${qrl.qna_re_write_day}" pattern="yyyy/MM/dd"/>
			<c:if test="${qrl.mem_id eq loggedin}">
				<span onclick="location.href='/soap/board/qna/read/del_reply_proc.nm?reno=${qrl.qna_re_no}&qr_no=${qvo.qna_no}&rn=${param.rn}'">
				<i class="fa fa-times-circle"></i>
				</span>
			</c:if>
			</td>
			
		</tr>
	</c:forEach>
</c:if>

<form action="/soap/board/qna/read/add_reply_proc.nm" method="post">
<c:if test="${sessionScope.loggedin !=null}">
	<tr class="dat_write">
		<td>
		<c:choose>
			<c:when test='${fn:containsIgnoreCase(sessionScope.loggedin, "admin")}'>
				관리자
			</c:when>
			<c:otherwise>
				${sessionScope.loggedin}
			</c:otherwise>
			</c:choose>
		</td>
		
		<td colspan="2">
			<textarea style="width:100%; resize : none;" cols="30" name="dat_text"></textarea>
		</td>
		<input type="hidden" name="qr_no" value="${qvo.qna_no}"/>
		<input type="hidden" name="q_pw" value="${qvo.qna_pw}"/>
		<input type="hidden" name="rn" value="${param.rn}"/>
		
		<td style="width:120px;">
			<input type="submit" style="padding : 2px 10px;" value="댓글등록">
		</td>
		
	</tr>
</c:if>
</form>

	<tr>
		<td></td>
		
		<td colspan="2">
		</td>
		
		<td style="width:120px;">
		</td>
	</tr>

<tr>
	<td colspan="2">
	<input type="button" value="이전글" onclick="location.href='/soap/board/qna/prev/read.nm?qr_no=${qvo.qna_no}&rn=${param.rn}';">
	<input type="button" value="다음글" onclick="location.href='/soap/board/qna/next/read.nm?qr_no=${qvo.qna_no}&rn=${param.rn}';">
	</td>

	<td colspan="2">
		<c:if test="${qvo.mem_id == sessionScope.loggedin}">
			<input type="button" value="편집" onclick = "location.href='/soap/board/qna/edit_form.nm?qe_no=${qvo.qna_no}';"/>
			<input type="button" value="삭제" onclick = "delQna('${qvo.qna_no}', '${qvo.qna_ref}', '${qvo.qna_pos}');"/>
		</c:if>
		<input type="button" value="목록" onclick = "location.href='/soap/board/qna.nm';"/>
	</td>
</tr>
</table>
	<input type="hidden" id="p_not" value="${param.prev_err}"/>
	<input type="hidden" id="n_not" value="${param.next_err}"/>
</body>

<script type="text/javascript">
$(function(){
	console.log("p_not : "+$("#p_not").val());
	console.log("n_not : "+$("#n_not").val());
	
    if($("#incorrect_pw").val()!=null){
      alert($("#incorrect_pw").val());
    }
   
    if($("#p_not").val()=="t"){
    	alert("이전글이 없습니다");
    }
    if($("#n_not").val()=="t"){
    	alert("다음글이 없습니다");
    }
});
function delQna(qd_no, ref, pos){
	if(confirm("글을 삭제하시겠습니까?")){
		console.log("qd_no : "+ qd_no);
		console.log("ref : "+ ref);
		console.log("pos : " +pos);
		
		location.href='/soap/board/qna/delete_proc.nm?qd_no='+qd_no+'&ref='+ref+'&pos='+pos;
	}
}
</script>

</html>