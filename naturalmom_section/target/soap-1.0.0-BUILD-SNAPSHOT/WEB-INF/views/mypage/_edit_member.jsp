<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">

#inside {
	text-align: left;
	padding-top: 85px;
}

table {
		margin : 0 auto;
		width: 75%;
		font-family : "나눔바른고딕", "맑은 고딕";
}

table tr:not(:first-child) td{
	border: 1px solid white;
	text-align: left;
	font-size: 13px;
	color: black;
	padding-bottom: 15px;
}

h2{color: #004523;}

#button { text-align: center; }

#submit { 
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
#drop_out, #find_post_num{
	padding : 3px 15px;
	margin-left : 5px;
	margin-right : 5px; 
	background-color : #85858D;
	color : white;
	font-family : "나눔바른고딕", "맑은 고딕";
	font-size : 14px;
	border-radius : 10px; 
	border : 0px;
}

td:FIRST-CHILD {
	width: 20%;
	vertical-align: top;
}

#id, #name, #email1, #email2 { width: 100px; }
#phone1, #phone2, #phone3, #post_num1, #post_num2
	{ width: 70px; }
#address, #address_detail { width: 300px; }

#quit {
	margin-left: 170px;
}

</style>
<html>
<div id="inside">
	
	<form action="" method="post">
		<table>
			<tr>
				<td colspan="2"><h2>회원정보 수정</h2><br><hr><br></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="id" name="id" disabled="disabled"/></td>
			</tr>
						<tr>
				<td>비밀번호</td>
				<td id="check_pw"><input type="password" id="pw" name="pw" onchange="check_pw()"/>
					&nbsp;&nbsp;<span>(영문, 숫자포함 6-18자 입력)</span></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td id="check_pw2"><input type="password" id="pw2" name="pw2" onchange="check_pw2()"/>&nbsp;
					<span>비밀번호를 한번 더 입력하세요</span></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name" disabled="disabled"/></td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
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
				<td>이메일</td>
				<td>
					<input type="text" id="email1" name="email1" />@<input type="text" id="email2" name="email2" />
					<select id="email_select" name="email_select" onchange="email_change()">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="nate.com">nate.com</option>
						<option value="hotmail.com">hotmail.com</option>
						<option value="gmail.com">gmail.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="number" id="post_num" name="post_num" disabled="disabled"/>
					<!-- post_num1 + post_num2 = addr_post -->
					<input type="button" value="우편번호 찾기" name="find_postnum" onclick="pop_postNum()"/><br>
					<input type="text" id="address" name="address" disabled="disabled"/>
				</td>
			</tr>
			<tr style="margin: -10px;">
				<td>상세주소</td>
				<td>
					<input type="text" id="address_detail" name="address_detail" />
					<!-- address+address_detail = addr_detail -->
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right"><button id="drop_out">회원탈퇴</button></td>
			</tr>
			<tr>
				<td colspan="2"><p id="button"><input type="submit" id="submit" value="확인" /></p></td>
			</tr>
		</table>
	</form>

</div>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">

function check_pw() {
	var length_pw = $('#pw').val().length;
	
	console.log(length_pw);
	if( length_pw < 6){
		$("#check_pw span").css("color", "red").text("비밀번호가 너무 짧습니다");
	} else {
		$("#check_pw span").text("");
	}
}

function check_pw2() {
	var val_pw1= $('#pw').val();
	var var_pw2 = $('#pw2').val();
	
	if( ! (val_pw1 == var_pw2) ){
		$("#check_pw2 span").css("color", "red").text("비밀번호가 일치하지 않습니다");
	}else{
		$("#check_pw2 span").css("color", "gray").text("비밀번호가 일치합니다");
	}
}

	function pop_postNum() {
		 new daum.Postcode({
	    	    oncomplete: function(data) {
	        	    $('#post_num').val(data.zonecode);
	            	$('#address').val(data.address);
  	            $('#address_detail').focus();
		        }
	   	 }).open();
	}
	
	 function email_change() {
		 var selectedEmail = $("#email_select").val();
		 document.getElementById("email2").setAttribute("value", selectedEmail);
	}

</script>
</html>