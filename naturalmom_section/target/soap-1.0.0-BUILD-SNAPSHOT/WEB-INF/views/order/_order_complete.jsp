<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h3 class = "order_title">주문완료</h3>
			<table cellspacing = "0" id="product_list">
				<tr>
					<td width="14%">주문번호</td>
					<td width="16%">주문일자</td>
					<td width="14%">제품이미지</td>
					<td width="19%">상품명</td>
					<td width="7%">수량</td>
					<td width="14%">결제금액</td>
					<td width="16%">처리상태</td>
				</tr>
				<tr>
					<td>155553</td>
					<td>2016-03-17</td>
					<td>사진사진</td>
					<td>쑥 비누</td>
					<td>1개</td>
					<td>4,300원</td>
					<td>배송준비중</td>
				</tr>
				<tr>
					<td>155553</td>
					<td>2016-03-17</td>
					<td>사진사진</td>
					<td>아마씨 비누</td>
					<td>2개</td>
					<td>7,000원</td>
					<td>배송준비중</td>
				</tr>
				<tr>
					<td colspan = 7>
						총 주문금액 : 11,300 + 배송비 3,000원 = <b>14,300원</b>
					</td>
				</tr>
			</table> 
		<p id="button"><input type="button" value="확인" class="button" onclick="location.href='index.jsp';"></p>

<!--------------------------------------------------------end container------------->
</html>