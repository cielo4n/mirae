<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type = "text/css">
		#container { width : 764px; margin : 50px auto;}
		#inside { color: #85858d; font-size: 14px; }
		#inside a { text-decoration: underline; }

		h2 { margin-bottom : 15px; font-size: 24px; color: #004523;}
		
		table { width: 720px; padding : 0px; }
		#board tr:first-child td { border-top : 1px solid grey; }
		#board tr:last-child td { border-bottom : 1px solid grey; }
		#board tr td:first-child { border-left : 1px solid grey;}
		#board tr td:last-child { border-right : 1px solid grey; }
		#board tr td { padding : 10px;}
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
			text-align: center;
		}

		#buttons { width: 720px; margin-top: 20px; }
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
		
		#event_content { height: 100px; vertical-align: top; color: black; }
		#re_submit { 
			padding: 15px 10px; 
			background-color: #85858d; 
			color : white;
			border-radius : 10px; 
		}
		.re_title{ width: 80px;}
		
	</style>
<html>
	<div id="inside">
		<h2 id = "reg_title">이벤트</h2>
			<table cellspacing = "0" id = "board">
				<tr>
					<td id = "no" width="15%">1</td>
					<td id = "title" width="55%" colspan="2" >임시 타이틀</td>
					<td id = "id" width="13%">작성자</td>
					<td id = "write_day" width="15%">2016-03-20</td>
					<td id = "hits" width="5%">조회</td>
				</tr>
				<tr><td colspan="6" id="event_content">임시 이벤트 내용입니다.</td></tr>
				<tr>
					<td id = "re_id" class="re_title">댓글작성자</td>
					<td id = "re_content" colspan="3" width="55%">댓글 내용입니다.</td>
					<td id = "re_write_day" colspan="2" style="text-align: right">댓글작성일</td>
				</tr>
				<tr>
					<td class="re_title">댓글입력</td>
					<td colspan="4"><textarea style="width:100%; resize : none;" cols="30" rows="3"></textarea></td>
					<td><input type = "button" value = "등록" id = "re_submit" name = "re_submit"></td>
				</tr>
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
						<input type = "button" value = "목록" id = "list" name = "list"  onclick = "location.href='a_board.jsp?page=event';">
					</td>
				</tr>
			</table>
	</div>
</html>