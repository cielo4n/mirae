<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <script src="/soap/resources/js/jquery-1.11.3.min.js"></script>
   <!-- [if lt IE 9]><script src="/soap/resources/js/html5shiv.js"></script><![endif] -->
   
   <link rel="apple-touch-icon" href="/soap/resources/images/logo.ico" /> <!--애플아이콘등록-->
   <link rel="shortcut icon" href="/soap/resources/images/logo.ico" /> <!--단축키아이콘등록-->
   <link rel="stylesheet" href="/soap/resources/css/index.css"/>
      
   <title>자연맘</title>
   
   <style type="text/css">
   		#stock { font-size : 14px; }
   </style>
   
   </head>
   <body>

   <header>
      <%@include file="_default_header.jsp" %>
   </header>
	


   <div id="container">
      <%@include file="_default_menu.jsp" %>
      <!-------------Start content--------------------------------------------------->
      <div id="content">
      
      <!--본문 페이지-->
      <!--JSP로 구현해야 하는 부분-->
      <section>
         <p>상품종류 : ${category_name}</p>
         
         <c:forEach var="pl" items="${product_list}">
            <div>
            <a href="/soap/product/detail.nm?pdno=${pl.product_no}"><img src="/soap/resources/product_images/${pl.represent_img}" alt="${pl.product_name}"></a>
            <p><span>${pl.summary_ex}</span>&nbsp;${pl.product_name}</p>
            <p><fmt:formatNumber value="${pl.selling_price}" type="number"/>원</p>
            <p id="stock">
            
            <c:choose>
	            <c:when test ="${pl.stock <= 0 || pl.sale_state==0}">
	            	품절
	            </c:when>
	            <c:otherwise>
	            	판매중
	            </c:otherwise>
            </c:choose>
            
            </p>
            </div>
         </c:forEach>
         
      </section>
      </div>
      <!--------------------------------------------------end content--------->
      
      <!--회사이념-->
      <img id="info_naturalmom" src="/soap/resources/images/info_naturalmom.jpg">

      <!--기타배너 : 주문/회원/배송/계좌번호)-->
      <aside>
         <img src="/soap/resources/images/banner_order.jpg">
         <!-- 비회원 -->
		 <c:if test="${empty loggedin}">
        	 <a href="<c:url value='/join_term.nm'/>"><img src="/soap/resources/images/banner_membership.jpg"></a>
         </c:if>
         <!-- 회원 -->
         <c:if test="${not empty loggedin && empty admin}">
         	<a href="" onclick="preventJoin()"><img src="/soap/resources/images/banner_membership.jpg"></a>
         </c:if>
         <c:if test="${admin eq true}">
         	<a href="" onclick="preventAdmin()"><img src="/soap/resources/images/banner_membership.jpg"></a>
         </c:if>
         <a href="<c:url value='delivery.nm'/>"><img src="/soap/resources/images/banner_delivery.jpg"></a>
         <img src="/soap/resources/images/banner_account.jpg">
      </aside>
   </div>
   
<script type="text/javascript">
	
	function preventJoin() {
		alert('이미 자연맘의 회원입니다');
	}
	
	function adviceJoin() {
		alert('로그인 후 이용해주세요');
	}
	
	function preventAdmin() {
		alert('관리자 계정으로 접속 중입니다');
	}

</script>		
<!--------------------------------------------------------end container------------->
<!--Start footer---------------------------------------------------------------------->
   <footer>
      
      <%@include file="_default_footer.jsp" %>
      
   </footer>
<!-------------------------------------------------------------end footer----------->
  </body>
  
</html>