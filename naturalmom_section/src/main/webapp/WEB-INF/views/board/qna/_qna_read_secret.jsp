<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<style type="text/css">
	h2 { color: #004523; padding-top : 20px; }
	td,th { padding : 10px; }
	tr:nth-child(2) th s{ background-color : blue; }
	
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
	tr:nth-child(5) td{ 
		border-top : solid 1px #CCCCCC; 
		padding : 10px 20px 30px 20px; 
	}
	table tr:last-child input {
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
	table tr:last-child td:last-child {
		text-align : right;
	}
	table tr:last-child input:hover{
		opacity : 0.7;
	}
	
	.pw_write {
		margin : 0 auto; 
		text-align : center;
		padding : 10px; 
		border : solid 1px lightgray; 
		width : 400px; 
		background-color : #f0f0f0;
		border : solid 1px #85858D;
		color : #555555;
	}
	.pw_write input[type="button"] {
		background : #cec5ce;
		border-radius : 5px;
		color : #635353;
		border : none;
		border : 1px solid #85858d;
		padding : 2px 10px; 
	}
	
	.pw_write input[type="button"]:hover {
		opacity : 0.7;
	}
	
</style>

<script type="text/javascript">
$(function(){
	if($("#incorrect_pw").val()!=null){
		alert($("#incorrect_pw").val());
	}
});
</script>

<c:if test="${not empty incorrect_pw}">
	<input type="hidden" id="incorrect_pw" value="${incorrect_pw}">
</c:if>

<form action="/soap/board/qna/secret.nm" method="post">
<table cellspacing="0">
<tr><td colspan = "4"><h2>Q&A</h2></td></tr>
<tr style="background: #918686; color: white;">
	<th style="width:80px;">${param.rn}</th>
	<td colspan="3">${qvo.qna_title}<span>&nbsp;<i class="fa fa-lock"></i></span></td>
</tr>

<tr>
	<td colspan="4">
	<br/>&nbsp;
	<div class="pw_write"> 
	비밀번호 확인
	<hr/>
	이 글은 비밀글입니다. 비밀번호를 입력해주세요<br/><br/>
	비밀번호&nbsp;&nbsp;&nbsp;
	<input type="password" name="q_pw" size="8">&nbsp;&nbsp;&nbsp;
	<input type="hidden" name="qr_no" value="${qvo.qna_no}"/>
	<input type="hidden" name="rn" value="${param.rn}"/>
	<input type="submit" value="확인">
	<br/>&nbsp;
	</div>
	</td>
</tr>
<tr>
	<td></td>
	<td style="width:30%">&nbsp;</td>
	<td></td>
	<td></td>
</tr>
<tr>
	<td colspan="2">
	<input type="button" value="이전글" onclick="location.href='/soap/board/qna/prev/read.nm?qr_no=${qvo.qna_no}&rn=${param.rn}';">
	<input type="button" value="다음글" onclick="location.href='/soap/board/qna/next/read.nm?qr_no=${qvo.qna_no}&rn=${param.rn}';">
	</td>
	<td colspan="2">
		<input type="button" value="목록" onclick = "location.href='/soap/board/qna.nm';">
	</td>
</tr>
</table>
</form>
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
</script>
</html>