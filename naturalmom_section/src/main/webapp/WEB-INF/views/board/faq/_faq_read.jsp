<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

	<style type = "text/css">

		#content_body { color: #85858d; padding: 100px; padding-left: 225px; }
		#content_body a { text-decoration: underline; }

		#content_body h2 { margin-bottom : 15px;  color: #004523; }
		
		table { width: 720px; padding : 0px; }
		/* #board tr:first-child td { border-top : 1px solid grey; }
		#board tr td:first-child { border-left : 1px solid grey; }
		#board tr td:last-child { border-right : 1px solid grey; } */
		#board tr:last-child td { border-bottom : 1px solid lightgray; }
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
		
		#faq_content { height: 150px; vertical-align: top;}
	</style>

<!-- content_body 부분 -->
	
	<h2 id = "reg_title">자주하는 질문</h2>
		<table cellspacing = "0" id = "board">
			<tr>
				<td id = "no"><c:out value="${param.rn}"/></td>
				<td id = "title"><c:out value="${fvo.faq_title}"/></td>
			</tr>
			<tr>
			<td colspan = "2" id = "faq_content">
			<div>
			${fvo.faq_content}
			</div>
			</td>
			</tr>
		</table>
		<table cellspacing = "0" id = "buttons">
			<tr>
				<td>
				<input type="button" value="이전글" onclick="location.href='/soap/board/faq/prev/read.nm?fr_no=${fvo.faq_no}&rn=${param.rn}';">
				<input type="button" value="다음글" onclick="location.href='/soap/board/faq/next/read.nm?fr_no=${fvo.faq_no}&rn=${param.rn}';">
	
				</td>
				<td>
					<input type = "button" value = "목록" id = "list" name = "list" onclick = "location.href='/soap/board/faq.nm'"/>
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
	</script>
		
</html>