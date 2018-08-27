<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="resources/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="resources/css/membership.css" />

	<title>자연맘</title>  
  
  
  </head>

  <body>


	<header>
		<%@include file="../_default_header.jsp" %>
	</header>


	<div id="container">
			<%@include file="../_default_menu.jsp" %>
		<!-------------Start content--------------------------------------------------->
		<div id="content">
		
	<style type="text/css">
		#content { text-align : center; }
		h2 { color : #004523; text-align : left; margin-top: 20px;}
		table { width : 100%; margin : auto; }
		th, td { text-align : center; padding : 5px; }
		td { border-bottom : solid 1px lightgray; }
		
		table tr:first-child td { border-bottom : 0px; padding-bottom : 30px;}
		table tr:nth-child(2) th { background-color : #918686; color : white; padding: 7px; font-weight : normal; }
		table td { font-size: 15px; }
		table tr:last-child td { border-bottom : 0px; text-align : right; }
		table tr:last-child input 
		{
			padding : 7px 30px;
			margin-left : 10px;
			margin-right : 5px;
			margin-top : 20px;
			background-color : #85858D;
			color : white;
			font-size : 16px;
			border-radius : 20px;
			border : 0px;
		}
		table tr:last-child input:hover { opacity : 0.7; }
		table img { width : 50px; height : 50px; }
		table a { text-decoration : none; color : #000000; }
		input[type="number"] { width : 40px; }
		table tr:last-child td:first-child
		{
			text-align : left; 
		}
		input[:type="number"]{
		text-align : center;
		}
	</style>
	<form action="#" method="post">
		<br><br>
		<table cellspacing="0" class="cart">
			<tr>
				<td colspan = "8"><h2>장바구니</h2></td>
			</tr>
			<tr>
				<th style="width:9.5%">선택</th>
				<th style="width:25.5%">상품이미지</th>
				<th style="width:30%" >상품명</th>
				<th style="width:10%">수량</th>
				<th style="width:25%">가격</th>
			</tr>
			
			<c:set var="cart_price" scope="page">0</c:set>
			<c:forEach var="cl" items="${cart_list}">
			<tr>
				<td><input type="checkbox" name="product_sel" value="${cl.product_no}"></td>
				<td><img src="${cl.represent_img}" alt="${cl.product_name}"></td>
				<td><a href="#">${cl.product_name}</a></td>
				<td><input type="number" name="${cl.buy_num}" size="5" value="1" min = "1"></td>
				<td>${cl.selling_price}원</td>
				<c:set var="cart_price" scope="page">${cart_price + (cl.selling_price * cl.buy_num)}</c:set>
			</tr>
			</c:forEach>
			
			<!-- 
			<tr>
				<td><input type="checkbox" name="orderlist_sel" value="선택된장바구니번호 랑 상품번호"></td>
				<td><img src="images/soap11.jpg" alt="쑥비누사진"></td>
				<td><a href="#">쑥비누</a></td>
				<td><input type="number" name="상품번호" size="5" value="1" min = "1"></td>
				<td>4300원</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="orderlist_sel" value="선택된장바구니번호 랑 상품번호"></td>
				<td><img src="images/soap1.jpg" alt="아마씨비누사진"></td>
				<td><a href="#">아마씨비누</a></td>
				<td><input type="number" name="상품번호" size="5" value="2" min = "1"></td>
				<td>7000원</td>
			</tr>
			-->
			
			<c:choose>
				<c:when test="${cart_list != null}">
					<tr style="background-color:#f0f0f0; ">
						<td></td>
						<td></td>
						<td>배송료  +3000</td>
						<td>총계</td>
						<td>${cart_price+3000}</td>
					</tr>
				</c:when>
	
				<c:otherwise>
					<tr style="background-color:#f0f0f0; ">
						<td colspan="5"><br/>장바구니에 담겨진 상품이 없습니다.<br/>&nbsp;</td>
					</tr>
				</c:otherwise>
			</c:choose>
			
			<tr>
				<td colspan="3">
				<input type="button" value="상품삭제">
				<input type="button" value="관심상품 등록">
				</td>
				<td colspan="2">
				<input type="button" value="주문하기" onclick="location.href='order.jsp';">
				</td>
			</tr>
		</table>
	</form>
		
	
	</div>
		<!--------------------------------------------------end content--------->
	</div><!--end container-->


	<footer>
		<%@include file="../_default_footer.jsp" %>
	</footer>
	
  </body>
  
</html>
