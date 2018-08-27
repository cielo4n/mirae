<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="/soap/resources/js/nicEdit.js"></script>
	<script type="text/javascript">
		bkLib.onDomLoaded(function(){
			new nicEditor({maxHeight:300}).panelInstance('qna_area')
		});
	</script>	
	
	<style type="text/css">
		h2 { color: #004523; padding-top : 20px;}
		td:first-child { padding : 10px; }
		th { background-color : #918686;  
			font-weight : normal; 
			color : white;
			border : solid 1px #cccccc;
			font-size: 13px;
		}
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
		table tr:last-child td { text-align : right; }
		table { margin : 0 auto; }
		table { width : 720px; }
	</style>
	
	
	<form action="/soap/admin/board/qna/edit_proc.nm" method="post">
	<table cellspacing="2">
		<tr><td colspan="2"><h2>Q&A</h2></td></tr>
		<tr>
			<th style="width:80px;"><label for="title">제목</label></th>
			<td>
			<input type="text" name="title" style="width:99%;" id="title" maxlength="127" value="${qvo.qna_title}" required="required"/>
			</td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="writer" maxlength="15" style="width:20%" value="${qvo.mem_id}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="password" maxlength="15" style="width:20%" value="${qvo.qna_pw}"/>
				
				<c:choose>
					<c:when test="${not empty qvo.qna_pw}">
						<input type="checkbox" name="secret_check" id="secret" name="secret" checked="checked"/>
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="secret_check" id="secret" name="secret"/>
					</c:otherwise>
				</c:choose>
				
				<label for="secret" style="font-family : '나눔바른고딕'; font-size : 0.9em;" >비밀글 여부</label>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<textarea id="qna_area" style="width:100%; resize:none;" rows="14">${qvo.qna_content}</textarea>
			<input type="hidden" name="content" id="qna_content"/>
			<input type="hidden" name="qe_no" value="${qvo.qna_no}"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type=submit value="확인" onclick = "editQna()">
 				<input type=button value="취소" onclick = "location.href='/soap/admin/board/qna.nm';">
			</td>
		</tr>
	</table>
	</form>
</body>

<script type="text/javascript">
	
	function editQna(){
		var content = nicEditors.findEditor('qna_area').getContent();
		//alert(content);
		$("#qna_content").val(content);
		//alert($("#qna_content").val());
	}
</script>
</html>