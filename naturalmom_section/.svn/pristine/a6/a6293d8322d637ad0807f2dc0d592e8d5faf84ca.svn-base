<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<script type="text/javascript" src="../js/nicEdit_inBoard.js"></script>
	<script type="text/javascript">
	</script>	
	<script type="text/javascript">
		bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
	</script>
	<style type="text/css">
		#container { width : 764px; margin : 50px auto;}
		h2, th, table tr:last-child input { font-family : "나눔바른고딕", "맑은 고딕"; }
		h2 { color: #004523;}
		td:first-child {  padding-top : 10px; padding-bottom : 10px; }
		th { background-color : #918686;  
			font-weight : normal; 
			color : white;
			border : solid 1px #cccccc;
			font-size: 13px;
			}
		table tr:last-child input 
		{	
			padding : 4px 30px;
			margin-right : 5px;
			margin-top : 10px;
			margin-left : 10px; 
			background-color : #85858D;
			color : white;
			font-size : 16px;
			border-radius : 20px;
			border : 0px;
		}
		table tr:last-child input:hover { opacity : 0.7; }
		table tr:last-child td { text-align : right; }
		table { margin : 0 auto; }
		table { width : 100%; }
	</style>
	<form action="#" method="post">
	<table cellspacing="2">
		<tr><td colspan="2"><h2>공지사항</h2></td></tr>
		<tr>
			<th style="width:100px;"><label for="title">제목</label></th>
			<td>
			<input style="width:100%;" type="text" id="title" maxlength="127" placeholder="제목을 입력하세요"/>
			</td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" maxlength="15" style="width:30%" value="관리자" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<textarea id="qna_area" name="text" style="width:100%; cols="74" rows="14"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type=submit value="확인">
				<input type=button value="취소">
			</td>
		</tr>
	</table>
	</form>
</html><!-- 이상이상 -->