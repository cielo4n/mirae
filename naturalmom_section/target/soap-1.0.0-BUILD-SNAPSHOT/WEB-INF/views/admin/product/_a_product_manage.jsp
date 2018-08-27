<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<style type = "text/css">

		#container   { width : 1024px; margin : 50px auto; color: #85858d; }
		#container a { text-decoration: underline; }

		#container h2 { margin-bottom : 15px; }
		
		table { width: 100%; padding : 0px; }
		table tr:first-child td, table tr:first-child td a { text-align:center; background-color: #918686; color: white; }
		table tr:not(:first-child) td a { color: black; }
		table tr td { border-top : 1px solid grey; border-bottom : 1px solid grey; }
		table tr td { border-right : 1px solid lightgrey; }
		table tr td:first-child { border-left : 1px solid grey; }
		table tr td:last-child { border-right: 1px solid grey; }
		table tr td { padding : 10px; }

		table tr:not(:first-child) td:nth-child(1), table tr:not(:first-child) td:nth-child(3), 
		table tr:not(:first-child) td:nth-child(4), table tr:not(:first-child) td:nth-child(5), 
		table tr:not(:first-child) td:nth-child(8), table tr:not(:first-child) td:nth-child(9) { text-align: center; }
		table tr:not(:first-child) td:nth-child(2), table tr:not(:first-child) td:nth-child(6), 
		table tr:not(:first-child) td:nth-child(7), table tr:not(:first-child) td:nth-child(10) { text-align: right; }


		#buttons { margin-top: 20px; text-align: right; }
		#buttons input[type = "button"]
		{
			padding : 7px 20px;
			margin-left : 3px;
			margin-right : 3px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 10px; 
			border : 0px;
		}
		#buttons input[type = "button"]:hover { opacity : 0.7; }

	</style>
<!-- 링크, 이미지 살려놓기. product.nm 상태에도 리스트 띄우기 -->
<!-- container 부분 -->	
	<h2 id = "reg_title">상품 관리</h2>
		<table cellspacing = "0">
			<tr>
				<td>체크</td>
				<td><a href = "/admin/product.nm?page=manage&by=no&order=true">▼ 상품번호</a></td>
				<td><a href = "#">▼ 분류</a></td>
				<td><a href = "#">▼ 상품명</a></td>
				<td>이미지</td>
				<td><a href = "#">▼ 가격(원가)</a></td>
				<td><a href = "#">▼ 재고</a></td>
				<td><a href = "#">▼ 진열 상태</a></td>
				<td><a href = "#">▼ 판매 상태</a></td>
				<td><a href = "#">▼ 총 누적판매량</a></td>
			</tr>
			
			<c:forEach var="product" items="${p_list}">
			<tr>
				<td><input type = "checkbox" name = "" /></td>
				<td>${product.product_no}</td>
				<td>${product.category_nm}</td>
				<td><a href = "a_product.jsp?page=modify">${product.product_name}</a></td>
				<td>[사진]</td>
				<td>${product.selling_price}(${product.cost_price})</td>
				<td>${product.stock}</td>
				<td>${product.display_state eq 1 ? 'Y' : 'N'}</td>
				<td>${product.sale_state eq 1 ? 'Y' : 'N'}</td>
				<td>${product.all_sells}</td>
			</tr>
			</c:forEach>
		</table>
		<div id = "buttons">
			<input type = "button" id = "dis_y" value = "진열" />
			<input type = "button" id = "dis_n" value = "진열 안함" />
			<input type = "button" id = "sale_y" value = "판매" />
			<input type = "button" id = "sale_n" value = "판매 안함" />
			<input type = "button" id = "del" value = "삭제" />
		</div>
</html>