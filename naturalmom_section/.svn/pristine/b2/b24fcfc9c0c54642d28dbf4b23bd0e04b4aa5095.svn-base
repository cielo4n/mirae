<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="resources/admin/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="../resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="../resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="../resources/admin/css/admin_common.css"/>
			
	<title>자연맘</title>
	
	<script type="text/javascript" src="js/nicEdit.js"></script>
	<script type="text/javascript">
		bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
	</script>
	<script>
		function order_popup()
		{
			window.open("_a_order_popup.jsp", "운송장 등록", "width = 420px, height = 410px, left = 500px, top = 200px, scrollbars = no, toobar = no, menubar = no, status = no, location = no, resizeable = no");
		}
	</script>
	<style type = "text/css">

		* { margin: 0px; padding: 0px; }

		#container { width : 1024px; margin : 50px auto; color: #85858d; }
		#container a { text-decoration: underline; }

		h2 { margin-bottom : 15px; }
		
		table { width: 100%; padding : 0px;  font-size : 12.5px;}
		table tr:first-child td, table tr:first-child td a { text-align:center; background-color: #918686; color: white; }
		table tr:not(:first-child) td a { color: black; }
		table tr td { border-bottom : 1px solid lightgrey; }
		table tr td { border-right : 1px solid lightgrey; }
		table tr td:first-child { border-left : 1px solid grey; }
		table tr td:last-child { border-right: 1px solid grey; }
		table tr:last-child td { border-bottom : 1px solid grey; }
		table tr td { padding : 10px; }

		table tr:not(:first-child) td:nth-child(1), table tr:not(:first-child) td:nth-child(3), table tr:not(:first-child) td:nth-child(4), 
		table tr:not(:first-child) td:nth-child(2), table tr:not(:first-child) td:nth-child(5), table tr:not(:first-child) td:nth-child(7), 
		table tr:not(:first-child) td:nth-child(8), table tr:not(:first-child) td:nth-child(9),  td:nth-child(6) { text-align: center; }
		table tr:not(:first-child) td:nth-child(2), table tr:not(:first-child),
		table tr:not(:first-child) td:nth-child(9) { text-align: right; }

		table tr:first-child td:nth-child(1){ width:7%; }
		table tr:first-child td:nth-child(2){ width:11%; }
		table tr:first-child td:nth-child(3){ width:10%; }
		table tr:first-child td:nth-child(4){ width:10%; }
		table tr:first-child td:nth-child(5){ width:10%; }
		table tr:first-child td:nth-child(6){ width:8%; }
		table tr:first-child td:nth-child(7){ width:9%; }
		table tr:first-child td:nth-child(8){ width:14%; } 
		table tr:first-child td:nth-child(9){ width:11%; } 
		table tr:first-child td:nth-child(10){ width:10%; } 

		#buttons { margin-top: 20px; text-align: right; }
		#buttons input[type = "button"]
		{
			padding : 7px 20px;
			width : 110px;
			margin-left : 3px;
			margin-right : 3px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 10px; 
			border : 0px;
		}
		#buttons input[type = "button"]:hover, #save:hover { opacity : 0.7; }
		
		#save
		{
			padding : 7px 20px;
			width : 110px;
			margin-left : 3px;
			margin-right : 3px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 10px; 
			border : 0px;
			float : right;
		}

		#delivery_register { float : left; }

	</style>
   </head>

  <body>

	<header>
		<%@include file="../_default_header.jsp" %>
	</header>

<!---Start container---------------------------------------------------------------->
	
	<div id="container">
		<input type = "button" id = "save" value = "저장" />
		<h2 id = "order_title">주문 관리</h2>
		<table cellspacing = "0">
			
				<td>체크</td>
				<td><a href = "#">▼ 주문일</a></td>
				<td><a href = "#">▼ 주문번호</a></td>
				<td><a href = "#">▼ 주문자</a></td>
				<td><a href = "#">▼ 상품명</a></td>
				<td><a href = "#">▼ 개수</a></td>
				<td><a href = "#">▼ 결제금액</a></td>
				<td> 배송메세지</td>
				<td> 운송장번호</td>
				<td><a href = "#">▼ 처리상태</a></td>
			
			
			<c:forEach var="om" items="${orderManeger}"> 
				<tr>
					<td><input type = "checkbox" name = "" /></td>
					<td>${ om.order_date }</td>
					<td>${ om.order_no }</td>
					<td>${ om.mem_name }</td>
					<td>${ om.product_name }</td>
					<td>${ om.buy_num }</td>
					<td>${ om.charge }</td>
					<td>${ om.delivery_msg }</td>
					<td>${ om.tracking_num }</td>
					<td>
						<select name="process_no">
							<option value="11" <c:if test="${ om.process_nm.equals('배송준비중') }">selected="selected"</c:if> >&nbsp;배송준비중&nbsp;</option>
							<option value="12" <c:if test="${ om.process_nm.equals('배송대기') }">selected="selected"</c:if>>&nbsp;배송대기&nbsp;</option>
							<option value="13" <c:if test="${ om.process_nm.equals('배송중') }">selected="selected"</c:if>>&nbsp;배송중&nbsp;</option>
							<option value="14" <c:if test="${ om.process_nm.equals('배송완료') }">selected="selected"</c:if>>&nbsp;배송완료&nbsp;</option>
							<option value="21" <c:if test="${ om.process_nm.equals('구매확정') }">selected="selected"</c:if>>&nbsp;구매확정&nbsp;</option>
							<option value="31" <c:if test="${ om.process_nm.equals('환불처리') }">selected="selected"</c:if>>&nbsp;환불처리&nbsp;</option>
							<option value="32" <c:if test="${ om.process_nm.equals('환불완료') }">selected="selected"</c:if>>&nbsp;환불완료&nbsp;</option>
						</select>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		
		<br>
		<div id = "buttons">
			<input type = "button" onclick = "order_popup();" id = "delivery_register" value = "운송장등록" />
			<input type = "button" id = "delivery_stand_by" value = "배송대기" />
			<input type = "button" id = "refund_process" value = "환불처리"/>
			<input type = "button" id = "refund_complete" value = "환불완료" />
		</div>
	</div>
<!--------------------------------------------------------end container------------->
  </body>

</html>
