<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<script type="text/javascript" src="/soap/resources/admin/js/nicEdit.js"></script>
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
<script type="text/javascript">
	bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
	
	function form_check()
	{
		var name = $('#product_name').val();
		var cate = $('#category_cd').val();
		var price = $('#selling_price').val();
		var cost = $('#cost_price').val();
		var stock = $('#stock').val();
		var weight = $('#weight').val();
		var img_re = $('#re_img').val();
		var img_de = $('#de_img').val();
		var ex_su = $('#summary_ex').val();
		var ex_de = nicEditors.findEditor('detail_ex').getContent();
		var dis_y = $('#display_state_y:checked').val();
		var dis_n = $('#display_state_n:checked').val();
		var sal_y = $('#sale_state_y:checked').val();
		var sal_n = $('#sale_state_n:checked').val();
		
		// 이미지 파일 확장자 확인
		var img_suffix = ['.png', '.jpg', '.jpeg', '.gif'];
		var isImage = -1;
			
		if (weight == '')
		{
			weight = 0;
		}
		if (name == '')
		{
			alert('상품명을 입력해주세요.');
			$('#product_name').focus();
		}
		else if (cate == '' || cate == '-1')
		{
			alert('상품 분류를 지정해주세요.');
			$('#category_cd').focus();
		}
		else if (price == '')
		{
			alert('상품 가격을 입력해주세요.');
			$('#selling_price').focus();
		}
		else if (isNaN(price) || price < 0)
		{
			alert('상품 가격을 정확히 입력해주세요.');
			$('#selling_price').focus();
		}
		else if (cost == '')
		{
			alert('공급 원가를 입력해주세요.');
			$('#cost_price').focus();
		}
		else if (isNaN(cost) || cost < 0)
		{
			alert('공급 원가를 정확히 입력해주세요.');
			$('#cost_price').focus();
		}
		else if (stock == '')
		{
			alert('재고를 입력해주세요.');
			$('#stock').focus();
		}
		else if (isNaN(stock) || stock < 0)
		{
			alert('재고를 정확히 입력해주세요.');
			$('#stock').focus();
		}
		else if (isNaN(weight) || weight < 0)
		{
			alert('무게를 정확히 입력해주세요.');
			$('#weight').focus();
		}
		else if (ex_su == '')
		{
			alert('상품 요약 설명을 입력해주세요.');
			$('#summary_ex').focus();
		}
		else if (dis_y == undefined && dis_n == undefined)
		{
			alert('상품 진열 상태를 선택해주세요');
			$('#display_state_y').focus();
		}
		else if (sal_y == undefined && sal_n == undefined)
		{
			alert('상품 판매 상태를 선택해주세요');
			$('#sale_state_y').focus();
		}
		else
		{
			if (img_re != '')
			{
				// 상품 대표 이미지
				for (var i in img_suffix)
				{
					isImage = img_re.indexOf(img_suffix[i]);
					if (isImage > -1)
						break;
				}
				if (isImage == -1)
				{
					alert('이미지는 .png, .jpg, .jpeg, .gif 만 가능합니다.');
					$('#re_img').focus();
					return;
				}
			}
			if (img_de != '')
			{
				isImage = -1;
				// 상품 상세 이미지
				for (var i in img_suffix)
				{
					isImage = img_de.indexOf(img_suffix[i]);
					if (isImage > -1)
						break;
				}
				if (isImage == -1)
				{
					alert('이미지는 .png, .jpg, .jpeg, .gif 만 가능합니다.');
					$('#de_img').focus();
					return;
				}
			}			
			
			// 완벽하게 다 입력됨
 			$('#detail_ex').val(ex_de);
			document.modi_form.submit();
		}				
	//	alert(img_re + ", " + img_de + ", " + price + ", " + cost + ", " + stock + ", " + weight);
	}
