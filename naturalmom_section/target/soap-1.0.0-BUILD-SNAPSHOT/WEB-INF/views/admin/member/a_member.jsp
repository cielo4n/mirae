<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="resources/admin/js/jquery-1.11.3.min.js"></script>
	<!-- [if lt IE 9]><script src="js/html5shiv.js"></script><![endif] -->
	
	<link rel="apple-touch-icon" href="../resources/images/logo.ico" /> <!--애플아이콘등록-->
	<link rel="shortcut icon" href="../resources/images/logo.ico" /> <!--단축키아이콘등록-->
	<link rel="stylesheet" href="../resources/admin/css/admin_common.css"/>
		
	<title>자연맘</title>
		<style type = "text/css">
		#container { 
				width : 1024px; margin : 50px auto; color: #85858d;
				font-family : "나눔바른고딕", "맑은 고딕";
				font-size: 13px; }
		
		h2 { margin-bottom : 15px; font-size: 24px; }
		
		table { width: 100%; padding : 0px; }
		table tr:first-child td, table tr:last-child td { border-top : 1px solid grey; }
		table tr:not(:last-child) td:first-child { border-left : 1px solid grey; }
		table tr:not(:last-child) td:last-child { border-right : 1px solid grey; }
		table tr td { padding : 10px; }
		table tr:not(:last-child) td
		{
			border-bottom : 1px solid lightgrey;
			margin : 0px;
		}
		table tr td:first-child:not([colspan = "2"])
		{ 
			width : 150px;
			border-right : 1px solid lightgrey; 
			text-align : right;
			padding-right : 0px;
		}
		table tr td input
		{ 
			border : 1px solid lightgrey; 
			font : 16px "나눔바른고딕", "맑은 고딕", Arial; 
		}
		table tr td select 
		{ 
			border : 1px solid lightgrey; font-size : 1em; 
			font : 16px "나눔바른고딕", "맑은 고딕", Arial;
		}
		table tr td input[type = "radio"] { margin-right : 3px; }
		table tr td label { margin-right : 25px; }
		table tr .explain { text-align : left; }
		table tr .explain textarea { width: 100%; height: 500px; }

		#buttons 
		{ 
			margin-top : 20px; text-align : right;
		}
		#buttons input
		{	
			padding : 7px 30px;
			margin-left : 5px;
			margin-right : 5px; 
			background-color : #85858D;
			color : white;
			font-family : "나눔바른고딕", "맑은 고딕";
			font-size : 16px;
			border-radius : 10px; 
			border : 0px;
		}
		
		#id, #name, #email1, #email2 { width: 120px;}
		#phone2, #phone3, #year { width: 80px; }
		
		#container a { text-decoration: underline; }

		
		#result_table { width: 100%; padding : 0px; }
		#result_table tr:first-child td, table tr:first-child td a { text-align:center; background-color: #918686; color: white; }
		#result_table tr:not(:first-child) td a { color: black; }
		#result_table tr td { border-top : 1px solid grey; border-bottom : 1px solid grey; }
		#result_table tr td { border-right : 1px solid lightgrey; }
		#result_table tr td:first-child { border-left : 1px solid grey;  width: 50px;}
		#result_table tr td:last-child { border-right: 1px solid grey; }
		#result_table tr td { padding : 10px; }

		#buttons { margin-top: 20px; text-align: right; }
		#buttons input[type = "button"]
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
		#buttons input[type = "button"]:hover { opacity : 0.7; }
		
		
	</style>
	
   </head>

  <body>
<!--  Start header --------------------------------------------------------------------->
	<header>
		<%@include file="../_default_header.jsp" %>
	</header>
