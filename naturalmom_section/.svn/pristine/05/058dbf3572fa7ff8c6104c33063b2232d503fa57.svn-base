<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="/soap/resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="/soap/resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="/soap/resources/css/admin_common.css"/>
		
	<title>자연맘</title>

	<script type="text/javascript" src="/soap/resources/admin/js/nicEdit.js"></script>
	<script type="text/javascript">
		bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
	</script>
	<style type = "text/css">
		#container { width : 764px; margin : 50px auto;}
		#inside { color: #85858d; }
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
		<form action = "event_write.nm" method = "post" name="event_form">
			<table cellspacing = "0">
				<tr>
					<td><label for = "title">제목</label></td>
					<td>
						<input type = "text" id = "title" name = "title" value="${e.evt_title}"/>
						<input type="hidden" id= "no" name="no" value="${empty e.event_no ? 0 : e.event_no}"/>
					</td>
					
				</tr>
				<tr>
					<td><label for = "event_content" >내용</label></td><td></td>
				</tr>
				<tr><td colspan = "2"><textarea name = "event_content" id = "event_content">${e.evt_content}</textarea></td></tr>
				<tr>
					<td colspan = "2" id = "buttons">
						<input type = "button" value = "저장" onclick="checkNull()">
						<input type = "button" value = "취소" onclick="location.href='event.nm'">
					</td>
				</tr>
			</table>
		</form>
	</div>
<!--------------------------------------------------------end container------------->
  </body>
 <script type="text/javascript">

	function checkNull() {
		var title =$('#title').val();
		var content = nicEditors.findEditor('event_content').getContent();
		
		if(content=="<br>" || content==null 
				|| title=="" || title==null ){
			alert("제목과 내용을 빠짐없이 입력해주세요");
		}else{
			$('#event_content').text(content);
			document.event_form.submit();
		}
	}

</script>