</script>
	<h2 id = "reg_title">상품 수정하기</h2>
		<form action = "product_modi_proc.nm" method = "post" enctype="multipart/form-data" name = "modi_form">
			<table cellspacing = "0">
				<tr>
					<td><label for = "product_name">상품명</label></td>
					<td>
						<input type = "text" id = "product_name" name = "product_name" size = "30" value ="${productVo.product_name}">
						<input type = "hidden" id = "product_no" name = "product_no" value = "${productVo.product_no}" />
					</td>
				</tr>
				<tr>
					<td><label for = "category_cd">상품분류</label></td>
					<td>
						<select name = "category_cd" id = "category_cd">
							<option value = "-1" >분류를 선택하세요.</option>
							<c:forEach var = "category" items = "${c_list}">
								<option value = "${category.category_cd}" 
									<c:if test = "${category.category_cd == productVo.category_cd}">
										selected = "selected"
									</c:if> >
										${category.category_nm}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for = "selling_price">상품가격</label></td>
					<td><input type = "number" id = "selling_price" name = "selling_price" size = "20" value ="${productVo.selling_price}"></td>
				</tr>
				<tr>
					<td><label for = "cost_price">공급원가</label></td>
					<td><input type = "number" id = "cost_price" name = "cost_price" size = "20" value ="${productVo.cost_price}"></td>
				</tr>
				<tr>
					<td><label for = "stock">재고</label></td>
					<td><input type = "number" id = "stock" name = "stock" size = "20" value ="${productVo.stock}"></td>
				</tr>
				<tr>
					<td><label for = "weight">무게</label></td>
					<td><input type = "number" id = "weight" name = "weight" size = "20" value ="${productVo.weight}"></td>
				</tr>
				<tr>
					<td><label for = "re_img">상품 대표 이미지</label></td>
					<td>
						<input type = "file" id = "re_img" name = "re_img">
						<span>&nbsp;&nbsp;${productVo.represent_img}</span>
					</td>
				</tr>
				<tr>
					<td><label for = "de_img">상품 상세 이미지</label></td>
					<td>
						<input type = "file" id = "de_img" name = "de_img">
						<span>&nbsp;&nbsp;${productVo.detail_img}</span>
					</td>
				</tr>
				<tr><td colspan = "2"><label for = "summary_ex">상품 요약 설명</label></tr>
				<tr>
					<td colspan = "2" class = "explain" >
						<input type = "text" name = "summary_ex" id = "summary_ex" size = "60" value ="${productVo.summary_ex}">
					</td>
				</tr>
				<tr><td colspan = "2"><label for = "detail_ex">상품 상세 설명</label></tr>
				<tr>
					<td colspan = "2" class = "explain" ><textarea rows = "20" cols = "100" id = "detail_ex" name = "detail_ex">${productVo.detail_ex}</textarea></td>
				</tr>
				<tr>
					<td><label for = "display_state">진열 상태</label></td>
					<td>
						<input type = "radio" name = "display_state" id = "display_state_y" value = "1"
							<c:if test = "${productVo.display_state == 1}">checked="checked"</c:if>>
						<label for = "display_state_y">YES</label>
						<input type = "radio" name = "display_state" id = "display_state_n" value = "0"
							<c:if test = "${productVo.display_state == 0}">checked="checked"</c:if>>
						<label for = "display_state_n">NO</label>
					</td>
				</tr>
				<tr>
					<td><label for = "sale_state">판매 상태</label></td>
					<td>
						<input type = "radio" name = "sale_state" id = "sale_state_y" value = "1"
							<c:if test = "${productVo.sale_state == 1}">checked="checked"</c:if>>
						<label for = "sale_state_y">YES</label>
						<input type = "radio" name = "sale_state" id = "sale_state_n" value = "0"
							<c:if test = "${productVo.sale_state == 0}">checked="checked"</c:if>>
						<label for = "sale_state_n">NO</label>
					</td>
				</tr>
				<tr>
					<td colspan = "2" id = "buttons">
						<input type = "button" value = "수정" onclick = "form_check();">
						<input type = "button" value = "취소" onclick = "location.href='product.nm'">
					</td>
				</tr>
			</table>
		</form>
</html>