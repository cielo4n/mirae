<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<script type="text/javascript" src="../js/nicEdit.js"></script>
	<script type="text/javascript">
		bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
	</script>
	<style type = "text/css">
		
		#container { width : 1024px; margin : 50px auto; color: #85858d; }
		
		#container h2 { margin-bottom : 15px; }
		
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
			width : 200px;
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
		#buttons input, input[value = "카테고리 등록"]
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
		#buttons input:hover, input[value = "카테고리 등록"]:hover { opacity : 0.7; }
		#ex_summary { width: 90%; }
	</style>
	
<!-- container 부분 -->	
	<h2 id = "reg_title">상품 수정하기</h2>
		<form action = "#" method = "post">
			<table cellspacing = "0">
				<tr>
					<td><label for = "name">상품명</label></td>
					<td><input type = "text" id = "name" name = "name" size = "30"></td>
				</tr>
				<tr>
					<td><label for = "category">상품분류</label></td>
					<td>
						<select name = "cartegory" id = "category">
							<option>분류를 선택하세요.</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for = "price">상품가격</label></td>
					<td><input type = "number" id = "price" name = "price" size = "20"></td>
				</tr>
				<tr>
					<td><label for = "cost">공급원가</label></td>
					<td><input type = "number" id = "cost" name = "cost" size = "20"></td>
				</tr>
				<tr>
					<td><label for = "stock">재고</label></td>
					<td><input type = "number" id = "stock" name = "stock" size = "20"></td>
				</tr>
				<tr>
					<td><label for = "stock">무게</label></td>
					<td><input type = "number" id = "weight" name = "weight" size = "20"></td>
				</tr>
				<tr>
					<td><label for = "img">상품 대표 이미지</label></td>
					<td><input type = "file" id = "img" name = "img"></td>
				</tr>
				<tr>
					<td><label for = "img">상품 상세 이미지</label></td>
					<td><input type = "file" id = "img_detail" name = "img_detail"></td>
				</tr>
				<tr><td colspan = "2"><label for = "ex_summary">상품 요약 설명</label></tr>
				<tr>
					<td colspan = "2" class = "explain" >
						<input type = "text" name = "ex_summary" id = "ex_summary" size = "60">
					</td>
				</tr>
				<tr><td colspan = "2"><label for = "ex_detail">상품 상세 설명</label></tr>
				<tr>
					<td colspan = "2" class = "explain" ><textarea rows = "20" cols = "100" ></textarea></td>
				</tr>
				<tr>
					<td><label for = "display_state">진열 상태</label></td>
					<td>
						<input type = "radio" name = "display_state" id = "display_state_y" value = "y">
						<label for = "display_state_y">YES</label>
						<input type = "radio" name = "display_state" id = "display_state_n" value = "n">
						<label for = "display_state_n">NO</label>
					</td>
				</tr>
				<tr>
					<td><label for = "sale_state">판매 상태</label></td>
					<td>
						<input type = "radio" name = "sale_state" id = "sale_state_y" value = "y">
						<label for = "sale_state_y">YES</label>
						<input type = "radio" name = "sale_state" id = "sale_state_n" value = "n">
						<label for = "sale_state_n">NO</label>
					</td>
				</tr>
				<tr>
					<td colspan = "2" id = "buttons">
						<input type = "submit" value = "수정">
						<input type = "button" value = "취소">
					</td>
				</tr>
			</table>
		</form>
</html>