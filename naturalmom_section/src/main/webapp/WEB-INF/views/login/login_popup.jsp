<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/main.css" />
	<script src="/soap/resources/js/jquery-1.11.3.min.js"></script>
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<style type = "text/css">
		* { margin: 0px; padding: 0px; 
			font-family : "나눔바른고딕", "맑은 고딕", Arial; }
		body 
		{
			width: 400px;
			padding-bottom: 15px; 
			padding-top: 0px; 
		}
		h3 
		{ 
			color: #85858d; 
			margin: 0 15px;
			margin-bottom : 5px; 
			margin-top: 20px; 
		}
		
		input
		{ 
			font: 16px "나눔바른고딕", "맑은 고딕", Arial; 
		}

		#title 
		{ 
			background-color : #635353; 
			height: 50px;
		}
		#title h2
		{
			padding: 15px 5px;
			color: white;
			font: 18px "나눔바른고딕", "맑은 고딕", Arial;
		}

		#close { text-align: center; }
		#findId, #findpw { text-align:right; padding-right : 10px; padding-top : 5px;}

		#btn_close
		{	
			margin-top : 20px;
			padding : 7px 30px;
			margin-left : 5px;
			margin-right : 5px; 
			background-color : #635353;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 10px; 
			border : 0px;
		}
		
		#btn_id, #btn_pw
		{	
			padding : 5px 10px;
			margin-left : 5px;
			margin-right : 5px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 15px;
			border-radius : 10px; 
			border : 0px;
		}
		#email1, #email2,#email3, #email4 { width: 25% }
		td:first-child { width: 20%; 
					padding: 3px 8px; 
					font-size:13px;}


		input[type = "submit"]:hover { opacity : 0.7; }
	</style>
	<title>자연맘</title>
	<script>
	</script>
  </head>

  <body>
	<div id = "title">
		<h2>아이디·비밀번호 찾기</h2>
	</div>
	
	
	<form action="pop_findId1.nm" name="findId_form" method="post">
		<div>
			<h3>아이디 찾기</h3>
			<table>
				<tr>
					<td style="text-align: right"><label for="name1">이름</label> </td>
					<td><input type="text" id="name1" name="name1"></td>
				</tr>
				<tr>
					<td style="text-align: right"><label for="email1" style="text-align: right">이메일</label></td>
					<td>
						<input type="text" id="email1" name="email1" />@<input type="text" id="email2" name="email2" />
						<select id="email_select1" onchange="email_change1()">
							<option value="">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="nate.com">nate.com</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="gmail.com">gmail.com</option>
						</select>
					</td>
				</tr>
			</table>
		</div>
		<div id="findId"><input type="button" id ="btn_id" value = "아이디 찾기" onclick="findId_proc()"/></div>
		
		<!-- hidden result -->
		<input type="hidden" id="resultId" value="${resultId}"/>
	</form>

	<!-- ------------------------------------------------------------------------------------------------------------- -->

	<br><hr>
	<form action="pop_findId2.nm" name="findPw_form" method="post">
		<h3><label for = "reg">비밀번호 찾기</label></h3>
		<table>
				<tr>
					<td style="text-align: right"><label for="id">아이디</label> </td>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<td style="text-align: right"><label for="name2">이름</label> </td>
					<td><input type="text" id="name2" name="name2"></td>
				</tr>
				<tr>
					<td style="text-align: right"><label for="email3" style="text-align: right">이메일</label></td>
					<td>
						<input type="text" id="email3" name="email3" />@<input type="text" id="email4" name="email4" />
						<select id="email_select2" onchange="email_change2()">
							<option value="">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="nate.com">nate.com</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="gmail.com">gmail.com</option>
						</select>
					</td>
				</tr>
			</table>
		<div id="findpw">
			<input type = "button" id = "btn_pw" value = "비밀번호 찾기" onclick="findPw_proc()"/>
		</div>
		
		<!-- hidden result -->
		<input type="hidden" id="resultPw" value="${resultPw}"/>
	</form>
	<div id = "close">
		<input type = "button" id = "btn_close" onclick = "window.close();" value = "닫기" />
	</div>
  </body>
 <script type="text/javascript">
 
 
 	function email_change1() {
		var selectedEmail = $("#email_select1").val();
	 	document.getElementById("email2").value= selectedEmail;
	}
 	function email_change2() {
		var selectedEmail = $("#email_select2").val();
	 	document.getElementById("email4").value= selectedEmail;
	}
 	
 	
 	function findId_proc() {
 		if($('#name1').val() != "" && $('#name1').val() !=null
 				&& $('#email1').val() !="" && $('#email1').val() !=null
 				&& $('#email2').val() !="" && $('#email2').val() !=null){
 			document.findId_form.submit();
 			
 		}else{
 			alert('공란없이 입력해주세요.');
 		}
	}
 	
 	function findPw_proc() {
 		if($('#id').val() != "" && $('#id').val() !=null
 				&& $('#name2').val() != "" && $('#name2').val() !=null
 				&& $('#email3').val() !="" && $('#email3').val() !=null
 				&& $('#email4').val() !="" && $('#email4').val() !=null){
 			document.findPw_form.submit();
 			
 		}else{
 			alert('공란없이 입력해주세요.');
 		}
	}
 	
 	$(function(){
 	   if($("#resultId").val()=="없음"){
 	      alert('아이디 정보가 존재하지 않습니다.');
 	   }else if($("#resultId").val()=="탈퇴"){
 		   alert('탈퇴한 회원입니다.');
 	   }else if($("#resultId").val()==""){
 	   }else{
 		   alert('고객님의 아이디는 "' + $("#resultId").val()+'"입니다.')
 	   }
 	});
 	
 	$(function(){
  	   if($("#resultPw").val()=="없음"){
  	      alert('아이디 정보가 존재하지 않습니다.');
  	 	}else if($("#resultPw").val()=="탈퇴"){
		   alert('탈퇴한 회원입니다.');
  	   }else if($("#resultPw").val()==""){
  		   
  	   }else{
  		   alert('고객님의 비밀번호를 "' + $("#resultPw").val()+'"해드렸습니다.')
  	   }
  	});
 	

 
 </script>
</html>
