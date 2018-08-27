<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="/soap/resources/admin/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="stylesheet" href="/soap/resources/admin/css/admin_common.css"/>
	
	<script type="text/javascript" src="/soap/resources/tablesorter/jquery-latest.js"></script> 
	<script type="text/javascript" src="/soap/resources/tablesorter/jquery.tablesorter.js"></script>
	
	
	<title>자연맘</title>
	
	<script type="text/javascript" src="/soap/resources/js/nicEdit.js"></script>

	<style type = "text/css">

		* { margin: 0px; padding: 0px; }

		#container { width : 1024px; margin : 50px auto; color: #85858d; }
		#container a { text-decoration: underline; }

		h2 { margin-bottom : 15px; }
		
		table { width: 100%; padding : 0px;  font-size : 12.5px;}
		table tr th { text-align:center; background-color: #918686; color: white; padding: 10px 20px; }
		table tr td a { color: black; }
		table tr td { border-bottom : 1px solid lightgrey; }
		table tr td { border-right : 1px solid lightgrey; }
		table tr td:first-child { border-left : 1px solid grey; }
		table tr td:last-child { border-right: 1px solid grey; }
		table tr:last-child td { border-bottom : 1px solid grey; }
		table tr td { padding : 10px; }

		table tr td:nth-child(1), table tr td:nth-child(2), table tr td:nth-child(3), 
		table tr td:nth-child(5), table tr td:nth-child(8), 
		table tr td:nth-child(9){ text-align: center; }
		
		table tr td:nth-child(4), table tr td:nth-child(7), {  text-align: left; }
		table tr td:nth-child(6) {  text-align: right; }

		table tr:first-child td:first-child { width:10%; }
		table tr:first-child td:nth-child(2){ width:9%; }
		table tr:first-child td:nth-child(3){ width:8%; }
		table tr:first-child td:nth-child(4){ width:16%; }
		table tr:first-child td:nth-child(5){ width:8%; }
		table tr:first-child td:nth-child(6){ width:9%; }
		table tr:first-child td:nth-child(7){ width:19%; } 
		table tr:first-child td:nth-child(8){ width:11%; } 
		table tr:first-child td:nth-child(9){ width:10%; } 

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
		
		.msg {overflow:hidden;text-overflow:ellipsis;}
		
	 th:nth-child(1).header, th:nth-child(2).header, th:nth-child(3).header, th:nth-child(4).header,
	 th:nth-child(5).header, th:nth-child(6).header { 
    	background-image: url(/soap/resources/tablesorter/themes/blue/bg.gif); 
    	cursor: pointer; 
    	background-repeat: no-repeat; 
    	background-position: center right; 
    	border-right: 1px solid #dad9c7;
      } 
      th.headerSortUp { 
   		background-image: url(/soap/resources/tablesorter/themes/blue/asc.gif); 
	  } 
	  th.headerSortDown { 
   		background-image: url(/soap/resources/tablesorter/themes/blue/desc.gif); 
	  } 
		
	</style>
   </head>

  <body>

	<header>
		<%@include file="../_default_header.jsp" %>
	</header>

<!---Start container---------------------------------------------------------------->
	
	<div id="container">
		<h2 id = "order_title">주문 관리</h2>
		<table cellspacing = "0" id = "order_part" class = "tablesorter">
			<thead>
			<tr>
				<th>주문일</th>
				<th>주문번호</th>
				<th>주문자</th>
				<th>상품명</th>
				<th>개수</th>
				<th>결제금액</th>
				<th>배송메세지</th>
				<th>운송장번호</th>
				<th>처리상태</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="om" items="${orderManeger}"> 
				<tr>
					<td style="text-align: center;"><fmt:formatDate value="${ om.order_date }" type="Date" /></td>
					<td>${ om.order_no }</td>
					<td>${ om.mem_name }</td>
					<td>${ om.product_name }</td>
					<td>${ om.buy_num }</td>
					<td><fmt:formatNumber value="${ om.charge }" type="number"/>원</td>
					<td class="msg" >${ om.delivery_msg }</td>
					<td>
						<input style="height: 20px; width: 100%;" type="number" readonly="readonly" 
							<c:if test="${ 0 ne om.tracking_num }">value="${ om.tracking_num }"</c:if>
							onclick="tracking_num_input(${ om.order_no },'${ om.process_nm }')"
						>
					</td>
					<td>
						<select name="process_no" onchange="process_change(${ om.order_no },'${ om.process_nm }')" <c:if test="${ om.process_nm.equals('구매확정') || om.process_nm.equals('환불완료') }">disabled="disabled"</c:if>>
							<option value="배송준비중" <c:if test="${ om.process_nm.equals('배송준비중') }">selected="selected"</c:if> >&nbsp;배송준비중&nbsp;</option>
							<option value="배송대기" <c:if test="${ om.process_nm.equals('배송대기') }">selected="selected"</c:if>>&nbsp;배송대기&nbsp;</option>
							<option value="배송중" <c:if test="${ om.process_nm.equals('배송중') }">selected="selected"</c:if>>&nbsp;배송중&nbsp;</option>
							<option value="배송완료" <c:if test="${ om.process_nm.equals('배송완료') }">selected="selected"</c:if>>&nbsp;배송완료&nbsp;</option>
							<option value="구매확정" <c:if test="${ om.process_nm.equals('구매확정') }">selected="selected"</c:if>>&nbsp;구매확정&nbsp;</option>
							<option value="환불요청" <c:if test="${ om.process_nm.equals('환불요청') }">selected="selected"</c:if>>&nbsp;환불요청&nbsp;</option>
							<option value="환불완료" <c:if test="${ om.process_nm.equals('환불완료') }">selected="selected"</c:if>>&nbsp;환불완료&nbsp;</option>
						</select>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<br>
		
		<br>
		<form action="order.nm" method="post" name="tracking_num_form">
			<input type="hidden" name="order_no" id="order_no">
			<input type="hidden" name="delivery_company" id="delivery_company">
			<input type="hidden" name="delivery_num" id="delivery_num">
		</form>
		
	</div>
	<script type="text/javascript">
		$(document).ready(function() 
				{ 
					$("#order_part").tablesorter(); 
				} 
		);
	
		function tracking_num_input(order_no, process)
		{
			if(process == '배송준비중' || process == '배송대기'){
			window.open("/soap/admin/order_popup.nm?n="+order_no, "운송장 등록", "width = 420px, height = 410px, left = 500px, top = 200px, scrollbars = no, toobar = no, menubar = no, status = no, location = no, resizeable = no");
			}
			else{
				alert("배송준비 혹은 배송대기 시에만 운송장을 등록/수정 하실 수 있습니다.");
			}
		}
		function process_change(notice_no, process)
		{	
			if(process != '환불요청'){
				alert("환불요청에 대한 처리만 가능합니다.");
			}
			else{
				//alert(notice_no)
				var f = document.createElement("form"); // form 엘리멘트 생성 
	        	f.setAttribute("method","post"); // method 속성 설정 
	        	f.setAttribute("action","/soap/admin/order.nm"); // action 속성 설정 
	        	document.body.appendChild(f); // 현재 페이지에 form 엘리멘트 추가 

	        	var i = document.createElement("input"); // input 엘리멘트 생성 
	        	i.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i.setAttribute("name","refund_no"); // name 속성을 'nick'으로 설정 
	        	i.setAttribute("value",notice_no); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i); // form 엘리멘트에 input 엘리멘트 추가  
	        	f.submit(); // 전송 
			}
		}
	</script>
<!--------------------------------------------------------end container------------->
  </body>

</html>
