<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<style type="text/css">
.order_title {
    color: #004523;
	margin-bottom: 5px;
	margin-top: 100px;
}

table tr td {
	padding: 10px;
}

.del_info tr td {
	padding: 0;
}

table input[type="text"], table input[type="number"], table select {
	font: 16px "나눔바른고딕", "맑은 고딕", Arial;
	height: 25px;
}

.info {
	width: 100%;
	padding: 0px;
	font: 16px "나눔바른고딕", "맑은 고딕", Arial;
}

.info tr:first-child td {
	border-top: 2px solid black;
}

.info tr:last-child td {
	border-bottom: 1px solid #AAAAB0;
	padding-top: 15px;
	padding-bottom: 15px;
}

.info tr td:first-child {
	background-color: #F9F9F9;
	border-right: 1px solid #AAAAB0;
	text-align: right;
	width: 15%;
}

.info tr td:last-child {
	text-align: left;
}

.info tr td input {
	border: 1px solid #AAAAB0;
	font: 16px "나눔바른고딕", "맑은 고딕", Arial;
}

.info tr td select {
	border: 1px solid #AAAAB0;
	font-size: 1em;
	font: 16px "나눔바른고딕", "맑은 고딕", Arial;
}

table tr td input[type="radio"] {
	margin-right: 3px;
}

table tr td label {
	margin-right: 25px;
}

table tr .explain {
	text-align: center;
}

#product_list {
	width: 100%;
	padding: 0px;
	font: 16px "나눔바른고딕", "맑은 고딕", Arial;
	text-align: center;
}

#product_list tr:first-child td {
	border-top: 2px solid black;
	border-bottom: 1px solid #AAAAB0;
	background-color: #F9F9F9;
	padding-top: 15px;
	padding-bottom: 15px;
}

#product_list tr:last-child td {
	border-top: 1px solid #AAAAB0;
	border-bottom: 1px solid #AAAAB0;
	background-color: #F9F9F9;
	padding-top: 20px;
	padding-bottom: 20px;
}

#product_list tr:last-child td {
	text-align: right;
}

#name {
	width: 300px;
}

#phone1, #phone2, #phone3, #card_num1, #card_num2, #card_num3,
	#card_num4 {
	width: 70px;
}

#post_num1, #post_num2, #email1, #email2 {
	width: 100px;
}

#del_msg, #address_detail {
	width: 550px;
}

.buttons input {
	padding-top: 7px;
	padding-bottom: 7px;
	background-color: #85858D;
	color: white;
	font-family: "나눔바른고딕", "맑은 고딕";
	font-size: 16px;
	border-radius: 10px;
	border: 0px;
}

.buttons[type="submit"] {
	padding-top: 7px;
	padding-bottom: 7px;
	padding-right: 20px;
	padding-left: 20px;
	margin: 50px auto;
	background-color: #85858D;
	color: white;
	font-family: "나눔바른고딕", "맑은 고딕";
	font-size: 20px;
	border-radius: 10px;
	border: 0px;
}

.buttons:hover {
	opacity: 0.7;
}

