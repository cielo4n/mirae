<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
			<td>판매상태</td>
		</tr>
		
		<c:forEach var="il" items="${interest_list}">
			<tr>
				<td><input type="checkbox" id="no" value="${il.product_no}"></td>
				<td><a href="<c:url value='/product/detail.nm?pdno=${il.product_no}'/>">
				<img src="/soap/resources/product_images/${il.represent_img}" alt="${il.product_name}">
				</a></td>
				<td><a href="<c:url value='/product/detail.nm?pdno=${il.product_no}'/>">${il.product_name}</a></td>
				<td>${il.selling_price}원</td>
				
				<td>
				<c:choose>
	            <c:when test ="${il.stock <= 0 || il.sale_state==0}">
	            	품절
	            </c:when>
	            <c:otherwise>
	            	판매중
	            </c:otherwise>
            	</c:choose>
				</td>
			</tr>
		</c:forEach>
		
		<c:if test="${interest_list==null}">
			<tr style="background-color:#f0f0f0; ">
				<td colspan="5"><br/>관심 상품이 없습니다.<br/>&nbsp;</td>
			</tr>
		</c:if>		
				
		<tr>
			<td colspan = "5">
				<input type = "button" value="상품삭제" onclick='deleteInterestProduct();'>
				<input type = "submit" value="장바구니등록" onclick='interestToCart();'>
			</td>
		</tr>
	</table>
	
<script type="text/javascript">

  function deleteInterestProduct(){
  	var checked="";
  	
  	$('input:checkbox[id="no"]:checked').each(function(){
        checked += '&no=' + $(this).val();
    });
	console.log(checked);
	if(checked==""){
		alert("삭제할 상품을 선택하세요");
		return;
	}
	var temp = checked.substring(1);
	console.log(temp);
	
	location.href="/soap/interest/del_proc.nm?"+temp;
  }
  
  function interestToCart(){
	  var checked="";
	  	
	  	$('input:checkbox[id="no"]:checked').each(function(){
	        checked += '&no=' + $(this).val();
	    });
		console.log(checked);
		var temp = checked.substring(1);
		console.log(temp);

		if(checked==""){
			alert("장바구니에 등록할 상품을 선택하세요");
		} else {
			if(confirm("선택된 상품을 장바구니로 이동하시겠습니까?")){
				location.href="/soap/interest/to_cart.nm?"+temp;
			}			
		}

  }
</script>

</body>
</html>