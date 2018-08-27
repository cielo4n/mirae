<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<section>
			<!--검색-->
			<p id="search_pc"><label for="find">search </label><input type="text" size = 10; id="find"><a href="#"><img src="<c:url value = '/resources/images/btn_search.gif' />"></a></p>
			
			<!--메인배너-->
			<div id = "main_banner"></div>

			<!--상품메뉴-->
			<nav id = "product_menu">
				<ul >
					<li id="product_menu_li_1"><a href="<c:url value ='/board/notice.nm' />">공지사항</a></li>
					<li id="product_menu_li_2"><a href="<c:url value ='/product1.nm' />">아토피/민감성/유아</a></li>
					<li id="product_menu_li_3"><a href="<c:url value ='/product2.nm' />">피부탄력/노화</a></li>
					<li id="product_menu_li_4"><a href="<c:url value ='/product3.nm' />">지성/여드름/트러블</a></li>
					<li id="product_menu_li_5"><a href="<c:url value ='/product4.nm' />">미백/피부톤개선</a></li>	
				</ul>
			</nav>
		</section>
</html>