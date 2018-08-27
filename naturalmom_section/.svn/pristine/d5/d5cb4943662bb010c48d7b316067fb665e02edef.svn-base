<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="../js/jquery-1.11.3.min.js"></script>
<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->

<link rel="apple-touch-icon" href="../../images/logo.ico" />
<!--애플아이콘등록-->
<link rel="shortcut icon" href="../../images/logo.ico" />
<!--단축키아이콘등록-->
<link rel="stylesheet" href="../css/admin_common.css" />

<title>운송장 번호 입력</title>

<script type="text/javascript" src="js/nicEdit.js"></script>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	width: 400px;
	height: 300px;
	padding-bottom: 15px;
	padding-top: 0px;
	margin: 10px;
}

#container {
	width: 80%;
	margin: 50px auto;
}

#container a {
	text-decoration: underline;
}

textarea, input[type="text"], select {
	width: 100%
}

input[type="text"], select {
	padding-top: 5px;
	padding-bottom: 5px;
}

.order_title {
	
}

table tr:not(:first-child):nth-child(odd) td{ padding-top : 20px; }

table tr:last-child td{ padding-top : 40px; text-align : center; }

.buttons {
	margin-top: 20px;
	text-align: right;
}

.buttons {
	padding: 7px 30px;
	margin-left: 5px;
	margin-right: 5px;
	background-color: #85858D;
	color: white;
	font-family: "나눔바른고딕", "맑은 고딕";
	font-size: 16px;
	border-radius: 10px;
	border: 0px;
}

.buttons:hover {
	opacity: 0.7;
}
</style>
</head>

<body>
	<!---Start container----------------------------------------------------------------->

	<div id="container">
		<form action="#" method="post">
			<table>
				<tr>
					<td><label class="order_title">주문번호<label></td>
				</tr>

				<tr>
					<td><textarea id="order_nums" name="order_nums" cols="60"
							row="3">242424 242425</textarea></td>
				</tr>

				<tr>
					<td><label class="order_title">택배 회사 선택<label></td>
				</tr>

				<tr>
					<td><select id="delivery_company" name="delivery_company">
							<option value="1">&nbsp;cj 대한통운&nbsp;</option>
							<option value="2">&nbsp;로젠택배&nbsp;</option>
							<option value="3">&nbsp;옐로우캡&nbsp;</option>
							<option value="4">&nbsp;우체국&nbsp;</option>
							<option value="5">&nbsp;한진택배&nbsp;</option>
							<option value="6">&nbsp;현대택배&nbsp;</option>
					</select><br></td>
				</tr>

				<tr>
					<td><label class="order_title">운송장 번호 입력<label></td>
				</tr>
				<tr>
					<td><input type="text" id="delivery_num" name="delivery_num" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="확인" class="buttons"> 
							<input type="button" value="취소" class="buttons"></td>
				</tr>

			</table>
		</form>
	</div>
	<!--------------------------------------------------------end container------------->
</body>

</html>