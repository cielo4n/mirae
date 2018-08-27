<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="../js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="../images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="../images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="../css/index.css"/>
	
	<style type = "text/css">
		.order_title { 
			margin-bottom : 5px; 
			margin-top : 100px; 
    		color: #004523;
		}
		table tr td { padding : 20px; }
		table tr td input[type = "radio"] { margin-right : 3px; }
		table tr td label { margin-right : 25px; }
		table tr .explain { text-align : center; }
		
		/*실행안됨...*/
		/* table tr:first-child td:nth-child(1){ width:14%; }
		table tr:first-child td:nth-child(2){ width:16%; }
		table tr:first-child td:nth-child(3){ width:14%; }
		table tr:first-child td:nth-child(4){ width:19%; }
		table tr:first-child td:nth-child(5){ width:7%; }
		table tr:first-child td:nth-child(6){ width:14%; }
		table tr:first-child td:nth-child(7){ width:16%; } */
		
		#product_list
		{ 
			width: 100%; padding : 0px; 
			font : 14px "나눔바른고딕", "맑은 고딕", Arial;
			text-align : center;
		}
		#product_list tr:first-child td
		{ 
			border-top : 2px solid black;
			border-bottom : 1px solid #AAAAB0; 
			background-color : #F9F9F9;
			padding-top : 15px;
			padding-bottom : 15px;
		}
		#product_list tr:last-child td
		{
			border-top : 1px solid #AAAAB0;
			border-bottom : 1px solid #AAAAB0;
			background-color : #F9F9F9;
			padding-top : 20px;
			padding-bottom : 20px;
		}
		
		#product_list tr:last-child td
		{ 
			text-align : right;
		}
		

		.button
		{	
			padding-top : 7px;
			padding-bottom : 7px;
			padding-right : 20px;
			padding-left : 20px;
			margin : 50px auto;
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 20px;
			border-radius : 10px; 
			border : 0px;
			width: 120px;
		}
		.button:hover { opacity : 0.7; }

		#button { text-align : center; }
	</style>

<!---Start container----------------------------------------------------------------->
		<c:set var="o" value="${order}"/>
		
		<h3 class = "order_title">주문완료</h3>
			<table cellspacing = "0" id="product_list">
				<tr>
					<td width="14%">주문번호</td>
					<td width="16%">주문일자</td>
					<td width="14%">상품이미지</td>
					<td width="19%">상품명</td>
					<td width="7%">수량</td>
					<td width="14%">결제금액</td>
					<td width="16%">처리상태</td>
				</tr>
				<tr>
				<td>${o.order_no}</td>
				<td><fmt:formatDate value="${o.order_date}" type="Date" /></td>
				<td><img width="80%" src="/soap/resources/product_images/${o.represent_img}" alt="사진"></td>
				<td>${o.product_name}</td>
				<td>${o.buy_num}</td>
				<td><fmt:formatNumber value="${o.charge}" type="number"/>원</td>
				<td>${o.process_nm}</td>
				</tr>
				<tr>
					<td colspan = 7>
						<c:if test="${ not empty temp}">
						총 주문금액 : <fmt:formatNumber value="${charge-3000}" type="number"/>원&nbsp;+&nbsp;
						배송비 <fmt:formatNumber value="3000" type="number"/>원&nbsp;=&nbsp;&nbsp;
						<b><fmt:formatNumber value="${charge}" type="number"/>원</b>
						</c:if>
					</td>
				</tr>
			</table> 
		<p id="button"><input type="button" value="확인" class="button" onclick="location.href='/soap/index.nm';"></p>

<!--------------------------------------------------------end container------------->
</html>