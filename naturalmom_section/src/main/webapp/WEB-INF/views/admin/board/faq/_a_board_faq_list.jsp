<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
	<style type = "text/css">
 
		#container { width : 764px; margin : 50px auto; color: #85858d; }
		#container a { text-decoration: none; }
		#container a:hover { opacity : 0.7; }

		#container h2 { margin-bottom : 15px; color: #004523; }
		
		table { width: 100%; padding : 0px; }
		table tr:first-child td { border-top : 1px solid grey; } 
		table tr td { padding : 10px; }
		table tr:not(:last-child) td:first-child { border-right: 1px solid lightgrey; }
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
		table tr:first-child td, table tr:not(:last-child) td:first-child { text-align: center; }
		table tr:first-child td:first-child { width: 50px; }
		table tr:last-child td { text-align: right; }

		.faq_write span
		{
			padding : 7px 20px;
			margin-left : 3px;
			margin-right : 3px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 20px; 
			border : 0px;
		}
		table a{ color: black; }
		
		#pages a { color: #85858d; }
		#pages a:hover { opacity : 0.7; }
		#pages, #search { text-align: center; }
		
		
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
		
		/* #search { width: 764px; }
		#search input[type = "text"], #search select { font : 16px "나눔바른고딕", "맑은 고딕", Arial; }
		#search input[type = "submit"], input[type = "button"]
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
		} */

		input[type = "submit"]:hover, input[type = "button"]:hover { opacity : 0.7; }
		#buttons tr td:last-child { text-align:right; } 
		
	</style>	
	
<!-- container 부분 -->
	<h2 id = "reg_title">자주하는 질문</h2>
		<table cellspacing = "0">
			<tr>
				<td id = "no">No</td>
				<td id = "title">Title</td>
			</tr>
		
		<c:forEach items="${faq_list}" var="fl">	
			<tr>
				<td>${fl.faq_rnum}</td>
				<td>
					<a href = "<c:url value="/admin/board/faq/read.nm?fr_no=${fl.faq_no}&rn=${fl.faq_rnum}"/>">
					${fl.faq_title}
					</a>
				</td>
			</tr>
		</c:forEach>
		
		<c:if test="${empty faq_list}" >
			<tr>
				<td colspan="2">검색 결과가 없습니다.</td>
			</tr>
		</c:if>
		
		<tr class="faq_write" style="text-align : right;">
			<td style="border : 0px solid blue; border-top : 1px solid lightgray;">
			</td>
			<td style="border : 0px solid blue; border-top : 1px solid lightgray;">
			<a href="/soap/admin/board/faq/add_form.nm"><br/>&nbsp;
			<span>글쓰기</span>
			</a>
			</td>
		</tr>
		
		<tr>
		<td colspan = "5">
		<div id = "pages">
		
		<c:if test="${pp>1}">
			<a href="<c:url value='/admin/board/faq/${pp-1}/list.nm'/>">
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
			<a href="<c:url value='/admin/board/faq/${pi}/list.nm'/>">
			<c:out value="${pi}"/>
			</a>
		</c:if>
		
		</c:forEach>
		
		<c:if test="${pp<total}">
			&nbsp;&nbsp;&nbsp;
			<a href="<c:url value='/admin/board/faq/${pp+1}/list.nm'/>">
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

	<script type="text/javascript">
		function searchKeyword(pp){
			kw = $("#kw").val();
			console.log("kw:"+kw);
			sch = $("#sch").val();
			console.log("sch:"+sch);
			location.href="/soap/admin/board/faq/"+pp+"/search.nm?sch="+sch+"&kw="+encodeURIComponent(kw)+"";
			//alert(decodeURIComponent(kw));
		}
	
	</script>
</html>