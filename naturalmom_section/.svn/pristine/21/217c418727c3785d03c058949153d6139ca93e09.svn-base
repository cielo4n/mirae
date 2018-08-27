<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<script type="text/javascript" src="../js/nicEdit_inBoard.js"></script>
	<script type="text/javascript">
		bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
	</script>
	<style type = "text/css">

		#container { width : 764px; margin : 50px auto; color: #85858d; }
		#container a { text-decoration: underline; }

		#container h2 { margin-bottom : 15px; color: #004523;}
		
		table { width: 100%; padding : 0px; }
		table tr:first-child td, table tr:last-child td { border-top : 1px solid grey; }
		table tr:not(:last-child) td:first-child { border-left : 1px solid grey; }
		table tr:not(:last-child) td:last-child { border-right : 1px solid grey; }
		table tr td { padding : 10px; }
		table tr:not(:last-child) td
		{
			border-bottom : 1px solid lightgrey;
			margin : 0px;
		}

		table tr:first-child td:first-child, table tr:nth-child(2) td 
		{ 
			background-color: #918686; 
			color: white;
		}
		table tr:first-child td:first-child, table tr:nth-child(2) td:first-child
		{ 
			width: 200px;
			text-indent: 15px;
		}
		table tr:first-child td input[type = "text"]
		{
			font : 16px "나눔바른고딕", "맑은 고딕", Arial;
			border: 1px solid lightgrey;
			width: 95%;
		}
		table tr:nth-child(3) td textarea
		{
			width: 100%;
			height: 400px;
		}
		
		#buttons { margin-top: 20px; text-align: right; }
		#buttons input
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
		#buttons input:hover { opacity : 0.7; }
	</style>

<!-- content 부분 -->
	<h2 id = "reg_title">글쓰기 - 자주하는 질문</h2>
		<form action = "#" method = "post">
			<table cellspacing = "0">
				<tr>
					<td><label for = "title">제목</label></td>
					<td><input type = "text" id = "title" name = "title" /></td>
				</tr>
				<tr>
					<td><label for = "content" id = "content">내용</label></td><td></td>
				</tr>
				<tr><td colspan = "2"><textarea name = "content" id = "content"></textarea></td></tr>
				<tr>
					<td colspan = "2" id = "buttons">
						<input type = "submit" value = "저장">
						<input type = "button" value = "취소" id = "cancel" name = "cancel" onclick = "location.href='a_board.jsp?page=faq';">
					</td>
				</tr>
			</table>
		</form>

</html>