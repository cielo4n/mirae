<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자연맘 - 상품 후기 쓰기</title>

<script type="text/javascript" src="/soap/resources/js/nicEdit.js"></script>
<script src="/soap/resources/admin/js/jquery-1.11.3.min.js"></script>

<style type="text/css">
	
	#in { font-family : "나눔바른고딕", "맑은 고딕"; }
	#in { width : 764px; margin : 20px auto; }
	#in h2 { color: #004523; margin-bottom : 15px; margin-top: 0px; }
	
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
	table tr:nth-child(4) td:last-child textarea { width : 100%; resize: none; }
	
	table tr td:last-child input
	{
		font-family : "나눔바른고딕", "맑은 고딕"; 
		font-size : 16px;
	}
	
	table tr:last-child td { text-align : right; }
	table tr:last-child input, table tr textarea { font-family : "나눔바른고딕", "맑은 고딕"; font-size : 16px; }
	
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

</head>
<body>
<script type="text/javascript">
	bkLib.onDomLoaded(function()
	{
		new nicEditor({maxHeight:300}).panelInstance('rvw_content');
	});
	
	<% 
		String result = (String)request.getParameter("rst");
		if (result != null && result.equals("true")) {
	%>	write_result('true');
	<%  } else if (result != null && result.equals("false")) { %>
		write_result('false');
	<%  } else if (result != null && result.equals("login")) { %>
		write_result('login');
	<%  } %>

	function reg_review()
	{
		var f = document.reg_review_form;
		var title = $('#rvw_title').val();
		var content = nicEditors.findEditor('rvw_content').getContent();
			
		if (title == '')
		{
			alert('제목을 입력해주세요.');
			$('#rvw_title').focus();	
		}
		else if(content == '' || content == '<br>')
		{
			alert('내용을 입력해주세요.');
			$('#rvw_content').focus();		
		}
		else if(!f.rvw_satisfaction[0].checked &&
				!f.rvw_satisfaction[1].checked &&
				!f.rvw_satisfaction[2].checked &&
				!f.rvw_satisfaction[3].checked &&
				!f.rvw_satisfaction[4].checked)
		{
			alert('만족도를 선택해주세요');
			$('#s_1').focus();	
		}
		else
		{
			$('#rvw_content').val(content);
//			alert($('#rvw_content').val());
			document.reg_review_form.submit();
		}
	}
	
	function write_result(result)
	{
		if(result == 'true')
		{
			alert('상품 후기가 등록되었습니다.');
			opener.location.reload();
			self.close();
		}
		else if (result == 'false')
		{
			alert('상품 후기 등록에 실패하였습니다.');
			opener.location.reload();
			self.close();
		}
		else if(result == 'login')
		{
			alert('로그인 후 이용해주세요.');
			opener.location.href="/soap/login.nm";
			self.close();
		}
	}
	
</script>
<div id="in">
	<h2>상품후기 - 글쓰기</h2>
	<form action="reg_review_proc.nm" method="post" name = "reg_review_form">
	<table cellspacing="2">
		<tr>
			<td>
				<label for="rvw_title">제목</label>
			</td>
			<td>
				<input type="hidden" id = "product_no" name = "product_no" value = "${product_no}" />
				<input type="text" id="rvw_title" name = "rvw_title" maxlength="127" placeholder="제목을 입력하세요"/>
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>
				<input type="text" maxlength="12" readonly="readonly" name = "mem_id" id = "mem_id"
					value = "<%= (String)session.getAttribute("loggedin")%>"/>
			</td>
		</tr>
		<tr>
			<td>
				만족도
			</td>
			<td>
				<input type="radio" id="s_1" name = "rvw_satisfaction" value = "1" />
					<label for="s_1">★☆☆☆☆</label>
				<input type="radio" id="s_2" name = "rvw_satisfaction" value = "2" />
					<label for="s_2">★★☆☆☆</label>
				<input type="radio" id="s_3" name = "rvw_satisfaction" value = "3" />
					<label for="s_3">★★★☆☆</label>
				<input type="radio" id="s_4" name = "rvw_satisfaction" value = "4" />
					<label for="s_4">★★★★☆</label>
				<input type="radio" id="s_5" name = "rvw_satisfaction" value = "5" />
					<label for="s_5">★★★★★</label>
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea name="rvw_content" id = "rvw_content" cols="74" rows="13"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="확인" onclick = "reg_review();">
				<input type="button" value="취소" onclick = "window.close();">
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>