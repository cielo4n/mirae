<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<script type="text/javascript" src="/soap/resources/tablesorter/jquery-latest.js"></script> 
<script type="text/javascript" src="/soap/resources/tablesorter/jquery.tablesorter.js"></script>
   <style type = "text/css">

      #container   { width : 1024px; margin : 50px auto; color: #85858d; }
      #container a { text-decoration: underline; }

      #container h2 { margin-bottom : 15px; }
      
      table { width: 100%; padding : 0px; }
      table tr th 
      { 
      	text-align:center;
      	font-weight: normal;
      	background-color: #918686; 
      	color: white; 
      	padding: 20px 10px;
      }
      table tr td a { color: black; }
      table tr td { border-top : 1px solid grey; border-bottom : 1px solid grey; }
      table tr td { border-right : 1px solid lightgrey; }
      table tr td:first-child { border-left : 1px solid grey; }
      table tr td:last-child { border-right: 1px solid grey; }
      table tr td { padding : 10px; }

      table tr td:nth-child(1), table tr td:nth-child(2), table tr td:nth-child(3), table tr td:nth-child(4), 
      table tr td:nth-child(5), table tr td:nth-child(8), table tr td:nth-child(9) { text-align: center; }
      table tr td:nth-child(6), table tr td:nth-child(7), table tr td:nth-child(10) { text-align: right; }


      #buttons { margin-top: 20px; margin-bottom: 20px; text-align: right; }
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
      #buttons span { color: black; }
      
      th:not(:first-child).header { 
    	background-image: url(/soap/resources/tablesorter/themes/blue/bg.gif); 
    	cursor: pointer; 
    	background-repeat: no-repeat; 
    	background-position: center right; 
    	border-right: 1px solid #dad9c7;
      } 
      th:not(:first-child).headerSortUp { 
   		background-image: url(/soap/resources/tablesorter/themes/blue/asc.gif); 
	  } 
	  th:not(:first-child).headerSortDown { 
   		background-image: url(/soap/resources/tablesorter/themes/blue/desc.gif); 
	  } 

   </style>
<!-- 링크, 이미지 살려놓기. product.nm 상태에도 리스트 띄우기 -->
<!-- container 부분 -->   
<script type = "text/javascript">

   <% if(request.getParameter("rslt") != null 
         && request.getParameter("rslt").equals("true")){ %>      
         alert('상품 등록에 성공했습니다.');            
   <% } else if (request.getParameter("rslt") != null
         && request.getParameter("rslt").equals("m_true")){ %>
         alert('상품 수정에 성공했습니다.');   
   <% } else if (request.getParameter("rslt") != null
         && request.getParameter("rslt").equals("m_false")){ %>   
         alert('상품 수정에 실패했습니다.');
   <% } else if (request.getParameter("rslt") != null
         && request.getParameter("rslt").equals("error")){ %>   
         alert('상태 변경에 실패했습니다.');   
   <% } %>
   
   
   $(document).ready(function() 
			{ 
				$("#data_part").tablesorter(); 
			} 
	);
   
   function state_change(id, state)
   {
      var url = "product.nm?page=process&item=" + id + "&order=" + state;
      var checked = '';
      $('input:checkbox[id="chk"]:checked').each(function(){
         checked += '&no=' + $(this).val();
      });
//       alert(url + checked);
      if(checked.indexOf('&no') == -1)
      {
         alert('상품을 선택해주세요.');
      }         
      else
      {
         location.href = url + checked;
      }
   }
   
   function all_check(all)
   {
      if( $(all).is(":checked") == true ){
          $("input[name=chk]").prop("checked", true );
         }else{
          $("input[name=chk]").prop("checked", false ); 
      }
   }
   
</script>
   <h2 id = "reg_title">상품 관리</h2>
      <div id = "buttons">
         <span>선택한 상품을 </span>
         <input type = "button" id = "dis_y" value = "진열" onclick = "state_change('dis', 1);" />
         <input type = "button" id = "dis_n" value = "진열 안함" onclick = "state_change('dis', 0);" />
         <input type = "button" id = "sale_y" value = "판매" onclick = "state_change('sal', 1);" />
         <input type = "button" id = "sale_n" value = "판매 안함" onclick = "state_change('sal', 0);" />
         <input type = "button" id = "del" value = "삭제" onclick = "state_change('del', 1);" />
      </div>
      <table cellspacing = "0" class = "tablesorter" id = "data_part">
      	<thead>
         <tr>
            <th>체크</th>
            <th>상품번호</th>
            <th>분류</th>
            <th>상품명</th>
            <th>이미지</th>
            <th>가격(원가)</th>
            <th>재고</th>
            <th>진열 상태</th>
            <th>판매 상태</th>
            <th>총 누적판매량</th>
         </tr>
        </thead>
        <tbody>
         <c:forEach var="product" items="${p_list}">
         <tr>
            <td><input type = "checkbox" name = "chk" id = "chk" value = "${product.product_no}" /></td>
            <td>${product.product_no}</td>
            <td>${product.category_nm}</td>
            <td><a href = "product.nm?page=modify&no=${product.product_no}">${product.product_name}</a></td>
            <td><img src = "/soap/resources/product_images/${product.represent_img}" alt = "${product.product_name}" width = "50" /></td>
            <td>${product.selling_price}(${product.cost_price})</td>
            <td>${product.stock}</td>
            <td>${product.display_state eq 1 ? 'Y' : 'N'}</td>
            <td>${product.sale_state eq 1 ? 'Y' : 'N'}</td>
            <td>${product.all_sells}</td>
         </tr>
         </c:forEach>
         </tbody>
      </table>
      <div id = "buttons">
         <span>선택한 상품을 </span>
         <input type = "button" id = "dis_y" value = "진열" onclick = "state_change('dis', 1);" />
         <input type = "button" id = "dis_n" value = "진열 안함" onclick = "state_change('dis', 0);" />
         <input type = "button" id = "sale_y" value = "판매" onclick = "state_change('sal', 1);" />
         <input type = "button" id = "sale_n" value = "판매 안함" onclick = "state_change('sal', 0);" />
         <input type = "button" id = "del" value = "삭제" onclick = "state_change('del', 1);" />
      </div>
</html>