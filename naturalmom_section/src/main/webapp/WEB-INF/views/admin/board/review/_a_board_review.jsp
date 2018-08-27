<!-- admin_board.jsp - 게사판 - 상품후기 - 목록 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<style type = "text/css">

	#in 
	{ 
		font-family : "나눔바른고딕", "맑은 고딕";
		font-size : 16px;
		width : 800px;
		margin : 50px auto;
		color: #85858d; 
	}
	#in h2 { margin-bottom : 15px; color: #004523; }
	#in a { text-decoration : none; color : black; }
	#in #page a:hover { text-decoration : underline; }
	#in a:hover  { opacity : 0.7; }
		
	#review { width: 100%; padding : 0px; margin: 0 auto; }
	
	#review tr {border-top : 1px solid grey; }	
	#review tr th
	{
		color:white; 
		text-align:center; 
		background-color: #918686; 
		padding : 10px 5px;
		font-weight : normal;
	}
	
	#review tr td nth-child:(odd), #review tr td:(even) {border-top : 1px solid gray; }
	#review tr td 
	{ 
		padding : 8px 5px; 
		color: black;
		border-bottom : 1px solid lightgrey;
	}
	#review tr td:not(:nth-child(3)) { text-align:center; }

	#page { text-align : center; margin-top: 20px; margin-bottom: 15px; }
	#search { text-align:center; }
	#search input, #search select
	{
		font-size : 16px;
		font-family : "나눔바른고딕", "맑은 고딕";
	}
	
	#search input[id="btn_search"] 
	{
		padding : 5px 10px;
		margin-left : 3px;
		margin-right : 3px; 
		background-color : #85858D;
		color : white;
		font-family : "나눔바른고딕", "맑은 고딕";
		font-size : 16px;
		border-radius : 10px; 
		border : 0px;
	}
	
/* 	#review_write td { text-align : right; }
	#review_write input[type="button"] 
	{
		padding : 5px 30px; 
		background-color : #85858D;
		color : white;
		font-size : 16px;
		border-radius : 20px;
		border : 0px;
		margin-right : 5px;
		margin-top : 10px;
		margin-left : 10px;
	}
	#review_write input[type="button"]:hover,  */
	
	#search input[id="btn_search"]:hover { opacity : 0.7; }
	
</style>
 <div id ="in">
	<h2>상품 후기</h2>
	<table id = "review" cellspacing="0">
		<tr>
			<th style = "width:50px;">번호</th>
			<th style = "width:120px;">상품명</th>
			<th>제목</th>
			<th style = "width:100px;">작성자</th>
			<th style = "width:110px;">작성일</th>
			<th style = "width:90px;">만족도</th>
		</tr>
		<c:forEach var="review" items="${rvw_list}">
			<tr>
				<td>${review.review_no}</td>
				<td>${review.product_name}</td>
				<td>
					<a href="review_read.nm?&r=${review.review_no}">
						${review.rvw_title}&nbsp;<c:if test="${review.re_num > 0}">[${review.re_num}]</c:if>
					</a></td>
				<td>${review.mem_id}</td>
				<td><fmt:formatDate value="${review.rvw_write_day}" type = "date" /></td>
				<td>
					<c:forEach var="i" begin="0" end="5" step="1">
						<c:if test="${i < review.rvw_satisfaction}">
							<i class="fa fa-star" aria-hidden="true"></i>
						</c:if>
						<c:if test="${i > review.rvw_satisfaction}">
							<i class="fa fa-star-o" aria-hidden="true"></i>
						</c:if>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
		
		<c:if test="${empty rvw_list}" >
			<tr>
				<td colspan="6">검색 결과가 없습니다.</td>
			</tr>
		</c:if>
<!--	
		<tr id = "review_write">
			<td colspan="6">
			 <input type = "button" value = "글쓰기" onclick = "location.href='review.nm?w=true'"> 
			</td>
		</tr>
-->
	</table>
<!-- 페이지 부분 -->
		<div id = "page">
			<c:if test="${rp eq 1}">
				&lt;
			</c:if>
			<c:if test="${rp gt 1}">
				<a href="review.nm?page=${rp - 1}">&lt;</a>
			</c:if>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<c:forEach var = "i" begin="1" end="${all_pages}" step = "1">
				<c:if test="${rp == i}">
					<span>${i}</span>
				</c:if>
				<c:if test="${rp != i}">
					<a href="review.nm?page=${i}">${i}</a>
				</c:if>
			</c:forEach>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${rp eq all_pages}">
				&gt;
			</c:if>
			<c:if test="${rp lt all_pages}">
				<a href="review.nm?page=${rp + 1}">&gt;</a>
			</c:if>
		</div>
<!-- 검색 부분 -->
<script type="text/javascript">

	function search()
	{
		var option = document.getElementById("option").value;
		var search = document.getElementById("text_search").value;
//		alert("review_search.nm?option=" + option + "&search=" + search);
		location.href="review_search.nm?option=" + option + "&search=" + encodeURIComponent(search);
	}
</script>
		<div id = "search" >
			<select id = "option">
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="id">글쓴이</option>
				<option value="title_n_content">제목+내용</option>
			</select>
		 	<input type="text" placeholder="제목, 내용, 글쓴이, 제목+내용" name="search" id = "text_search">
			<input type="button" value="검색" onclick="search();" id ="btn_search">
		</div>
	</div>
</html>