<!-----------------------------------------------------------end header ----------->	
<!---Start container----------------------------------------------------------------->
<!--- 회원검색 ----------------------------------------------------------------->
	<div id="container">
		<h2 id = "reg_title">회원 검색</h2>
		<form action = "#" method = "post">
			<table id="search_table" cellspacing = "0">
				<tr>
					<td><label for = "id">아이디</label></td>
					<td><input type = "text" id = "id" name = "id" size = "30"></td>
				</tr>
				<tr>
					<td><label for = "name">이름</label></td>
					<td><input type = "text" id = "name" name = "name" size = "30"></td>
				</tr>
				<tr>
					<td><label for = "phone1">전화번호</label></td>
					<td>
						<select id="phone1" name="phone1">
							<option value="none">&nbsp;선택&nbsp;</option>
                    	    <option value="010">&nbsp;010&nbsp;</option>
                       		<option value="016">&nbsp;016&nbsp;</option>
                    	    <option value="017">&nbsp;017&nbsp;</option>
                       	 	<option value="018">&nbsp;018&nbsp;</option>
                       	 	<option value="019">&nbsp;019&nbsp;</option>
                     	</select>-
						<input type="number" id="phone2" name="phone2" />-
						<input type="number" id="phone3" name="phone3" />
					</td>
				</tr>
				<tr>
					<td><label for = "email1">이메일</label></td>
					<td>
					<input type="text" id="email1" name="email1" />@<input type="text" id="email2" name="email2" />
					<select id="email_select" name="email_select" onchange="email_change()">
							<option value="empty">직접입력</option>
							<option value="naver.com">naver.com</option>	
							<option value="hanmail.net">hanmail.net</option>
							<option value="nate.com">nate.com</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="gmail.com">gmail.com</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for = "year">생년월일</label></td>
					<td>
						<input id="year" name="year" type="number" placeholder="1999"/>년 
						<select id="month" name="month">
								<option value="none">&nbsp;선택&nbsp;</option>
              	 	         <%for(int i=1; i<13; i++){ %>
              		       		<option value="<%= i %>">&nbsp;<%= i %>&nbsp;</option>
               		      	<%} %>
                	     </select>월
                  	   <select id="day" name="day">
                  	   			<option value="none">&nbsp;선택&nbsp;</option>
                   		  	<%for(int i=1; i<32; i++){ %>
                    	 		<option value="<%= i %>">&nbsp;<%= i %>&nbsp;</option>
                   		  	<%} %>
                 	    </select>일
					</td>
				</tr>
				<tr>
					<td><label for = "gender">성별</label></td>
					<td><input type="radio" name="gender" id="none" value="none" checked="checked"/><label for="none">&nbsp;모두</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" id="male" value="male"/><label for="male">&nbsp;남</label>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="gender" id="female" value="female"/><label for="female">&nbsp;여</label>
					</td>
				</tr>
				<tr>
					<td><label for = "level_no">회원상태</label></td>
					<td>
						<select id="level_no" name="level_no">
							<option value="all">&nbsp;모두&nbsp;</option>
							<option value="common">&nbsp;일반&nbsp;</option>
							<option value="blacklist">&nbsp;불량&nbsp;</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan = "2" id = "buttons">
						<input type = "submit" value = "검색">
					</td>
				</tr>
			</table>
<!--- 검색결과 ----------------------------------------------------------------->
			<h2 id = "reg_title">검색 결과</h2>
			<table id="result_table" cellspacing = "0">
				<tr>
					<td>체크</td>
					<td><a href = "#">▼ 아이디</a></td>
					<td><a href = "#">▼ 이름</a></td>
					<td><a href = "#">▼ 주소</a></td>
					<td><a href = "#">▼ 전화번호</a></td>
					<td><a href = "#">▼ 이메일</a></td>
					<td><a href = "#">▼ 생년월일</a></td>
					<td><a href = "#">▼ 성별</a></td>
					<td><a href = "#">▼ 회원상태</a></td>
				</tr>
				<tr>
					<td style="text-align: center"><input type = "checkbox" name = "" /></td>
					<td>admin</td>
					<td>관리자</td>
					<td>서울시 광진구 구의2동</td>
					<td>010-0000-0000</td>
					<td>admin@natural.com</td>
					<td>1900-01-01</td>
					<td>여</td>
					<td>일반 회원</td>
				</tr>
			</table>
			<div id = "buttons">
				선택한 회원을
				<input type = "button" id = "set_drop_out" value = "회원탈퇴 처리" />
				<input type = "button" id = "set_blacklist" value = "불량회원 처리" />
			</div>
		</form>
	</div>
<!--------------------------------------------------------end container------------->
  </body>
  <script type="text/javascript">
  
	 function email_change() {
		 var selectedEmail = $("#email_select").val();
		 document.getElementById("email2").setAttribute("value", selectedEmail);
	 }
  
  </script>

</html>
