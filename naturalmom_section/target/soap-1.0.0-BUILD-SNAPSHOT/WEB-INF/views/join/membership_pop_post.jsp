<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			margin-top: 10px;
			text-align: left; 
			padding: 5px;
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
		
		#btn_addr
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

		td:first-child { width: 23%; 
					padding: 3px 8px; }
					
		.input {padding-top: 20px;  font-size:13px;}
		.result{ padding: 15px; margin: 10px; 
				border: 1px solid lightgray;
				width: 95%;}
		
		#post_num { font-style: oblique;}


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
	
	
	<form action="">
		<div>
			<table class="input">
				<tr>
					<td style="text-align: right"><label for="id">주소입력</label> </td>
					<td><input type="text" id="address" placeholder="예) 판교역로 235, 제주 첨단로 242, 한남동 714"><input type="submit" id ="btn_addr" value = "찾기" /></td>
				</tr>
				<tr>
					<td colspan="2"><h3>How to</h3>
						<span>도로명이나 지역명을 이용해서 검색해 보세요. 건물번호, 번지를 함께 입력하시면 더욱 정확한 결과가 검색됩니다.</span><br>
					</td>
				</tr>
			</table>
		</div>
	</form>
	
	<br><hr>
	
	<form action="">
		<h3><label for = "reg">검색결과</label></h3>
		<table class="result">
				<tr>
					<td colspan="2"><span id="post_num">133431 (462-100)</span></td>
				</tr>
				<tr>
					<td style="text-align: right">도로명</td>
					<td><a href="#">경기 성남시 중원구 돌마로 1039</a></td>
				</tr>
				<tr>
					<td style="text-align: right">지번</td>
					<td><a href="#">경기 성남시 중원구 여수동 415-1</a></td>
				</tr>
			</table>
	</form>
	<div id = "close">
		<input type = "button" id = "btn_close" onclick = "window.close();" value = "닫기" />
	</div>
  </body>
</html>
