<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<style type = "text/css">

	#content_body { color: #85858d; padding: 100px; padding-left: 225px; }
	#content_body a { text-decoration: none; }
	#content_body a:hover { opacity : 0.7; }
	#content_body h2 { margin-bottom : 15px; color: #004523; }
	
	table, table input, div, div input { font-family : "나눔바른고딕", "맑은 고딕";}
	tr:not(:first-child) { font-size: 13px; color : black; }
	
	table { width: 720px; padding : 0px; }
	table tr:first-child td { border-top : 1px solid grey; }
	table tr:last-child td { border-bottom : 1px solid grey; }
	table tr td { padding : 10px; }
	table tr:last-child, td:first-child { border-right: 1px solid lightgrey; }
	table tr:not(:last-child) td
	{
		border-bottom : 1px solid lightgrey;
		margin : 0px;
	}

	table tr:first-child td
	{ 
		background-color: #918686; 
		color: white;
	}
	table tr:first-child td, table tr td:first-child { text-align: center; }
	table tr:first-child td:first-child { width: 50px; }

	table input[type = "button"]
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
	table a{ color: black; }

	#pages { margin-top: 15px; }
	#pages a { color: #85858d; }
	#pages a:hover { opacity : 0.7; }
	#pages, #search { text-align: center; }
	#search { width: 764px; margin-top: 20px; }
	#search input[type = "text"], #search select { font : 16px "나눔바른고딕", "맑은 고딕", Arial; }
	#search input[type = "button"]
	{
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
	
<!-- content_body 부분 -->	
	<h2 id = "reg_title">자주하는 질문</h2>
	<table cellspacing = "0">
		<tr>
			<td id = "no">번호</td>
			<td id = "title">제목</td>
		</tr>
	
	<c:forEach items="${faq_list}" var="fl">
		<tr>
			<td>${fl.faq_rnum}</td>
			<td><a href="<c:url value="/board/faq/read.nm?fr_no=${fl.faq_no}&rn=${fl.faq_rnum}"/>">${fl.faq_title}</a></td>
		</tr>
	</c:forEach>
	
	<c:if test="${empty faq_list}" >
		<tr>
			<td colspan="2">검색 결과가 없습니다.</td>
		</tr>
	</c:if>
		
	</table>
	
	<div id = "pages">
		
		<c:if test="${pp>1}">
			<a href="<c:url value='/board/faq/${pp-1}/list.nm'/>">
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
			<a href="<c:url value='/board/faq/${pi}/list.nm'/>">
			<c:out value="${pi}"/>
			</a>
		</c:if>
		
		</c:forEach>
		
		<c:if test="${pp<total}">
			&nbsp;&nbsp;&nbsp;
			<a href="<c:url value='/board/faq/${pp+1}/list.nm'/>">
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
		
	<script type="text/javascript">
		function searchKeyword(pp){
			kw = $("#kw").val();
			console.log("kw:"+kw);
			sch = $("#sch").val();
			console.log("sch:"+sch);
			location.href="/soap/board/faq/"+pp+"/search.nm?sch="+sch+"&kw="+encodeURIComponent(kw)+"";
			//alert(decodeURIComponent(kw));
		}
		
	</script>
		
</html>