<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="css/admin_common.css"/>
		
	<title>자연맘</title>

	<script type="text/javascript" src="js/nicEdit.js"></script>
	<script type="text/javascript">
		bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
	</script>
	<style type = "text/css">

		#inside { padding-top : 70px; padding-left: 220px;
					margin : 30px auto; color: #85858d; }
		#inside a { text-decoration: underline; }

		h2 { margin-bottom : 15px; font-size: 24px; color: #004523;}
		
		table { width : 720px; padding : 0px; }
		table tr:first-child td, table tr:last-child td { border-top : 1px solid grey; }
		table tr:not(:last-child) td:first-child { border-left : 1px solid grey; }
		table tr:not(:last-child) td:last-child { border-right : 1px solid grey; }
		table tr td { padding : 10px; }
		table tr:not(:last-child) td
		{
			border-bottom : 1px solid lightgrey;
			margin : 0px;
		}

		table tr:first-child td:first-child, table tr:nth-child(2) td 
		{ 
			background-color: #918686; 
			color: white;
		}
		table tr:first-child td:first-child, table tr:nth-child(2) td:first-child
		{ 
			width: 100px;
			text-indent: 15px;
		}
		table tr:first-child td input[type = "text"]
		{
			font : 16px "나눔바른고딕", "맑은 고딕", Arial;
			border: 1px solid lightgrey;
			width: 95%;
		}
		table tr:nth-child(3) td textarea
		{
			width: 100%;
			height: 400px;
		}
		
		#buttons { margin-top: 20px; text-align: right; }
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
	</style>
   </head>

  <body>
<!---Start container----------------------------------------------------------------->
	
	<div id="inside">
		<h2 id = "reg_title">이벤트 - 글쓰기</h2>
		<form action = "#" method = "post">
			<table cellspacing = "0">
				<tr>
					<td><label for = "title">제목</label></td>
					<td><input type = "text" id = "title" name = "title" /></td>
				</tr>
				<tr>
					<td><label for = "event_content" >내용</label></td><td></td>
				</tr>
				<tr><td colspan = "2"><textarea name = "event_content" id = "event_content"></textarea></td></tr>
				<tr>
					<td colspan = "2" id = "buttons">
						<input type = "submit" value = "저장">
						<input type = "button" value = "취소" id = "cancel" name = "cancel" onclick="check()">
					</td>
				</tr>
			</table>
		</form>
	</div>
<!--------------------------------------------------------end container------------->
  </body>
  
  <script type="text/javascript">
  
  	function check() {
  		var write = nicEditors.findEditor('event_content').getContent();
  		
  		alert(write);
  		
	}
 		
  </script>

</html>