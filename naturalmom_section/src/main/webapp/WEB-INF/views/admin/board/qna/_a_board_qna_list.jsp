<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<style type="text/css">
		#container { width : 764px; margin : 40px auto;}
		table a { text-decoration : none; color : black; }
		table a:hover  { opacity : 0.7; }
		table, table input, div, div input { font-family : "나눔바른고딕", "맑은 고딕";}
		table { width : 100%; }
		h2 { color : #004523; text-align : left;}
		th { background-color : #918686;  font-weight : normal; color : white; 
			border-top : solid 1px lightgray; }
		td, th:not(first-child) { padding : 10px; }
		td:not(:nth-child(2)) { text-align: center; }
		td:not(:first-child) { font-size: 13px; }
		td, th{ 
			border-bottom : solid 1px lightgray; 
		}
		td:not(:last-child), th:not(:last-child){ 
			border-right : solid 1px lightgray;
		}
		
		tr:first-child td, tr:last-child td, .qna_write td{ border-bottom : 0px; }
		th { border-top : 1px solid gray; }
		.qna_write span {
			display : inline-block;
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
		.qna_write input[type="submit"]:hover {
			opacity : 0.7;
		}
		.qna_write td {
			text-align : right;
		}
		table { margin : 0 auto;  }
		.page { text-align : center; margin-bottom: 15px;}
		
		#search input[type="button"]{
			padding : 5px 10px;
			margin-left : 3px;
			margin-right : 3px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 20px; 
			border : 0px;
		}
		#search input[type = "text"], #search select { font : 16px "나눔바른고딕", "맑은 고딕", Arial; }
		input[type = "button"]:hover { opacity : 0.7; }
		#pages a:hover { text-decoration : underline; }
		
	</style>
</head>
<body>
<form>
<table cellspacing="0">
	<tr><td colspan="5"><h2>Q&A</h2></td></tr>
	<tr>
		<th width="50px;">글번호</th>
		<th>제목</th>
		<th width="100px">작성자</th>
		<th width="100px">작성일</th>
		<th width="50px">조회</th>
	</tr>
	
	<c:forEach items="${qna_list}" var="ql">
			<tr>
				<td>${ql.qna_rnum}</td>
				<td>
					<a href="<c:url value="/admin/board/qna/read.nm?qr_no=${ql.qna_no}&rn=${ql.qna_rnum}"/>">
					
					<c:forEach var="i" begin="1" end="${ql.qna_pos}" step="1">
						&nbsp;&nbsp;
					</c:forEach>
					
					<c:if test="${ql.qna_ref!=ql.qna_no}"><i class="fa fa-reply fa-rotate-180" aria-hidden="true"></i>&nbsp;</c:if>
					${ql.qna_title}
						<c:if test="${ql.qna_re_count!=0}">
							[${ql.qna_re_count}]
						</c:if>
					<c:if test="${ql.qna_pw != null}"><i class="fa fa-lock"></i></c:if>
					</a>
				</td>
				<td>
					<c:choose>
						<c:when test='${fn:containsIgnoreCase(ql.mem_id, "admin")}'>
							관리자
						</c:when>
						<c:otherwise>
							${ql.mem_id}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<fmt:formatDate value="${ql.qna_write_day}" pattern="yyyy/MM/dd"></fmt:formatDate>
				</td>
				<td>${ql.qna_hits}</td>
			</tr>
		</c:forEach>
		<c:if test="${empty qna_list}" >
			<tr>
				<td colspan="5">검색 결과가 없습니다.</td>
			</tr>
		</c:if>
	<tr class="qna_write">
		<td colspan="5" style="border-top: 1px solid grey">
		
		<c:if test="${sessionScope.loggedin!=null}">
		<a href="/soap/admin/board/qna/add_form.nm">
		<span>글쓰기</span>
		</a>
		</c:if>
		
		</td>
	</tr>
	<tr>
		<td colspan = "5">
		<div id = "pages">
		
		<c:if test="${pp>1}">
			<a href="<c:url value='/admin/board/qna/${pp-1}/list.nm'/>">
				〈
			</a>&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${pp==1}">
			〈 &nbsp;&nbsp;&nbsp;
		</c:if>
		
		<c:forEach var="pi" begin="1" end="${total}" step="1">
		
		<c:if test="${pi>1}">
			&nbsp;&nbsp;&nbsp;
		</c:if>
		
		<c:if test="${pi == pp}">
			<b><c:out value="${pi}"/></b>
		</c:if>
		
		<c:if test="${pi!=pp}">
			<a href="<c:url value='/admin/board/qna/${pi}/list.nm'/>">
			<c:out value="${pi}"/>
			</a>
		</c:if>
		
		</c:forEach>
		
		<c:if test="${pp<total}">
			&nbsp;&nbsp;&nbsp;
			<a href="<c:url value='/admin/board/qna/${pp+1}/list.nm'/>">
				 〉
			</a>
		</c:if>
		<c:if test="${pp==total}">
			&nbsp;&nbsp;&nbsp; 〉
		</c:if>
		
		<p>&nbsp;
		
		</div>
		
		<div id = "search">
			<select id="sch">
				<option value="tt">제목</option>
				<option value="con">내용</option>
				<option value="ttcon">제목+내용</option>
			</select>
			<input type = "text" name = "kw" id="kw"/>
			<input type = "button" value = "검색" onclick="searchKeyword(${pp})"/>
		</div>
		
	</tr>
	
</table>
	
</form>
	<script type="text/javascript">
		function searchKeyword(pp){
			kw = $("#kw").val();
			console.log("kw:"+kw);
			sch = $("#sch").val();
			console.log("sch:"+sch);
			location.href="/soap/admin/board/qna/"+pp+"/search.nm?sch="+sch+"&kw="+encodeURIComponent(kw)+"";
			//alert(decodeURIComponent(kw));
		}
	
	</script>
</body>
</html>