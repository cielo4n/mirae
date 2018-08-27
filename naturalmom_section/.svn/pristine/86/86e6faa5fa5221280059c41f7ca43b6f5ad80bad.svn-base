<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="/soap/resources/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="/soap/resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="/soap/resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="/soap/resources/css/index.css"/>

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
	<input  type="hidden">
	<!--주문내역 조회 부분-->
	<form action="/soap/order/orderlist_edit.nm" method="post" name="orderlist_form">
		<br><br>
		<c:if test="${not empty orderlist}">
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
			<c:forEach var="o" items="${orderlist}">
				<tr>
				<td><input type="checkbox" 
				<c:if test="${o.process_nm.equals('구매확정') || o.process_nm.equals('환불요청') || o.process_nm.equals('환불완료')}">disabled="disabled"</c:if>
				 name="order_sel"
				 value="${o.order_no}"></td>
				<td>${o.order_no}</td>
				<td><fmt:formatDate value="${o.order_date}" type="Date" /></td>
				<td><img src="/soap/resources/product_images/${o.represent_img}" alt="사진"></td>
				<td>${o.product_name}</td>
				<td>${o.buy_num}</td>
				<td><fmt:formatNumber value="${o.charge}" type="number"/>원</td>
				<td>${o.process_nm}</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="8">
				<input type="button" value="환불요청" onclick="refund()" />
				<input type="button" value="구매확정" onclick="buy()" />
				</td>
			</tr>
		</table>
		</c:if>
		<c:if test="${empty orderlist}">
		주문 내역이 없습니다.
		</c:if>
		<input type="hidden" name="process" id="process"/>
	</form>
<script type="text/javascript">
		function pop_refund_req(){
			var center_width = (screen.width/2) - (720/2);
			var center_height = (screen.height/2) - (400/2);
			window.open("refund_req_popup.jsp", "refund_req", "width=720px, height=400px, left="+center_width+", top="+center_height+", scrollbars=no, toolbar=no, location=no");
		}
	
	
	function refund(){
		var chk = document.getElementsByName("order_sel"); 
        var len = chk.length; 
        var res = 0; 
        for(var i=0; i<len; i++){ 
            if(chk[i].checked == true){ 
                res += 1; 
            }
        }
        
        if(res > 0){
        
        $('#process').attr("value", "환불요청");
      	//alert($('#process').val());
      	
      	document.orderlist_form.submit();
        }
        else{alert("환불하실 주문을 체크해 주세요");}
        
	}
	
	function buy(){
		 
        var chk = document.getElementsByName("order_sel"); 
        var len = chk.length; 
        var res = 0; 
        for(var i=0; i<len; i++){ 
            if(chk[i].checked == true){ 
                res += 1; 
            }
        }
        if(res > 0){
        	$('#process').attr("value", "구매확정");
          	//alert($('#process').val());
          	document.orderlist_form.submit();
      	}
        
        else{alert("구매확정하실 주문을 체크해 주세요");}
        
	}
</script>
		</div>
		<!--------------------------------------------------end content--------->
	</div><!--end container-->


	<footer>
		<%@include file="../_default_footer.jsp" %>
	</footer>

	
  </body>
</html>