#submit {
	text-align: center;
}
</style>

	<h3 class="order_title">주문하기</h3>
	<form action="order.jsp?page=order_complete" method="post">
		<table cellspacing="0" id="product_list">
			<tr>
				<td>제품이미지</td>
				<td>제품명</td>
				<td>수량</td>
				<td>가격</td>
				<td>주문</td>
			</tr>
			<tr>
				<td>사진사진</td>
				<td>쑥 비누</td>
				<td>1개</td>
				<td>4,300원</td>
				<td class="buttons">
					<!-- order_cencle() 매개변수는 행 번호를 넣을 것 --> <input type="button"
					onclick="order_cencle(0)" value="취소">
				</td>
			</tr>
			<tr>
				<td>사진사진</td>
				<td>아마씨 비누</td>
				<td>2개</td>
				<td>7,000원</td>
				<td class="buttons">
					<!-- order_cencle() 매개변수는 행 번호를 넣을 것 --> <input type="button"
					onclick="order_cencle(1)" value="취소">
				</td>
			</tr>
			<tr>
				<td colspan=5>총 주문금액 : 11,300 + 배송비 3,000원 = <b>14,300원</b>
				</td>
			</tr>
		</table>
		</div>
		<!-- 주문하기 끝 -->

		<h3 class="order_title">주문자정보</h3>

		<div>
			<!-- 주문자 정보 시작 -->
			<table cellspacing="0" class="info">
				<tr>
					<td for="name">이름</td>
					<td><input type="text" id="name" name="name" maxlength="20"
						value=""></td>
				</tr>
				<tr>
					<td>휴대폰번호</td>
					<td><select id="phone1" name="phone1">
							<option value="010">&nbsp;010&nbsp;</option>
							<option value="016">&nbsp;016&nbsp;</option>
							<option value="017">&nbsp;017&nbsp;</option>
							<option value="018">&nbsp;018&nbsp;</option>
							<option value="019">&nbsp;019&nbsp;</option>
					</select>- <input id="phone2" type="number" name="phone2" size="4"
						maxlength="4" value="">- <input id="phone3" type="number"
						name="phone3" size="4" maxlength="4" value=""> <!-- input 가로 사이즈 주기 -->
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" id="email1" name="email1" value="" />@<input
						type="text" id="email2" name="email2" value="" /> <select
						id="email_select" name="email_select">
							<option>직접입력</option>
							<option>naver.com</option>
							<option>hanmail.net</option>
							<option>nate.com</option>
							<option>hotmail.com</option>
							<option>gmail.com</option>
					</select></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td><input type="number" id="post_num1" name="post_num1"
						disabled="disabled" value="" />- <input type="number"
						id="post_num2" name="post_num2" disabled="disabled" value="" />
						<button id="find_post_num">우편번호 찾기</button>
						<br></td>
				</tr>
				<tr style="margin: -10px;">
					<td for="address_detail">상세주소</td>
					<td><input type="text" id="address_detail"
						name="address_detail" value="" /></td>
				</tr>
			</table>
		</div>
		<!-- 주문자 정보 끝 -->

		<table class="del_info">
			<tr>
				<td width="150px"><h3 class="order_title">배송지정보</h3></td>
				<td style="padding-bottom: 5px;">&nbsp;<input type="checkbox"
					value="true" name="order_same"
					style="vertical-align: text-bottim; margin-top: 100px;">
					&nbsp; <label style="vertical-align: text-bottim; margin-top: 100px;">위와
						동일함<label></td>
			</tr>
		</table>

		<div>
			<!-- 배송지정보 시작 -->
			<table cellspacing="0" class="info">
				<tr>
					<td for="name">받는 분 성명</td>
					<td><input type="text" id="name" name="name" maxlength="20"
						value=""></td>
				</tr>
				<tr>
					<td>휴대폰번호</td>
					<td><select id="phone1" name="phone">
							<option value="010">&nbsp;010&nbsp;</option>
							<option value="016">&nbsp;016&nbsp;</option>
							<option value="017">&nbsp;017&nbsp;</option>
							<option value="018">&nbsp;018&nbsp;</option>
							<option value="019">&nbsp;019&nbsp;</option>
					</select>- <input id="phone2" type="number" name="phone_middle" size="4"
						maxlength="4" value="">- <input id="phone3" type="number"
						name="phone_last" size="4" maxlength="4" value=""> <!-- input 가로 사이즈 주기 -->
					</td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td><input type="number" id="post_num1" name="post_num1"
						disabled="disabled" value="" />- <input type="number"
						id="post_num2" name="post_num2" disabled="disabled" value="" />
						<button id="find_post_num">우편번호 찾기</button>
						<br></td>
				</tr>
				<tr style="margin: -10px;">
					<td for="address_detail">상세주소</td>
					<td><input type="text" id="address_detail"
						name="address_detail" value="" /></td>
				</tr>
				<tr>
					<td for="del_msg">배송메세지</td>
					<td><textarea id="del_msg" name="del_msg" cols="60" row="3"></textarea>
					</td>
				</tr>
			</table>
		</div>
		<!-- 배송지정보 끝 -->

		<h3 class="order_title">결제정보</h3>

		<div>
			<!-- 결제정보 시작 -->
			<table cellspacing="0" class="info">
				<tr>
					<td for="name">결제금액</td>
					<td>14,300원</td>
				</tr>
				<tr>
					<td>결제방식</td>
					<td>신용카드</td>
				</tr>
				<tr>
					<td>신용카드 선택</td>
					<td><input type="radio" name="card" value="sinhan" checked>&nbsp;신한&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="card" value="samsung">&nbsp;삼성&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="card" value="hana">&nbsp;하나&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="card" value="lotte">&nbsp;롯데&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="card" value="kb">&nbsp;KB국민&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="card" value="nh">&nbsp;NH채움&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="card" value="bc">&nbsp;비씨&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="card" value="woori">&nbsp;우리&nbsp;&nbsp;&nbsp;&nbsp;

					</td>
				</tr>
				<tr>
					<td>신용카드 번호</td>
					<td><input type="text" id="card_num1" name="card_num1"
						value="" size="4" maxlength="4" />&nbsp;&nbsp; <input type="text"
						id="card_num2" name="card_num2" value="" size="4" maxlength="4" />&nbsp;&nbsp;
						<input type="text" id="card_num3" name="card_num3" value=""
						size="4" maxlength="4" />&nbsp;&nbsp; <input type="text"
						id="card_num4" name="card_num4" value="" size="4" maxlength="4" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 유효기간 <select
						name="expiry_month">
							<option value="01">&nbsp;01&nbsp;</option>
							<option value="02">&nbsp;02&nbsp;</option>
							<option value="03">&nbsp;03&nbsp;</option>
							<option value="04">&nbsp;04&nbsp;</option>
							<option value="05">&nbsp;05&nbsp;</option>
							<option value="06">&nbsp;06&nbsp;</option>
							<option value="07">&nbsp;07&nbsp;</option>
							<option value="08">&nbsp;08&nbsp;</option>
							<option value="09">&nbsp;09&nbsp;</option>
							<option value="10">&nbsp;10&nbsp;</option>
							<option value="11">&nbsp;11&nbsp;</option>
							<option value="12">&nbsp;12&nbsp;</option>
					</select> <select name="expiry_year">
							<option value="16">&nbsp;16&nbsp;</option>
							<option value="17">&nbsp;17&nbsp;</option>
							<option value="18">&nbsp;18&nbsp;</option>
							<option value="19">&nbsp;19&nbsp;</option>
							<option value="20">&nbsp;20&nbsp;</option>
							<option value="21">&nbsp;21&nbsp;</option>
							<option value="22">&nbsp;22&nbsp;</option>
							<option value="23">&nbsp;23&nbsp;</option>
							<option value="24">&nbsp;24&nbsp;</option>
							<option value="25">&nbsp;25&nbsp;</option>
							<option value="26">&nbsp;26&nbsp;</option>
							<option value="27">&nbsp;27&nbsp;</option>
							<option value="28">&nbsp;28&nbsp;</option>
							<option value="29">&nbsp;29&nbsp;</option>
							<option value="39">&nbsp;30&nbsp;</option>
					</select></td>
				</tr>
			</table>

			<p id="submit">
				<input type="submit" value="결제하기" class="buttons">
			</p>
			<!--------------------------------------------------------end container------------->

</html>