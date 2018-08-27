<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style type = "text/css">
		#content_body { 
					font-family : "나눔바른고딕", "맑은 고딕";
					padding-top : 20px; padding-left: 110px;
					margin : 30px auto; color: #85858d; }
		#content_body a { text-decoration: none; }
		#content_body a:hover { opacity : 0.7; }

		h2 { margin-bottom : 15px; font-size: 24px; color: #004523;}
		
		table { width : 720px; font-size: 13px; }
		table tr:first-child td, table tr:last-child td { border-top : 1px solid grey; }
		table tr td { padding : 10px; }
		table tr:not(:last-child) td:first-child { border-right: 1px solid lightgrey; }
		table tr:not(:last-child) td
		{
			border-bottom : 1px solid lightgrey;
			margin : 0px;
		}
		table tr:not(:first-child) td:not(:nth-child(2)) {text-align: center;}
		table tr:first-child td
		{ 
			background-color: #918686; 
			color: white;
		}
		table tr:first-child td, table tr:not(:last-child) td:first-child { text-align: center; }

		table tr:last-child td { text-align: right; }

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
		

		#pages { margin-top: 15px;}

		#pages a { color: #85858d; font-size: 18px; }
		#pages a:hover { opacity : 0.7; }
		#pages, #search { text-align: center; width: 720px;}
		#search { width: 764px; margin-top: 20px; }
		#search input[type = "text"], #search select { font : 16px "나눔바른고딕", "맑은 고딕", Arial; }
		#search input[type = "submit"],#write
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

		input[type = "submit"]:hover, #write:hover { opacity : 0.7; }
		#buttons tr td:last-child { text-align:right; }
	</style>

<div id="content_body">
	<form action="" >
		<h2 id = "reg_title">이벤트</h2>
		<table cellspacing = "0">
			<tr>
				<td width="8%">번호</td>
				<td width="50%" >제목</td>
				<td width="15%">작성자</td>
				<td width="17%">작성일</td>
				<td width="8%">조회</td>
			</tr>
			
		<!-- -- List -- -->
		<c:forEach var="e" items="${e_list}">
			<tr>
				<td id = "no">${e.evt_rnum}</td>
				<td><a href = "event_read.nm?r=${e.event_no}&rn=${e.evt_rnum}&d=0">
						${e.evt_title} 
						<c:if test="${e.count_re > 0}">
							<b>[${e.count_re }]</b>
						</c:if> 
						</a></td>
				<td id = "id" >${e.mem_id}</td>
				<td id = "write_day" >${e.evt_write_day}</td>
				<td id = "hits" >${e.evt_hits}</td>
				<td id = "realno" style="display: none">${e.event_no}</td>
			</tr>
		</c:forEach>	
		<c:if test="${empty e_list}">
			<tr>
				<td colspan="5" style="text-align: center; font-size: 15px; padding: 20px">
					해당 검색 내용이 없습니다.</td>
			</tr>
		</c:if>
		
			<tr>
		<c:if test="${not empty loggedin}">
				<td colspan="5" style="text-align: right">
					<a id = "write" name = "write" 
						href="event.nm?w=true">글쓰기</a>
				</td>
		</c:if>
			</tr>
		</table>
		
		
		<!-- -- page -- -->
		<div id = "pages">
			<c:if test="${page gt 1 }">
				<a href ="event.nm?page=${page-1}">&lsaquo;</a>
			</c:if>
			<c:if test="${page eq 1 }">
				<a>&lsaquo;</a>
			</c:if>
			&nbsp;&nbsp;&nbsp;
			<c:forEach begin="1" end="${total_page}" step="1" var="m">
			&nbsp;
				<c:if test="${m eq page}">
					<a><b><c:out value="${m}"></c:out></b></a>
				</c:if>
				<c:if test="${m ne page}">
					<a href="event.nm?page=${m}"><c:out value="${m}"></c:out></a>
				</c:if>
			</c:forEach>
			&nbsp;&nbsp;&nbsp;
			<c:if test="${page lt total_page}">
				<a href="event.nm?page=${page+1 }">&rsaquo;</a>
			</c:if>	
			<c:if test="${page eq total_page}">
				<a>&rsaquo;</a>
			</c:if>	
		</div>
		<div id = "search" style="margin-bottom: 80px;">
			<select id = "option" name="by">
				<option>제목</option>
				<option>내용</option>
				<option>제목+내용</option>
			</select>
			<input type = "text" name = "search" />
			<input type = "submit" value = "검색" />
		</div>
	</form>
</div>

</html>