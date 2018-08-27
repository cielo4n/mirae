<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<style type = "text/css">

		#content_body { color: #85858d; padding: 100px; padding-left: 225px; }
		#content_body a { text-decoration: none; }
		#content_body a:hover { opacity : 0.7; }

		#content_body h2 { margin-bottom : 15px; color: #004523; }
		
		table { width: 720px; padding : 0px; }
		table tr:first-child td { border-top : 1px solid grey; }
		table tr:last-child td { border-bottom : 1px solid grey; }
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
		#search input[type = "submit"]
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

		input[type = "submit"]:hover { opacity : 0.7; }
	</style>
	
<!-- content_body 부분 -->	
	<h2 id = "reg_title">자주하는 질문</h2>
		<table cellspacing = "0">
			<tr>
				<td id = "no">번호</td>
				<td id = "title">제목</td>
			</tr>
			<tr>
				<td>1</td>
				<td><a href = "customer_center.jsp?page=faq&r=1">배송비가 얼마인가요?</a></td>
			</tr>
		</table>
		<div id = "pages">
			<a href = "#">&lsaquo;</a>
			&nbsp;&nbsp;&nbsp;
			1
			&nbsp;&nbsp;&nbsp;
			<a href = "#">&rsaquo;</a>
		</div>
		<div id = "search">
			<form action = "#" method = "get">
				<select id = "option">
					<option>제목</option>
					<option>내용</option>
					<option>제목+내용</option>
				</select>
				<input type = "text" name = "search_val" />
				<input type = "submit" value = "검색" />
			</form>
		</div>
</html>