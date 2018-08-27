<!-- 사용자 - 게시판 - 상품후기 - 글쓰기 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="../js/nicEdit_inBoard.js"></script>
<script type="text/javascript">
	bkLib.onDomLoaded(function(){
		new nicEditor({maxHeight:300}).panelInstance('review_write')
	});
	
	function viewContent()
	{
		var write = nicEditors.findEditor('review_write').getContent();
		alert(write);
	}
</script>	
	
<style type="text/css">
	
	#in { font-family : "나눔바른고딕", "맑은 고딕"; }
	#in { width : 764px; margin : 50px auto; }
	#in h2 { color: #004523; margin-bottom : 15px; }
	
	table { width : 100%; margin : 0 auto; }
	table tr td:first-child { width : 100px; }
	table tr:not(:last-child) td:first-child
	{ 
		padding: 8px 10px;
		background-color : #918686;  
		font-weight : normal; 
		color : white;
		border : solid 1px #cccccc;
		font-size: 16px;
		text-align : right;
	}
	
	table tr:first-child td:last-child input { width : 99%; }
	table tr:nth-child(2) td:last-child input { width : 30%; }
	table tr:nth-child(3) td:last-child textarea { width : 100%; resize: none; }
	
	table tr td:last-child input
	{
		font-family : "나눔바른고딕", "맑은 고딕"; 
		font-size : 16px;
	}
	
	table tr:last-child td { text-align : right; }
	table tr:last-child input { font-family : "나눔바른고딕", "맑은 고딕"; font-size : 16px; }
	
	table tr:last-child input 
	{	
		padding : 5px 30px;
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

</style>
	
<div id="in">
	<h2>상품 후기 - 글쓰기</h2>
	<form action="#" method="post">
	<table cellspacing="2">
		<tr>
			<td>
				<label for="title">제목</label>
			</td>
			<td>
				<input type="text" id="title" maxlength="127" placeholder="제목을 입력하세요"/>
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>
				<input type="text" maxlength="12" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea id="review_write" name="text" cols="74" rows="15"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick = "viewContent();">
			</td>
		</tr>
	</table>
	</form>
</div>
</html>