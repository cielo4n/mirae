<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			new nicEditor({maxHeight:300}).panelInstance('faq_area')
		});
	</script>	
	
	<style type="text/css">
		#container { width : 764px; margin : 50px auto;}
		h2, th, table tr:last-child input { font-family : "나눔바른고딕", "맑은 고딕"; }
		h2 { color: #004523; }
		td:first-child { padding-left : 10px; padding-right : 10px; padding-bottom : 10px; padding-top : 0px; }
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
		table { width : 100%; }
	</style>
	
	
	<form action="/soap/admin/board/faq/add_proc.nm" method="post">
	<table cellspacing="2">
		<tr><td colspan="2"><h2>자주하는 질문</h2></td></tr>
		<tr>
			<th style="width:80px;"><label for="title">제목</label></th>
			<td><input type="text" name="title" style="width:99%;" id="title" maxlength="127" placeholder="제목을 입력하세요" required="required"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<textarea id="faq_area" style="width:100%; resize:none;" rows="14"></textarea>
			<input type="hidden" name="content" id="faq_content"  value="content"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type=submit value="확인" onclick = "addFaq()">
 				<input type=button value="취소" onclick = "location.href='/soap/admin/board/faq.nm';">
			</td>
		</tr>
	</table>
	</form>
</body>

<script type="text/javascript">
	function addFaq(){
		var content = nicEditors.findEditor('faq_area').getContent();
		//alert(content);
		$("#faq_content").val(content);
		//alert($("#faq_content").val());
	}
</script>
</html>