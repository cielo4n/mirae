<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<style type="text/css">
		table a { text-decoration : none; color : black; }
		table a:hover  { opacity : 0.7; }
		table, table input, div, div input { font-family : "나눔바른고딕", "맑은 고딕";}
		table { width : 720px; }
		h2 { color : #004523; text-align : left; padding-top : 20px; }
		th { background-color : #918686;  font-weight : normal; color : white; 
			border-top : solid 1px lightgray; }
		td, th { padding : 10px; }
		td:not(:nth-child(2)) { text-align: center; }
		td:not(:first-child) { font-size: 13px; }
		td, th{ 
			border-bottom : solid 1px lightgray; 
		}
		td:not(:last-child), th:not(:last-child){ 
			border-right : solid 1px lightgray;
		}
		
		tr:first-child td, tr:last-child td, .qna_write td{ border-bottom : 0px; }
		th { border-top : 1px solid gray; }
		.qna_write span {
			display : inline-block;
			padding : 5px 30px; 
			background-color : #85858D;
			color : white;
			font-size : 16px;
			border-radius : 20px;
			border : 0px;
			margin-right : 5px;
			margin-top : 10px;
			margin-left : 10px;
		}
		.qna_write input[type="submit"]:hover {
			opacity : 0.7;
		}
		.qna_write td {
			text-align : right;
		}
		table { margin : 0 auto;  }
		.page { text-align : center; margin-bottom: 15px;}
		
		.search input[type="submit"]{
			padding : 2px 10px;
			margin-left : 3px;
			margin-right : 3px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 10px; 
			border : 0px;
		}
	</style>
</head>
<body>
<form>
<table cellspacing="0">
	<tr><td colspan="5"><h2>Q&A</h2></td></tr>
	<tr>
		<th width="50px;">번호</th>
		<th>제목</th>
		<th width="100px">작성자</th>
		<th width="100px">작성일</th>
		<th width="50px">조회</th>
	</tr>
	<tr>
		<td>3</td>
		<td><a href="customer_center.jsp?page=qna&r=3">재입고 언제 되나요</a></td>
		<td>hook4u</td>
		<td>2015/06/17</td>
		<td>49</td>
	</tr>
	<tr>
		<td>2</td>
		<td><a href="customer_center.jsp?page=qna&r=2">배송일 문의 [1]<span>&nbsp;<i class="fa fa-lock"></i></span></a></td>
		<td>faith5c</td>
		<td>2015/06/15</td>
		<td>24</td>
	</tr>
	<tr>
		<td>1</td>
		<td><a href="#">배송문의 [1]</a></td>
		<td>xhdydlf</td>
		<td>2015/06/15</td>
		<td>15</td>
	</tr>
	<tr class="qna_write">
		<td colspan="5" style="border-top: 1px solid grey"><a href="customer_center.jsp?page=qna&w=true"><span>글쓰기</span></a></td>
	</tr>
	<tr>
		<td colspan = "5">
		<div class="page">
			<a href="#">〈</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#">〉</a>
		</div>
		<div class="search">
				<select>
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="writer">글쓴이</option>
					<option value="title+content">제목+내용</option>
				</select>
				<input type="text" placeholder="제목, 내용, 글쓴이, 제목+내용" name="search">
				<input type="submit" value="검색">
		</td>
	</div>	
	</tr>
	
</table>
	
</form>

</body>
</html>