<!-- admin_sales.jsp - 매출 - 매출조회-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>


<head>
<title>자연맘</title>
<style type = "text/css">

		* { margin: 0px; padding: 0px; }

		#in { width : 1024px; margin : 50px auto; color: #85858d; font-family : "나눔바른고딕", "맑은 고딕"; }
		#in a { text-decoration: underline;  text-decoration: none;}
	

		h2 { margin-bottom : 15px; }
		
		table { width: 100%; padding : 0px; }
		table tr:first-child td, table tr:first-child td a { text-align:center; background-color: #918686; color: white; }
		table tr:not(:first-child) td a { color: black; }
		table tr td { border-top : 1px solid grey; border-bottom : 1px solid grey; }
		table tr td { border-right : 1px solid lightgrey; }
		table tr td:first-child { border-left : 1px solid grey; }
		table tr td:last-child { border-right: 1px solid grey; }
		table tr td { padding : 5px; color: black;}

		table tr:not(:first-child) td { text-align: center; }
		


		#option_time input[type="button"]{ margin-top: 10px; text-align: left; }
	
		#option_time input[type = "button"]
		{
			padding : 5px 15px;
			margin-left : 3px;
			margin-right : 3px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 10px; 
			border : 0px;
		}
		#option_time #start{ margin-left:230px; }
		#option_time input[type = "button"]:hover { opacity : 0.7; }

		#yuback {padding:30px;}
		
		#option-period { float: right; }

	</style>
   </head>
   
   
<!--  Start header --------------------------------------------------------------------->
<header>

</header>
<!-----------------------------------------------------------end header ----------->	
<!---Start container----------------------------------------------------------------->
<body>
<div id="in">
	<h2>매출조회</h2>
		<div id="option_time">
			<input id="option-today" value="오늘" type="button" onclick="datefunc('today')">
			<input id="option-week" value="7일" type="button" onclick="datefunc('week')">
			<input id="option-month1" value="1개월" type="button" onclick="datefunc('month1')">
			<input id="option-month3" value="3개월" type="button" onclick="datefunc('month3')">
			<input id="option-month6" value="6개월" type="button" onclick="datefunc('month6')">
			<input id="option-all" value="전체" type="button" onclick="datefunc('all')">
			<input id="start" value="" type="date" >
			<input id="end" value="" type="date" >
			<input id="option-period" value="입력" type="button" onclick="datefunc('period')">
		</div>
		
		<div id="yuback"></div>
		<h2 id="product_table">표</h2>
		<table cellspacing="0">
			<tbody><tr>
				<td>주문수</td>
				<td>품목수</td>
				<td>상품구매 금액</td>
				<td>배송비</td>
				<td>결제 합계</td>
				<td>환불상품 금액 합계</td>
				<td>환불 합계</td>
				<td>순매출</td>
			</tr>
			<tr>
				<td>
					<fmt:formatNumber value="${sale.order_no}" type="number"/>
				</td>
				<td>
					<fmt:formatNumber value="${sale.product_no}" type="number"/>
				</td>
				<td>
					<fmt:formatNumber value="${sale.sale_sum}" type="number"/>원
				</td>
				<td>
					<fmt:formatNumber value="${sale.delivery_sum}" type="number"/>원
				</td>
				<td>
					<fmt:formatNumber value="${sale.sale_total_sum}" type="number"/>원
				</td>
				<td>
					<fmt:formatNumber value="${sale.refund_sum}" type="number"/>원
				</td>
				<td>
					<fmt:formatNumber value="${sale.refund_total_sum}" type="number"/>원
				</td>
				<td>
					<fmt:formatNumber value="${sale.net_sale}" type="number"/>원
				</td>
			</tr>
		</tbody></table>
		<div id="yuback"></div>

	</div>
<script type="text/javascript">
		function datefunc(kind)
		{
			//console.log(kind);
			if(kind == 'today'){
				var f = document.createElement("form"); // form 엘리멘트 생성 
	        	f.setAttribute("method","post"); // method 속성 설정 
	        	f.setAttribute("action","/soap/admin/sales.nm"); // action 속성 설정 
	        	document.body.appendChild(f); // 현재 페이지에 form 엘리멘트 추가 
				
	        	//nowdate.getFullYear() + "-" + (nowdate.getMonth()+1) + "-" + nowdate.getDate()
	        	var i = document.createElement("input"); // input 엘리멘트 생성 
	        	i.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i.setAttribute("name","t"); // name 속성을 'nick'으로 설정 
	        	i.setAttribute("value", new Date()); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i); // form 엘리멘트에 input 엘리멘트 추가  
	        	f.submit(); // 전송 
			}
			else if(kind == 'week'){
				var f = document.createElement("form"); // form 엘리멘트 생성 
	        	f.setAttribute("method","post"); // method 속성 설정 
	        	f.setAttribute("action","/soap/admin/sales.nm"); // action 속성 설정 
	        	document.body.appendChild(f); // 현재 페이지에 form 엘리멘트 추가 

	        	var i1 = document.createElement("input"); // input 엘리멘트 생성 
	        	i1.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i1.setAttribute("name","t"); // name 속성을 'nick'으로 설정 
	        	i1.setAttribute("value", new Date()); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i1); // form 엘리멘트에 input 엘리멘트 추가  
	        	var i2 = document.createElement("input"); // input 엘리멘트 생성 
	        	i2.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i2.setAttribute("name","p"); // name 속성을 'nick'으로 설정 
	        	i2.setAttribute("value", 'week'); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i2); // form 엘리멘트에 input 엘리멘트 추가
	        	f.submit(); // 전송 
			}
			else if(kind == 'month1'){
				var f = document.createElement("form"); // form 엘리멘트 생성 
	        	f.setAttribute("method","post"); // method 속성 설정 
	        	f.setAttribute("action","/soap/admin/sales.nm"); // action 속성 설정 
	        	document.body.appendChild(f); // 현재 페이지에 form 엘리멘트 추가 

	        	var i1 = document.createElement("input"); // input 엘리멘트 생성 
	        	i1.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i1.setAttribute("name","t"); // name 속성을 'nick'으로 설정 
	        	i1.setAttribute("value", new Date()); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i1); // form 엘리멘트에 input 엘리멘트 추가  
	        	var i2 = document.createElement("input"); // input 엘리멘트 생성 
	        	i2.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i2.setAttribute("name","p"); // name 속성을 'nick'으로 설정 
	        	i2.setAttribute("value", 'month1'); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i2); // form 엘리멘트에 input 엘리멘트 추가
	        	f.submit(); // 전송 
			}
			else if(kind == 'month3'){
				var f = document.createElement("form"); // form 엘리멘트 생성 
	        	f.setAttribute("method","post"); // method 속성 설정 
	        	f.setAttribute("action","/soap/admin/sales.nm"); // action 속성 설정 
	        	document.body.appendChild(f); // 현재 페이지에 form 엘리멘트 추가 

	        	var i1 = document.createElement("input"); 
	        	i1.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i1.setAttribute("name","t"); // name 속성을 'nick'으로 설정 
	        	i1.setAttribute("value", new Date()); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i1); // form 엘리멘트에 input 엘리멘트 추가  
	        	var i2 = document.createElement("input"); // input 엘리멘트 생성 
	        	i2.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i2.setAttribute("name","p"); // name 속성을 'nick'으로 설정 
	        	i2.setAttribute("value", 'month3'); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i2); // form 엘리멘트에 input 엘리멘트 추가
	        	f.submit(); // 전송 
			}
			else if(kind == 'month6'){
				var f = document.createElement("form"); // form 엘리멘트 생성 
	        	f.setAttribute("method","post"); // method 속성 설정 
	        	f.setAttribute("action","/soap/admin/sales.nm"); // action 속성 설정 
	        	document.body.appendChild(f); // 현재 페이지에 form 엘리멘트 추가 

	        	var i1 = document.createElement("input"); // input 엘리멘트 생성 
	        	i1.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i1.setAttribute("name","t"); // name 속성을 'nick'으로 설정 
	        	i1.setAttribute("value", new Date()); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i1); // form 엘리멘트에 input 엘리멘트 추가  
	        	var i2 = document.createElement("input"); // input 엘리멘트 생성 
	        	i2.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i2.setAttribute("name","p"); // name 속성을 'nick'으로 설정 
	        	i2.setAttribute("value", 'month6'); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i2); // form 엘리멘트에 input 엘리멘트 추가
	        	f.submit(); // 전송 
			}
			else if(kind == 'period'){
				var start = document.getElementById('start').value;
				var end = document.getElementById('end').value;

				if(start != null && end != null && start != '' && end != ''){
				
				var f = document.createElement("form"); // form 엘리멘트 생성 
	        	f.setAttribute("method","post"); // method 속성 설정 
	        	f.setAttribute("action","/soap/admin/sales.nm"); // action 속성 설정 
	        	document.body.appendChild(f); // 현재 페이지에 form 엘리멘트 추가 

	        	var i1 = document.createElement("input"); // input 엘리멘트 생성 
	        	i1.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i1.setAttribute("name","s"); // name 속성을 'nick'으로 설정 
	        	i1.setAttribute("value", start); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i1); // form 엘리멘트에 input 엘리멘트 추가  
	        	
	        	var i2 = document.createElement("input"); // input 엘리멘트 생성 
	        	i2.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i2.setAttribute("name","e"); // name 속성을 'nick'으로 설정 
	        	i2.setAttribute("value", end); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i2); // form 엘리멘트에 input 엘리멘트 추가
	        	
	        	f.submit(); // 전송 
				}
				
				else{
					alert("날짜를 모두 입력해주세요.");
				}
			}
			else if(kind == 'all'){
				var f = document.createElement("form"); // form 엘리멘트 생성 
	        	f.setAttribute("method","post"); // method 속성 설정 
	        	f.setAttribute("action","/soap/admin/sales.nm"); // action 속성 설정 
	        	document.body.appendChild(f); // 현재 페이지에 form 엘리멘트 추가 

	        	var i = document.createElement("input"); // input 엘리멘트 생성 
	        	i.setAttribute("type","hidden"); // type 속성을 hidden으로 설정 
	        	i.setAttribute("name","a"); // name 속성을 'nick'으로 설정 
	        	i.setAttribute("value", 'all'); // value 속성을 '지앤미'로 설정 
	        	f.appendChild(i); // form 엘리멘트에 input 엘리멘트 추가  
	        	f.submit(); // 전송 
			}
			
		}
		
	</script>
  </body>
</html>