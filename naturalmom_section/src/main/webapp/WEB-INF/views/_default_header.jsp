<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>




<script src="/soap/resources/js/jquery-1.11.3.min.js"></script>

<!--유저메뉴-->
		<nav id = "user_menu_pc">
			<ul>
				<c:if test="${not empty admin and admin eq true }">
				<li><a href="<c:url value = '/admin/product.nm' />">관리자모드</a></li>
				</c:if>
				
				<!-- 비회원 -->
				<c:if test="${empty loggedin}">
				<li><a href="<c:url value = '/board/notice.nm' />">고객센터</a></li>
				<li><a href="<c:url value = '/login.nm' />" onclick="adviceJoin()">마이페이지</a></li>
				<li><a href="<c:url value = '/login.nm' />" onclick="adviceJoin()">주문조회</a></li>
				<li><a href="<c:url value = '/login.nm' />" onclick="adviceJoin()">장바구니</a></li>
				<li><a href="<c:url value = '/join_term.nm'/>"> 회원가입</a></li>
				<li><a href="<c:url value = '/login.nm' />">로그인</a></li>
				</c:if>
				
				<!-- 회원 -->
				<c:if test="${not empty loggedin && empty admin}">
				<li><a href="<c:url value = '/board/notice.nm' />">고객센터</a></li>
				<li><a href="<c:url value = '/mypage.nm' />">마이페이지</a></li>
				<li><a href="<c:url value = '/orderlist.nm' />">주문조회</a></li>
				<li><a href="<c:url value = '/cart.nm' />">장바구니</a></li>
				<li><a href="" onclick="preventJoin()"> 회원가입</a></li>
				<li><a href="<c:url value = '/logout_proc.nm' />">로그아웃</a></li>
				</c:if>
				
				
				<c:if test="${admin eq true}">
				<li><a href="<c:url value = '/board/notice.nm' />">고객센터</a></li>
				<li><a href="" onclick="preventAdmin()">마이페이지</a></li>
				<li><a href="" onclick="preventAdmin()">주문조회</a></li>
				<li><a href="" onclick="preventAdmin()">장바구니</a></li>
				<li><a href="" onclick="preventAdmin()"> 회원가입</a></li>
				<li><a href="<c:url value = '/logout_proc.nm' />">로그아웃</a></li>
				</c:if>
			</ul>
		</nav>

		<!--로고-->
		<a href="<c:url value = '/index.nm' />">
			<img id="logo" src="<c:url value = '/resources/images/logo_gray.gif' />" alt="로고">
		</a>
		
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
