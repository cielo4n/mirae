<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>

<style type="text/css">
	* { font-family : "나눔바른고딕", "맑은 고딕"}
	#container { width : 764px; margin : 40px auto;}
	h2 { color: #004523; }
	td, th:not(first-child) { padding : 10px; }
	td:first-child {padding-left: 0px;}
	tr:nth-child(2) th s{ background-color : blue; }
	
	table { width : 100%; 
		margin : 0 auto; 
	}
	tr:nth-child(2) th{ 
		text-align : center; 
		color : white; 
		font-weight : normal; 
		border-right : solid 1px #cccccc;
	}	
	tr:nth-child(2) th, tr:nth-child(2) td{ 
		border-top : solid 1px #cccccc; 
		border-bottom : solid 1px #cccccc;	
	}
	tr:nth-child(3) td div{ 
		text-align : right; color : gray; font-size : 0.8em;
	}
	tr:nth-child(4) td{ 
		border-bottom : solid 1px #CCCCCC; 
		padding : 10px 20px 30px 20px; 
	}
	.dat td{ background-color : #F0F0F0; }
	.dat td:first-child{ text-align : center; border-bottom : dotted 1px #cccccc; }
	.dat td{ font-size : 0.9em; border-bottom : dotted 1px #cccccc; }
	.dat_write td:first-child{ text-align : center;}
	.dat_write td{
		font-size : 0.9em;
		background-color : #F0F0F0;
		padding : 10px;
		
	}
	table tr:last-child input {
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
	
	table tr:last-child input:hover{
		opacity : 0.7;
	}
	.dat span {
		display : inline-block; 
		width:20px; 
		text-align : right;
	}
	.dat span:hover {
		opacity : 0.7;
	}
	
	.dat_write input[type="submit"] {
		background : #cec5ce;
		border-radius : 5px;
		color : #635353;
		border : none;
		border : 1px solid #85858d;
		padding : 5px; 
	}
	.dat_write input[type="submit"]:hover {
		opacity : 0.7;
	}
</style>

<body>
	<form action="/soap/admin/board/add_notice_reply_proc.nm" method="post">
		<table cellspacing="0">
			<tr>
				<td colspan="4"><h2>공지사항</h2></td>
			</tr>
			<tr style="background: #918686; color: white;">
				<th style="width: 80px;"><c:out value="${ no.notice_no }" /></th>
				<td colspan="3"><c:out value="${ no.ntc_title }" /></td>
			</tr>
			<tr>
				<td colspan="4">
					<div>
						관리자 |
						<fmt:formatDate value="${ no.ntc_write_day }" type="Date" />
						|
						<c:out value="${ no.ntc_hits }" />
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4">${ no.ntc_content }</td>
			</tr>
			<c:forEach var="re" items="${re_list}">
				<tr class="dat">
					<td><c:out value="${ re.mem_id }" /></td>
					<td colspan="2"><c:out value="${ re.ntc_re_content }" /></td>
					<td style="width: 120px;">
						<fmt:formatDate value="${ re.ntc_re_write_day }" type="Date" /> 
						<span onclick="location.href='notice_read.nm?r=${no.notice_no}&d=${re.notice_re_no}'">
							<i class="fa fa-times-circle"></i>
						</span>
					</td>
				</tr>

			</c:forEach>
			<c:if test="${not empty loggedin}">
				<tr class="dat_write">
					<td>${loggedin}</td>
					<td colspan="2">
						<textarea rows="2" cols="30" style="width: 100%" name="re_content"></textarea>
					</td>
					<td>
						<input type="submit" value="댓글등록">
					</td>
					<input type="hidden"  name="r" value="${ no.notice_no }">
				</tr>
			</c:if>

		</table>
	</form>
	<div id="buttonT">
	<form action="notice_edit.nm?w=true" method="post">
		<table>
			<td width="10%">
				<c:if test="${not empty prev}">
					<input type="button" value="이전글"
					onclick="location.href='/soap/admin/board/notice_read.nm?r=${prev}&d=0'">
				</c:if>
			</td >
			<td  width="10%">
				<c:if test="${not empty next}">
					<input type="button" value="다음글"
					onclick="location.href='/soap/admin/board/notice_read.nm?r=${next}&d=0'">
				</c:if>
			</td>
			<td width="50%">
			
			</td>
			<td width="10%">
				<input type="submit" value="수정">
			</td>
			<td width="10%">
				<input type="button" value="삭제"
				onclick="location.href='/soap/admin/board/notice_delete.nm?r=${ no.notice_no }'">
			</td>
			<td width="10%">
				<input type="button" value="목록"
				onclick="location.href='/soap/admin/board/notice.nm';">
			</td>
			
			<input type="hidden" id="title" name="title" value="${no.ntc_title}"/>
			<input type="hidden" id="content" name="content" value="${no.ntc_content}"/>
			<input type="hidden" id="r" name="r" value="${no.notice_no}"/>
			
		</table>
	</form>
</div>


</body>
</html>