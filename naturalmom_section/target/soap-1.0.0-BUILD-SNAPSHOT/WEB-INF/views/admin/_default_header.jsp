<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<!--관리자 정보메뉴-->
		<nav id = "admin_info_menu">
			<ul>
				<li><a href="<c:url value = '/index.nm' />">프론트페이지</a></li>
				<li><a href="<c:url value = '/admin/edit.nm' />">정보 수정</a></li>
				<li><a href="<c:url value = '/index.nm' />" onclick="logout()">로그아웃</a></li>
			</ul>
			<h3>관리자 모드입니다.</h3>
		</nav>

		<!--관리메뉴-->
		<nav id = "admin_menu">
		<ul>
			<li>
				<a href="<c:url value = '/admin/product.nm' />">상품</a>
				<div id="sub">
					<ul>
						<li><a href="<c:url value = '/admin/product.nm?page=register' />">상품등록</a></li>
						<li><a href="<c:url value = '/admin/product.nm?page=manage' />">상품관리</a></li>
						<li><a href="<c:url value = '/admin/product.nm?page=deleted' />">삭제상품</a></li>
					</ul>
				</div>
			</li>
			<li><a href="<c:url value = '/admin/order.nm' />">주문</a></li>
			<li><a href="<c:url value = '/admin/member.nm' />">회원</a></li>
			<li>
				<a href="<c:url value = '/admin/board/notice.nm' />">게시판</a>
				<div id="sub">
					<ul>
						<li><a href="<c:url value = '/admin/board/notice.nm' />">공지사항</a></li>
						<li><a href="<c:url value = '/admin/board/event.nm' />">이벤트</a></li>
						<li><a href="<c:url value = '/admin/board/qna.nm' />">Q&A</a></li>
						<li><a href="<c:url value = '/admin/board/review.nm' />">상품후기</a></li>
						<li><a href="<c:url value = '/admin/board/faq.nm' />">자주하는 질문</a></li>
					</ul>
				</div>
			</li>
			<li>
				<a href="<c:url value = '/admin/sales.nm' />">매출</a>
				<div id="sub">
					<ul>
						<li><a href="<c:url value = '/admin/sales.nm?page=table' />">매출 조회</a></li>
						<li><a href="<c:url value = '/admin/sales.nm?page=analysis' />">매출 분석</a></li>
					</ul>
				</div>
			</li>
		</ul>
		</nav>
<!------------------------------------------------------------------------Script -->
<script type="text/javascript">
	function logout() {
		
	}
</script>		
		
</html>




