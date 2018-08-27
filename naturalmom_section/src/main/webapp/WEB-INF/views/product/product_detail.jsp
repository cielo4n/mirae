<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
   
   <link rel="apple-touch-icon" href="/soap/resources/images/logo.ico" /> <!--애플아이콘등록-->
   <link rel="shortcut icon" href="/soap/resources/images/logo.ico" /> <!--단축키아이콘등록-->
   <link rel="stylesheet" href="/soap/resources/css/product_soap.css"/>
      
   <title>자연맘</title>
   
   <style type="text/css">
   #stock { font-size : 15px; font-weight : normal; }
   </style>
   
  </head>
  <body>



   <header>
      <%@include file="../_default_header.jsp" %>
   </header>

   
   <div id="container">
      <%@include file="../_default_menu.jsp" %>
      <!-------------Start content--------------------------------------------------->
   
      
      
      <div id="content">
      
      
      
      
      
         <div id="soap_img">
            <img src="/soap/resources/product_images/${pvo.represent_img}" alt="${pvo.product_name}사진"/>
         </div>
         
         <div id="soap_table">
            <table>
            <form action="/soap/order/detailorder.nm" method="post" name="cart_form">
               <tr>
                  <td colspan="2">${pvo.product_name}&nbsp;${pvo.weight}g
                  
                  <span id="stock">
	                <c:choose>
		            	<c:when test ="${pvo.stock <= 0 || pvo.sale_state==0}">
		            	&nbsp;&nbsp;품절
		            	</c:when>
		            	<c:otherwise>
		            	&nbsp;&nbsp;판매중
		            	</c:otherwise>
	            	</c:choose>
		          </span>
                  </td>
               </tr>
               <tr>
                  <td colspan="2">${pvo.summary_ex}</td>
               </tr>
               <tr>
                  <td>판매 가격</td>
                  <td><label id="selling_price" >
                  	<c:if test ="${pvo.stock <= 0}">
                     	0
                     </c:if>
                     <c:if test ="${pvo.stock > 0}">
		            	${pvo.selling_price}</c:if></label>원
		            </td>
               </tr>
               <tr>
                  <td>유통 기한</td>
                  <td>상품 수령 후 1년</td>
               </tr>
               <tr>
                  <td>중량</td>
                  <td>${pvo.weight}g</td>
               </tr>
               <tr>
                  <td>구매 수량</td>
                  <td><input id="purchase_count" name="buy_num" type="number" min="1" max="100" step="1" size="3" 
                  <c:if test ="${pvo.stock > 0}">value="1"</c:if>
                  <c:if test ="${pvo.stock <= 0}">value="0" disabled="disabled"</c:if>/></td>
               </tr>
               <tr>
                  <td colspan="2">
                     총계
                     <label id="total_price" >
                     <c:if test ="${pvo.stock <= 0}">
                     	0
                     </c:if>
                     <c:if test ="${pvo.stock > 0}">
                     ${pvo.selling_price}</c:if>
		            </label>원
                  </td>
               </tr>
               <tr>
                  <td colspan="2">
               		<c:choose>

           			<c:when test="${not empty sessionScope.admin && sessionScope.admin == true}">
               		<input type="button" style="width:85px; padding : 13px 10px; margin : 0 5px;" onclick='alert("장바구니 등록은 회원 메뉴입니다")' value="장바구니"></button>
                  	<input type="button" style="width:85px; padding : 13px 10px; margin : 0 5px;" onclick='alert("관심상품 등록은 회원 메뉴입니다")' value="관심상품"></button>
               		</c:when>

               		<c:otherwise>
                 	<input type="button" style="width:85px; padding : 13px 10px; margin : 0 5px;" onclick='go_to_cart(${pvo.product_no}, "${sessionScope.loggedin}", ${pvo.stock}, ${pvo.sale_state});' value="장바구니"></button>
                  	<input type="button" style="width:85px; padding : 13px 10px; margin : 0 5px;" onclick='go_to_interest(${pvo.product_no}, "${sessionScope.loggedin}",${pvo.sale_state});' value="관심상품"></button>
               		</c:otherwise>	

               		</c:choose>
                 
                  <input type="button" 
                  <c:if test="${not empty sessionScope.admin}">onclick='go_to_order(true, "${sessionScope.loggedin}", ${pvo.stock}, ${pvo.sale_state});'</c:if>
				  <c:if test="${empty sessionScope.admin}">onclick='go_to_order(false, "${sessionScope.loggedin}", ${pvo.stock}, ${pvo.sale_state});'</c:if>
                  style="width:85px; padding : 13px 10px; margin : 0.5px; background-color : #000000" value="바로구매" >
                 
                  </td>
               </tr>
                  <!-- 서브밋 시 가져갈 것들 -->
                  <input type="hidden" name="product_no" value="${pvo.product_no}">
                  <input type="hidden" name="product_name" value="${pvo.product_name}">
                  <input type="hidden" name="represent_img" value="${pvo.represent_img}">
                  <input type="hidden" name="cost_price" value="${pvo.selling_price}">
                  ${SessionScope.loggedin}
               </form>
            </table>
         </div>
         
         <p>상품설명</p>
         <div>
            <img id="soap_desc" src="/soap/resources/product_images/${pvo.detail_img}" alt="${pvo.product_name}설명"/>
            <span>${pvo.detail_ex}</span>
         </div>

         <p>배송정보</p>
         <div>
            <img src="/soap/resources/images/info_delivery.jpg" alt="배송정보"/>
         </div>
         
         <input type="hidden" id="add_c" value="${param.add_c}"/>
         <input type="hidden" id="add_i" value="${param.add_i}"/>
         
         <%@ include file="../board/review/_review.jsp" %>
      </div>
      <!--------------------------------------------------end content--------->
   </div><!--end container-->


   <footer>
      <%@include file="../_default_footer.jsp" %>
   </footer>

   <script type="text/javascript">
      $(function(){
    	 
    	 if($("#add_i").val() == "ok") {
   		  	  if(confirm("관심상품이 등록되었습니다\n관심상품을 확인하시겠습니까?")){
   		  		  location.href="/soap/interest.nm"
   		  	  } 
   		  	  
    	 } else if($("#add_i").val() == "dup") {
   		  	  alert("이미 등록된 관심상품입니다");
    		 
    	 }
    	 if($("#add_c").val() == "ok") {
  		  	  if(confirm("장바구니에 상품이 등록되었습니다\n장바구니를 확인하시겠습니까?")){
  		  		  location.href="/soap/cart.nm"
  		  	  } 
  		  	  
   	 	} 
    	 //////////////////////////////////////////////
    	 
         var selling_price = $("#selling_price").html();
         console.log("판매가 : "+selling_price);
         
         var purchase_count = $("#purchase_count").val();
         console.log("개수 : "+purchase_count);
         
         var total_price = selling_price * purchase_count;
         console.log("총계 : "+ total_price);
         
         $("#purchase_count").change(function(){
            total_price = selling_price * $(this).val();
            $("#total_price").html(total_price);
            console.log("총계 : "+ total_price);
         });
         
         if($("#back_cart").val() != null && $("#back_cart").val() != "")
         		alert($("#back_cart").val());
         
         if($("#back_interest").val() != null && $("#back_interest").val() != "")
         		alert($("#back_interest").val());
         
      })
      function go_to_cart(cart_poductno, loggedin, stock, sale_state){
    	  console.log("loggedin : "+loggedin);
    	  console.log("stock : "+stock);
    	  console.log("sale_state : "+sale_state);
    	  if(loggedin == null || loggedin == ""){
		    	alert("장바구니에 추가하려면 로그인이 필요합니다");
	    		location.href="/soap/login.nm";
    	  } else if(sale_state == 0){
				alert("품절된 상품입니다");    		  
    	  } else if($("#purchase_count").val() > stock){
    			alert("상품 재고가 부족해서 장바구니에 추가할 수 없습니다"); 	
    	  } else {
			     location.href="/soap/cart/add_proc.nm?c_pn="+cart_poductno+"&c_bn="+$("#purchase_count").val();
    	  } 
      }
       
      function go_to_interest(interest_poductno, loggedin, sale_state){
    	  console.log(loggedin);

    	  if(loggedin == null || loggedin == ""){
		    	alert("관심상품에 추가하려면 로그인이 필요합니다");
	    		location.href="/soap/login.nm";
    	  } else if(sale_state == 0){
				alert("품절된 상품입니다");    		  
    	  } else {
			    location.href="/soap/interest/add_proc.nm?i_pn="+interest_poductno;
    	  } 
      } 
      function go_to_order(admin, loggedin, stock, sale_state){
    	  if(admin == true){
    		  alert("회원만 구매 가능합니다.");
    	  }else if(loggedin == null || loggedin == ""){
    		  alert("주문시 로그인이 필요합니다.")
    	  }else if(stock <= 0 || sale_state == 0){
    		  alert("품절된 상품입니다.");
    	  }else{
    		  document.cart_form.submit();
    	  }
      }

   </script>

  </body>
</html>