<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<style type="text/css">

#inside {
	text-align: left;
	margin : 0px 150px;
	font : 16px "나눔바른고딕", "맑은 고딕", Arial;
}
table { width: 100% }

table td{
	border: 1px solid white;
	padding: 10px;
	text-align: left;
	font-size: 13px;
	color: black;
}

h2{color: #004523;
	padding-top: 100px;}


#join_submit { 
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

#check_id_double, #find_post_num{
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
	width: 85px;
	vertical-align: top;
}

#id, #name, #email1, #email2 { width: 100px; }
#phone1, #phone2, #phone3, #post_num1, #post_num2, #year
	{ width: 70px; }
#address, #address_detail { width: 300px; }

</style>
<html>
<div id="inside">
	<h2>&nbsp;&nbsp;회원가입</h2>
	<br><hr>
	<form action="join_complete.nm" method="post" name="join_form" id="join_form">
		<table>
			<tr>
				<td>아이디</td>
				<td id="check_id"><input type="text" id="id" name="id" onchange="check_id()"/>
					<input type="button" value="중복확인" name="check_id_double" id="check_id_double" onclick="pop_id()"/>
					&nbsp;&nbsp;<span>(6-18자 입력)</span></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td id="check_pw"><input type="password" id="pw" name="pw" onchange="check_pw()"/>
					&nbsp;&nbsp;<span>(영문, 숫자포함 6-18자 입력)</span></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td id="check_pw2"><input type="password" id="pw2" name="pw2" onchange="check_pw2()"/>&nbsp;&nbsp;
					<span>비밀번호를 한번 더 입력하세요</span></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="gender" id="male" value="1" checked="checked"/><label for="male">&nbsp;남</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" id="female" value="2"/><label for="female">&nbsp;여</label></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input id="year" name="year" type="number" placeholder="1999"/>년 
					<select id="month" name="month">
							<option value="0">&nbsp;선택&nbsp;</option>
                        <%for(int i=1; i<13; i++){ %>
                     		<option value="<%= i %>">&nbsp;<%= i %>&nbsp;</option>
                     	<%} %>
                     </select>월
                     <select id="day" name="day">
                     		<option value="0">&nbsp;선택&nbsp;</option>
                     	<%for(int i=1; i<32; i++){ %>
                     		<option value="<%= i %>">&nbsp;<%= i %>&nbsp;</option>
                     	<%} %>
                     </select>일
				</td>
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
						<option value="e">직접입력</option>
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
					<input type="text" id="post_num" name="post_num" readonly="readonly" onclick="suggestButton()"/>
					<!-- post_num1 + post_num2 = addr_post -->
					<input type="button" value="우편번호 찾기" id="find_post_num" name="find_postnum" onclick="pop_postNum()"/><br>
					<input type="text" id="address" name="address" readonly="readonly" onclick="suggestButton()"/>
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
				<td colspan="2" style="text-align: center"><input type="button" id="join_submit" value="확인" onclick="allSubmit()"/></td>
			</tr>
		</table>
		
	<!-- Null Check -->
	<input type="hidden" id="nnId" name="nnId" value="false"/>
	<input type="hidden" id="nnPw" name="nnPw" value="false"/>
	<input type="hidden" id="nnPw2" name="nnPw2" value="false"/>
	<input type="hidden" id="page" name="page" value="complete"/>
	</form>
	
	
</div>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	
/*	function check_id() {
		var length_id = $('#id').val().length;
		
		console.log(length_id);
		if(length_id ==0){
			$("#check_id span").css("color", "red").text("아이디를 입력해주세요");
		} else if( length_id < 6){
			$("#check_id span").css("color", "red").text("아이디가 너무 짧습니다");
		} else if( length_id > 18){
			$("#check_id span").css("color", "red").text("아이디가 너무 깁니다");
		} else {
			$("#check_id span").text("");
		}
	}
*/
	function check_pw() {
		var length_pw = $('#pw').val().length;
		
		console.log(length_pw);
		if( length_pw < 6){
			$("#check_pw span").css("color", "red").text("비밀번호가 너무 짧습니다");
			document.getElementById("nnPw").value = "false";
		} else if(length_pw >18){
			$("#check_pw span").css("color", "red").text("비밀번호가 너무 깁니다");
			document.getElementById("nnPw").value = "false";
		}else {
			$("#check_pw span").css("color", "gray").html("<i class='fa fa-check-circle' aria-hidden='true'></i>");
			document.getElementById("nnPw").value = "true";
		}
	}
	
	function check_pw2() {
		var val_pw1= $('#pw').val();
		var var_pw2 = $('#pw2').val();
		
		if( ! (val_pw1 == var_pw2) ){
			$("#check_pw2 span").css("color", "red").html("비밀번호가 일치하지 않습니다");
			document.getElementById("nnPw2").value = "false";
		}else{
			$("#check_pw2 span").css("color", "gray").html("<i class='fa fa-check-circle' aria-hidden='true'></i>");
			document.getElementById("nnPw2").value = "true";
		}
	}
	 
	 function pop_id() {
		 var id = $('#id').val();
		window.open("pop_checkId.nm?check="+id, "CheckID", "width=402px, height=270px, left=600px, top=200px, scrollbars=no, toolbar=no, location=no");
		
	 }
	 
	 function pop_postNum() {
		 new daum.Postcode({
		        oncomplete: function(data) {
		            $('#post_num').val(data.zonecode);
		            $('#address').val(data.address);
                    $('#address_detail').focus();
		        }
		    }).open();
//		window.open("membership_pop_post.jsp", "FindPostNumber", "width=402px, height=480px, left=600px, top=200px, scrollbars=no, toolbar=no, location=no");
	 }
	 
	 
	 function email_change() {
		 var selectedEmail = $("#email_select").val();
		 document.getElementById("email2").value = selectedEmail;
	}
	 
	function allSubmit(){
		
		if($('#nnId').val()=="false"){
			alert("아이디 중복확인을 해주세요.");
		}else if($('#nnPw').val()=="false"){
			alert("비밀번호를 확인해주세요.");
		}else if($('#nnPw2').val()=="false"){
			alert("비밀번호가 일치하는지 확인해주세요.");
		}else if($('#name').val()==""){
			alert("이름을 입력해주세요.");
		}else if($('#year').val()=="" || $('#month').val()=="none" || $('#day').val()=="none"){
			alert("생년월일을 입력해주세요.");
		}else if($('#phone1').val()=="none" || $('#phone2').val()=="" || $('#phone3').val()==""){
			alert("휴대폰 번호를 입력해주세요.");
		}else if($('#email1').val()=="" || $('#email2').val()=="" || $('#email_select').val()=="none"){
			alert("이메일을 입력해주세요.");
		}else if($('#email1').val()=="" || $('#email2').val()==""){
			alert("이메일을 입력해주세요.");
		}else if($('#post_num').val()=="" || $('#address').val()==""){
			alert("주소를 입력해주세요.");
		}else if($('#address_detail').val()==""){
			alert("상세주소를 입력해주세요.");
		}else{
			$('#join_form').submit();
			document.join_form.submit();
		}
		
	}
	
	function suggestButton() {
		alert("우편번호 찾기를 이용해주세요")		
	}
	 
	

</script>

</html>

