<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<style type = "text/css">

		#container { width : 764px; margin : 50px auto; color: #85858d; }
		#container a { text-decoration: underline; }

		#container h2 { margin-bottom : 15px; color: #004523;}
		
		table { width: 100%; padding : 0px; }
		#board tr:last-child td { border-bottom : 1px solid lightgrey;}
		#board tr td { padding : 10px; }
		#board tr:first-child td:first-child { border-right: 1px solid lightgrey; }
		#board tr:not(:last-child) td
		{
			border-bottom : 1px solid lightgrey;
			margin : 0px;
		}

		#board tr:first-child td
		{ 
			background-color: #918686; 
			color: white;
		}
		#board tr:first-child td:first-child
		{ 
			width: 50px;
			text-align: center;
		}

		#buttons { width: 100%; margin-top: 20px; }
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

		#buttons tr td:last-child { text-align:right; }
	</style>

<!-- container 부분 -->
	<h2 id = "reg_title">자주하는 질문</h2>
			<table cellspacing = "0" id = "board">
				<tr>
					<td id = "no">1</td>
					<td id = "title">임시 타이틀</td>
				</tr>
				<tr><td colspan = "2" id = "content">임시 자주하는 질문 내용입니다.</td></tr>
			</table>
			<table cellspacing = "0" id = "buttons">
				<tr>
					<td>
						<input type = "button" value = "이전글" id = "prev" name = "prev">
						<input type = "button" value = "다음글" id = "next" name = "next">
					</td>
					<td>
						<input type = "button" value = "수정" id = "mod" name = "mod">
						<input type = "button" value = "삭제" id = "del" name = "del">
						<input type = "button" value = "목록" id = "list" name = "list" onclick = "go_page('list');">
					</td>
				</tr>
			</table>
<script type="text/javascript">
	function go_page(val)
	{
		if (val == 'list')
			location.href = "a_board.jsp?page=faq";
	}
</script>
</html>