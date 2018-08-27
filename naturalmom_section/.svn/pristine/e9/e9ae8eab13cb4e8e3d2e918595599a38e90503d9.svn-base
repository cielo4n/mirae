<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/main.css" />

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


		#btn_close, #btn_submit
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
		
		#btn_id
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
		td:first-child { width: 20%; 
					padding: 3px 8px; 
					font-size:13px;}
		
		table { margin-top: 30px;}


		input[type = "submit"]:hover { opacity : 0.7; }
	</style>
	<title>자연맘</title>
	<script>
	</script>
  </head>

  <body>
	<div id = "title">
		<h2>아이디 중복확인</h2>
	</div>
	
	
		<div>
			<table>
				<tr>
					<td style="text-align: right"><label for="id">아이디</label> </td>
					<td><input type="text" id="checkedid" name="checkedid" value="${checking_id}">
						<input type="button" id ="btn_id" value = "아이디 찾기" onclick="check_again()"/></td>
				</tr>
				<tr><td colspan="2" style="text-align: center;"><br><br><span>${flash_msg}</span></td></tr>
			</table>
		</div>

	
	<br><hr>
	
	<div id = "close">
		<input type = "button" id = "btn_close" onclick = "window.close();" value = "닫기" />
	</div>
  </body>
  
<script type="text/javascript">
	function check_again() {
		var id = $('#checkedid').val();
		document.location.href = '/soap/checkId.nm?check='+id;
	}
	

</script>
</html>
