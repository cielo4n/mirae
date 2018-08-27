<!-- 사용자 - 게시판 - 상품후기 - 상세보기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<style type="text/css">

	#container { width : 764px; margin : 50px auto; }
	#container h2 { color: #004523; margin-bottom : 15px; }
	
	table { width : 100%; margin : 0 auto; }
	table td { padding : 10px; }
	
	table tr:nth-child(1) td
	{ 
		text-align : center; 
		background: #918686;
		color : white; 
		border-right : solid 1px #cccccc;
		border-top : solid 1px #cccccc; 
		border-bottom : solid 1px #cccccc;
	}
	table tr:nth-child(2) td div
	{ 
		text-align : right; 
		color : gray; 
		font-size : 0.8em;
	}
	table tr:nth-child(3) td
	{ 
		border-bottom : solid 1px #CCCCCC; 
		padding : 10px 20px 30px 20px; 
	}
	table tr:last-child td:last-child { text-align : right; }
	
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
	
	.dat td { background-color : #F0F0F0; }
	.dat td:first-child { text-align : center; border-bottom : dotted 1px #cccccc; }
	.dat td:last-child { width : 120px; }
	.dat td { font-size : 0.9em; border-bottom : dotted 1px #cccccc; }

	.dat_write td:first-child { text-align : center; }
	.dat_write td
	{
		font-size : 0.9em;
		background-color : #F0F0F0;
		padding : 10px;	
	}
	.dat_write td textarea { font-family : "나눔바른고딕", "맑은 고딕"; }
	
	.dat span 
	{
		display : inline-block; 
		width: 20px; 
		text-align : right;
	}
	.dat span:hover { opacity : 0.7; }
	
	.dat_write input[type="submit"] 
	{
		background : #cec5ce;
		border-radius : 5px;
		color : #635353;
		border : none;
		border : 1px solid #85858d;
		padding : 5px; 
	}
	.dat_write input[type="submit"]:hover {	opacity : 0.7; }
	
</style>

<form action = "#" method = "post">
<h2>상품 후기</h2>

<table cellspacing = "0">
<!-- 제목 부분 -->
	<tr>
		<td>상품 번호: 52</td>
		<td>아마씨 비누</td>
		<td>향이 너무좋아요~</td>
		<td>★★★★☆</td>
	</tr>
<!-- 글쓴이 정보 -->
	<tr>
		<td colspan="4">
			<div>hook4u | 2016/06/17 | 조회수 24</div> 
		</td>
	</tr>
<!-- 내용 -->
	<tr>
		<td colspan = "4">
			향이 너무좋아요~~향이 너무좋아요~~향이 너무좋아요~~향이 너무좋아요~~향이 너무좋아요~~향이 너무좋아요~~
		</td>
	</tr>
<!-- 댓글 부분 -->
	<tr class = "dat">
		<td>자연맘</td>
		<td colspan="2">구매해주셔서 고맙습니다. ^^ </td>
		<td>
			2015/03/22
			<span onclick="location.href='#'"><i class="fa fa-times-circle"></i></span>
		</td>
	</tr>
	<tr class = "dat">
		<td>hook4u</td>
		<td colspan="2">또살게여~</td>
		<td>
			2015/07/19
			<span onclick="location.href='#'"><i class="fa fa-times-circle"></i></span>
		</td>
	</tr>
<!-- 댓글 쓰기 -->
	<tr class = "dat_write">
		<td>자연맘</td>
		<td colspan="2">
			<textarea style="width:100%; resize : none;" cols="30"></textarea>
		</td>
		<td>
			<input type="submit" style="padding : 2px 10px; " value="댓글등록">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="이전글">
			<input type="button" value="다음글">
		</td>
		<td colspan="2">
			<input type="button" value="삭제">
			<input type="button" value="목록" onclick = "location.href='a_board.jsp?page=review';">
		</td>
	</tr>
</table>
</form>
