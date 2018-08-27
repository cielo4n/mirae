<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<style type = "text/css">

	#container { width : 764px; margin : 50px auto; color: #85858d; }
	#container a { text-decoration: underline; }

	#container h2 { margin-bottom : 15px; color: #004523;}
	
	table { width: 100%; padding : 0px; }
	#board tr:last-child td { border-bottom : 1px solid lightgrey;}
	#board tr td { padding : 10px; }
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
		width: 50px;
		text-align: center;
	}

	#buttons { width: 100%; margin-top: 20px; }
	#buttons input
	{
		padding : 7px 20px;
		margin-left : 3px;
		margin-right : 3px; 
		background-color : #85858D;
		color : white;
		font-family : "나눔바른고딕", "맑은 고딕";
		font-size : 16px;
		border-radius : 20px; 
		border : 0px;
	}
	#buttons input:hover { opacity : 0.7; }

	#buttons tr td:last-child { text-align:right; }
</style>

<!-- container 부분 -->
<h2 id = "reg_title">자주하는 질문</h2>
<table cellspacing = "0" id = "board">
	<tr>
		<td id = "no"><c:out value="${param.rn}"/></td>
		<td id = "title">${fvo.faq_title}</td>
	</tr>
	<tr><td colspan = "2" id = "content">${fvo.faq_content}</td></tr>
</table>
<table cellspacing = "0" id = "buttons">
	<tr>
		<td>
			<input type = "button" value = "이전글" id = "prev" name = "prev" onclick="location.href='/soap/admin/board/faq/prev/read.nm?fr_no=${fvo.faq_no}&rn=${param.rn}';">
			
			<input type = "button" value = "다음글" id = "next" name = "next" onclick="location.href='/soap/admin/board/faq/next/read.nm?fr_no=${fvo.faq_no}&rn=${param.rn}';">
		</td>
		<td>
			<input type = "button" value = "편집" id = "mod" name = "mod" onclick = "location.href='/soap/admin/board/faq/edit_form.nm?fe_no=${fvo.faq_no}';">
			<input type = "button" value = "삭제" id = "del" name = "del" onclick = "delFaq('${fvo.faq_no}');">
			<input type = "button" value = "목록" id = "list" name = "list" onclick = "location.href='/soap/admin/board/faq.nm';">
		</td>
	</tr>
</table>
<input type="hidden" id="p_not" value="${param.prev_err}"/>
<input type="hidden" id="n_not" value="${param.next_err}"/>
			
<script type="text/javascript">
	
	$(function(){
		console.log("p_not : "+$("#p_not").val());
		console.log("n_not : "+$("#n_not").val());
		
	    if($("#p_not").val()=="t"){
	    	alert("이전글이 없습니다");
	    }
	    if($("#n_not").val()=="t"){
	    	alert("다음글이 없습니다");
	    }
	});
	function delFaq(fd_no){
		if(confirm("글을 삭제하시겠습니까?")){
			console.log("fd_no : "+ fd_no);
			location.href='/soap/admin/board/faq/del_proc.nm?fd_no='+fd_no;
		}
	}	
</script>
</html>