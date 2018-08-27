<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/soap/resources/js/jquery-1.11.3.min.js"></script>
<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->

<link rel="apple-touch-icon" href="/soap/resources/images/logo.ico" />

<!--단축키아이콘등록-->
<link rel="stylesheet" href="/soap/resources/css/admin_common.css" />

<title>운송장 번호 입력</title>

<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	width: 100%;
	height: 70%;
}

#container {
	width: 100%;
	margin: 50px auto;
	padding-bottom: 15px;
	padding-top: 0px;
}

#container a {
	text-decoration: underline;
}


input[type="text"], input[type="number"], select {
	padding-top: 5px;
	padding-bottom: 5px;
}

input[type="text"], input[type="number"], select{
	width: 100% 
}

input[type="text"], input[type="number"]{
	 height: 15px;
}

select {
	height: 30px; 
}

table {
	width: 80%;
	margin-left : auto;
	margin-right : auto;
}

table tr:not (:first-child ):nth-child(odd) td {
	padding-top: 20px;
}

table tr:last-child td {
	padding-top: 20px;
	text-align: center;
}
table tr:not(:first-child) td {
 	vertical-align : top;
 }

table tr:first-child td {
 	vertical-align : bottom;
}

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

#title {
	background-color: #635353;
	height: 50px;
}

#title h2 {
	padding: 15px 5px;
	color: white;
	font: 18px "나눔바른고딕", "맑은 고딕", Arial;
}


</style>
</head>

<body>
<div id = "title">
		<h2>&nbsp;&nbsp;운송장 번호 입력</h2>
</div>
	<!---Start container----------------------------------------------------------------->

	<div id="container">
		
		<form action="tracking_num_proc.nm" method="post" name="tracking_num_form" onsubmit="on_submit()">
			<table>
				<tr style="height: 20px;">
					<td>주문번호</td>
				</tr>

				<tr style="height: 50px;">
					<td><input type="text" readonly="readonly" id="order_no" value="&nbsp;${order_no}" sty></td>
				</tr>

				<tr>
					<td><label class="order_title">택배 회사 선택<label></td>
				</tr>

				<tr style="height: 50px;">
					<td><select id="delivery_company" name="delivery_company">
							<option value="-">&nbsp;-&nbsp;</option>
							<option value="cj대한통운">&nbsp;cj대한통운&nbsp;</option>
							<option value="로젠택배">&nbsp;로젠택배&nbsp;</option>
							<option value="옐로우캡">&nbsp;옐로우캡&nbsp;</option>
							<option value="우체국">&nbsp;우체국&nbsp;</option>
							<option value="한진택배">&nbsp;한진택배&nbsp;</option>
							<option value="현대택배">&nbsp;현대택배&nbsp;</option>
					</select><br></td>
				</tr>

				<tr>
					<td><label class="order_title">운송장 번호 입력<label></td>
				</tr>
				<tr style="height: 50px;">
					<td><input type="number" id="delivery_num" name="delivery_num" 
					onKeyUp="if ( isNaN(this.value) ) { alert('숫자만 입력가능합니다.'); this.value=''; } else { if(this.value > 9999999999) { this.value = this.value.substring(0,10); } }"/></td>
				</tr>
				
				<tr>
					<td><input type="button" value="확인" class="buttons" onclick="tracking_num_send()"> 
						<input type="button" onclick = "window.close();" value="취소" class="buttons">
					</td>
				</tr>

			</table>
			<input type="hidden" id="order_no" name="order_no" value="${order_no}">

		</form>
	</div>
  <script type="text/javascript">
   
  function tracking_num_send(){
	  
	  var com = $('#delivery_company').val();
	  var num = $('#delivery_num').val();
	  var no = $('#order_no').val();
	  
	  if(com == '-'){
		 alert('택배 회사를 선택해 주세요.');
	  }else if(num == ''){
		 alert('운송장 번호를 입력해 주세요.'); 
	  }else{
		  
		  no = no.replace(/^\s+/, "");
		  no = no.replace(/\s+$/, "");
		
		  num = num.replace(/^\s+/, "");
		  num = num.replace(/\s+$/, "");
		  
		  com = com.replace(/^\s+/, "");
		  com = com.replace(/\s+$/, "");
		  
		  opener.document.tracking_num_form.delivery_company.value=com;
		  
		  opener.document.tracking_num_form.delivery_num.value=num;
		  
		  opener.document.tracking_num_form.order_no.value=no;
		 /*  alert(opener.document.tracking_num_form.delivery_company.value+
				  opener.document.tracking_num_form.delivery_num.value+
				  opener.document.tracking_num_form.order_no.value); */
		  opener.document.tracking_num_form.submit();
		  
		  self.close();
		  //
		  //window.close();
		  
		  
		  /*
		  document.tracking_num_form.submit();
		  
		  opener.document.tracking_num_form.delivery_company.value = com;
		  opener.document.tracking_num_form.delivery_num.value = num;
		  opener.document.tracking_num_form.order_no.value = no;
		  
		  var form = document.tracking_num_form;
		  form.target = opener.window.name;
		  
		  opener.window.name;

		  form.submit();
		  //self.close();

		  window.name = 'oredermanager';
		  
		   document.tracking_num_form.submit();
		  opener.location.href = '/soap/admin/order.nm';
		  */

	  }
	}
  function form_submit(){
	  opener.location.reload();
	  self.close(); 
  }
  
  </script>
	<!--------------------------------------------------------end container------------->
</body>

</html>