<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<script type="text/javascript" src="js/nicEdit.js"></script>
	<script type="text/javascript">
		bkLib.onDomLoaded(function(){
			new nicEditor({maxHeight:300}).panelInstance('qna_area')
		});
	</script>	
	
	<style type="text/css">
		h2, th, table tr:last-child input { font-family : "나눔바른고딕", "맑은 고딕"; }
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
	
	
	
	<form action="#" method="post">
	<table cellspacing="2">
		<tr><td colspan="2"><h2>Q&A</h2></td></tr>
		<tr>
			<th style="width:80px;"><label for="title">제목</label></th>
			<td>
			<input style="width:99%;" type="text" id="title" maxlength="127" placeholder="제목을 입력하세요"/>
			</td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" maxlength="15" style="width:30%" value="hook4u" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" maxlength="15" style="width:30%"/>
				<input type="checkbox" id="secret" name="secret">
				<label for="secret" style="font-family : '나눔바른고딕'; font-size : 0.9em;" >비밀글 여부</label>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<textarea id="qna_area" name="text" style="width:100%; resize:none;" rows="14"></textarea>
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
</body>
</html>