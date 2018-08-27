<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		table tr:nth-child(2) td { background-color : #918686; color : white; padding: 7px; }
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
		
	</style>
	
	<script type="text/javascript">
		function pop_refund_req(){
			var center_width = (screen.width/2) - (720/2);
			var center_height = (screen.height/2) - (400/2);
			window.open("refund_req_popup.jsp", "refund_req", "width=720px, height=400px, left="+center_width+", top="+center_height+", scrollbars=no, toolbar=no, location=no");
		}
	</script>
	<!--주문내역 조회 부분-->
	<form action="#" method="post">
		<br><br>
		<table cellspacing="0">
			<tr>
				<td colspan = "8"><h2>주문내역 조회</h2></td>
			</tr>
			<tr>
				<td>선택</td>
				<td>주문번호</td>
				<td>주문일자</td>
				<td>상품이미지</td>
				<td>상품명</td>
				<td>수량</td>
				<td>결제금액</td>
				<td>처리상태</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="orderlist_sel" value="선택된주문번호 랑 상품번호"></td>
				<td>155553</td>
				<td>2016/03/05</td>
				<td><img src="images/soap11.jpg" alt="쑥비누사진"></td>
				<td><a href="#">쑥비누</a></td>
				<td>1</td>
				<td>4300원</td>
				<td>배송준비중</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="orderlist_sel" value="선택된주문번호 랑 상품번호"></td>
				<td>155553</td>
				<td>2016/03/05</td>
				<td><img src="images/soap1.jpg" alt="아마씨비누사진"></td>
				<td><a href="#">아마씨비누</a></td>
				<td>2</td>
				<td>7000원</td>
				<td>배송준비중</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="orderlist_sel" value="선택된주문번호 랑 상품번호"></td>
				<td>122332</td>
				<td>2015/01/12</td>
				<td><img src="images/soap12.jpg" alt="뽕잎비누사진"></td>
				<td><a href="#">뽕잎비누</a></td>
				<td>2</td>
				<td>7300원</td>
				<td>구매확정</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="orderlist_sel" value="선택된주문번호 랑 상품번호"></td>
				<td>122332</td>
				<td>2015/01/12</td>
				<td><img src="images/soap1.jpg" alt="아마씨비누사진"></td>
				<td><a href="#">아마씨비누</a></td>
				<td>4</td>
				<td>21300원</td>
				<td>구매확정</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="orderlist_sel" value="선택된주문번호 랑 상품번호"></td>
				<td>112311</td>
				<td>2014/09/01</td>
				<td><img src="images/soap4.jpg" alt="함초비누사진"></td>
				<td><a href="#">함초비누</a></td>
				<td>1</td>
				<td>4500원</td>
				<td>배송완료</td>
			</tr>
			<tr>
				<td colspan="8">
				<input type="button" onclick="pop_refund_req()" value="환불신청">
				<input type="button" value="구매확정">
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
