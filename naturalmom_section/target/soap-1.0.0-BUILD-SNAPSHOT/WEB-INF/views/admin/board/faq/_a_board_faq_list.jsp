<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<style type = "text/css">

		#container { width : 764px; margin : 50px auto; color: #85858d; }
		#container a { text-decoration: none; }
		#container a:hover { opacity : 0.7; }

		#container h2 { margin-bottom : 15px; color: #004523; }
		
		table { width: 100%; padding : 0px; }
		table tr:first-child td, table tr:last-child td { border-top : 1px solid grey; }
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
		#search input[type = "submit"], input[type = "button"]
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
			<tr>
				<td>1</td>
				<td><a href = "a_board.jsp?page=faq&r=1">배송비가 얼마인가요?</a></td>
			</tr>
			<td colspan = "2"><input type = "button" value = "글쓰기" id = "write" name = "write" onclick = "location.href='a_board.jsp?page=faq&w=true';"></td>
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