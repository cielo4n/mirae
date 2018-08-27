<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style type = "text/css">
	h2 { color : #004523; border-bottom : 0px; text-align : left; }
	table { width :75%; 
			margin: 0 auto; } 
	th, td { text-align : center;  padding : 5px; }
	td { border-bottom : solid 1px lightgray; }

	table tr:first-child td { border-bottom : 0px; text-align: left; padding: 20px 0 }
	table tr:nth-child(2) { background-color : #918686; color : white; padding: 7px;}	
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
	<form action="#" method="post">
	<br><br>
	<table cellspacing="0">
		<tr>
			<td colspan="4"><h2>관심상품</h2></td>
		</tr>
		<tr>
			<td>선택</td> 
			<td>상품이미지</td> 
			<td>상품명</td> 
			<td>가격</td>
		</tr>
		
		<c:forEach var="il" items="${interest_list}">
			<tr>
				<td><input type="checkbox" name="product_sel" value="${il.product_no}"></td>
				<td><img src="${il.represent_img}" alt="${il.product_name}"></td>
				<td><a href="#">${il.product_name}</a></td>
				<td>${il.selling_price}원</td>
			</tr>
		</c:forEach>
		
		<!-- 
		<tr>
			<td><input type="checkbox" name="fav_sel" value="제품번호불러온거"></td>
			<td><img src="images/soap11.jpg" alt="쑥비누사진"></td>
			<td><a href="#">쑥비누</a></td>
			<td>4300원</td> 
		</tr>
		<tr>
			<td><input type="checkbox" name="fav_sel" value="제품번호불러온거"></td>
			<td><img src="images/soap1.jpg" alt="아마씨비누사진"></td>
			<td><a href="#">아마씨비누</a></td>
			<td>3500원</td> 
		</tr>
		-->
		<tr>
			<td colspan = "4">
			
				<input type = "button" value="상품삭제">
				<input type = "submit" value="장바구니등록">
			</td>
		</tr>
	</table>
	
	</form>
</body>
</html>