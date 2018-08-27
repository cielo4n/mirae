<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>자연맘</title>
  <script type = "text/javascript" src = "http://code.jquery.com/jquery-1.12.0.min.js"> </script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script>
	$(document).ready(function(){
		
		// 초기화
		$("#review tr:not(:nth-child(2)):nth-child(even) td").css("display", "none");	

		$("#review tr:gt(1) td a").click(function(){
			if ($(this).parent().parent().next().children("td").css("display") == "none")
			{
				$("#review tr:not(:nth-child(2)):nth-child(even) td").slideUp(0);	
				$(this).parent().parent().next().children("td").slideDown(0);		
				$("#review tr:not(:nth-child(2)):nth-child(even) td").removeClass("selected");		
				$(this).parent().parent().next().children("td").addClass("selected");			
			}
			else
			{
				$("#review tr:not(:nth-child(2)):nth-child(even) td").slideUp(0);		
				$(this).parent().parent().next().children("td").removeClass("selected");
				$("#review tr:not(:nth-child(2)):nth-child(even) td").css("display", "none");
			}
		}).mouseover(function(){
			$(this).addClass("over");
		}).mouseout(function(){
			$(this).removeClass("over");
		});
	});
	
	function write_popup()
	{
		window.open("review_write_popup.jsp", "카테고리 등록", "width = 800px, height = 500px, left = 200px, top = 200px, scrollbars = no, toobar = no, menubar = no, status = no, location = no, resizeable = no");
	}
	
</script>

<style type = "text/css">

	#in 
	{ 
		width : 1100px; 
		margin : 0 auto; padding: 0px; 
		color: #85858d; 
		font-style: bold;
		font-family : "나눔바른고딕", "맑은 고딕"; 
	}
		
	#in h2 
	{ 
		margin : 5px; 
		color: #004523;
	}
	
	#review a { text-decoration : none; color : black; }
	#review a:hover  { opacity : 0.7; }
		
	#review { width: 100%; padding : 0px; }
	#review tr { border-top : 1px solid grey; }
	#review tr:nth-child(2) td { background-color: #CCCCCC; color: white; font-style:bold; }
	#review tr:not(:first-child) td { color: black; }
	#review tr td { border-bottom : 1px solid grey; }
	#review tr td { padding : 5px; color: black; border-bottom : 1px solid lightgrey;}	
	
	#review tr:nth-child(2), #sub_title { text-align: center; }
	#write { text-align: right; }
	
	#write input
	{
		padding : 5px 20px; 
		background-color : #85858D;
		color : white;
		font-size : 16px;
		border-radius : 20px;
		border : 0px;
		margin-right : 5px;
		margin-top : 10px;
		margin-left : 10px;
	}
	#write input:hover, .review_buttons input:hover, 
	.reply_button input:hover, .reply_buttons input:hover, i:hover { opacity : 0.7; }
	
	.review td .review_body:not(:last-child) { border-bottom : 1px solid lightgrey; padding-bottom: 5px; margin-bottom: 5px; }
	.reply_content { background : #EAEAEA; margin : 0 20px; padding: 5px; border-bottom: 1px dotted white; }
	.review_content { padding: 20px 50px; }
	.review td .review_body:last-child { border-bottom: 1px solid lightgrey; padding-bottom: 10px; margin-bottom: 10px; }
	.review_content, .reply_write { display:inline-block; width : 75%; vertical-align: middle; }
	.review_buttons, .reply_button { display:inline-block; text-align:center; width : 15%; }	
	.review_buttons { margin-bottom: 5px; }
	
	#line { margin-top: 10px; border-top: 1px solid lightgrey; }
	.reply_write { padding: 10px; }
	.reply_write { text-align:right; }
	.reply_write textarea { width: 95%; resize: none; }
	.reply_button input, .review_buttons input
	{
		padding: 3px;
		background : #cec5ce;
		border-radius : 5px;
		color : #635353;
		border : 1px solid #85858d;
		margin-right: 5px;
	}
	
	.reply_content div { display : inline-block; }
	.reply_content .reply_writer { width: 15%; text-align:center; }
	.reply_content .reply_sub { width: 65%; }
	.reply_content .reply_date { width : 10%; text-align: right; }
	.reply_content .reply_buttons { width : 5%; text-align:center; }
	
	.page { text-align : center; margin-bottom: 80px; margin-top: 50px; }
	</style>
 </head>
 <body>
<!--  Start header --------------------------------------------------------------------->
<header>

</header>
<!-----------------------------------------------------------end header ----------->	
<!---Start container----------------------------------------------------------------->
 
 <div id ="in">
 
 <h2>구매 후기</h2>
  	<table id="review" cellspacing="0">
		<tr id = "write">
			<td colspan="5">
				<input type = "button" value = "글쓰기" onclick = "write_popup();" />
			</td>
		</tr>
		<tr id = "title">
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>만족도</td>
		</tr>
		<tr id = "sub_title">
			<td><a href="javascript:void();">향이 너무 좋아요~</a></td>
			<td>hook4u</td>
			<td>2015/06/17</td>
			<td>★★★★☆</td>
		</tr>
		<tr id = "sub_content">
			<td colspan = "5">
				<div class = "review_body">
					<div class = "review_content">
					 	향기가 좋아요~
					 	향기가 좋아요~향기가 좋아요~향기가 좋아요~향기가 좋아요~				
						향기가 좋아요~향기가 좋아요~향기가 좋아요~향기가 좋아요~
						향기가 좋아요~향기가 좋아요~향기가 좋아요~향기가 좋아요~
						향기가 좋아요~향기가 좋아요~향기가 좋아요~향기가 좋아요~
						향기가 좋아요~향기가 좋아요~향기가 좋아요~향기가 좋아요~
						향기가 좋아요~향기가 좋아요~향기가 좋아요~향기가 좋아요~
						향기가 좋아요~!향기가 좋아요~!!!향기가 좋아요~!향기가 좋아요~
					 </div>
					 <div class = "review_buttons">
					 	<input type = "button" value = "수정" />
						<input type = "button" value = "삭제" />
					</div>		 			 
				</div>
				<div class = "reply_body">
					<div class = "reply_content">
						<div class = "reply_writer">
							자연맘
						</div>
						<div class = "reply_sub">
							구매해주셔서 고맙습니다. ^^
						</div>
						<div class = "reply_date">
							2016/03/22
						</div>
						<div class = "reply_buttons">
							<i class="fa fa-times-circle"></i>
						</div>
					</div>
					<div class = "reply_content">
						<div class = "reply_writer">
							hook4u
						</div>
						<div class = "reply_sub">
							또 살게여~
						</div>
						<div class = "reply_date">
							2016/03/22
						</div>
						<div class = "reply_buttons">
							<i class="fa fa-times-circle"></i>
						</div>
					</div>
					<div id = "line">
						<div class = "reply_write">
							<textarea rows="4" cols="100" ></textarea>
						</div>
						<div class = "reply_button">
							<input type = "button" value = "댓글등록" />
						</div>
					</div>
				</div>
			</td>
		<tr id = "sub_title">
			<td><a href="javascript:void();">피부가 부들부들해요~~</a></td>
			<td>agamom</td>
			<td>2015/06/17</td>
			<td>★★★★★</td>
		</tr>
		<tr id = "sub_content">
			<td colspan = "5" >
				<div class = "review_body">
					<div class = "review_content">
					 	부들부들해져여~~~~~짱좋
					 </div>
					 <div class = "review_buttons">
						<input type = "button" value = "수정" />
						<input type = "button" value = "삭제" />
					</div>		 			 
				</div>
				<div class = "reply_body">
					<div class = "reply_content">
						<div class = "reply_writer">
							자연맘
						</div>
						<div class = "reply_sub">
							구매해주셔서 고맙습니다. ^^
						</div>
						<div class = "reply_date">
							2016/03/22
						</div>
						<div class = "reply_buttons">
							<i class="fa fa-times-circle"></i>
						</div>
					</div>
					<div id = "line">
						<div class = "reply_write">
							<textarea rows="4" cols="100" ></textarea>
						</div>
						<div class = "reply_button">
							<input type = "button" value = "댓글등록" />
						</div>
					</div>
				</div>
			</td>
		</tr>
		<tr id = "sub_title">
			<td><a href="javascript:void();">거품이 까매요...</a></td>
			<td>maniac</td>
			<td>2015/06/17</td>
			<td>★★★☆☆</td>
		</tr>
		<tr id = "sub_content">
			<td colspan = "5" >
				<div class = "review_body">
					<div class = "review_content">
					 	원래 이렇게 까매요...?
					 </div>
					 <div class = "review_buttons">
						<input type = "button" value = "수정" />
						<input type = "button" value = "삭제" />
					</div>		 			 
				</div>
				<div class = "reply_body">
					<div class = "reply_content">
						<div class = "reply_writer">
							자연맘
						</div>
						<div class = "reply_sub">
							구매해주셔서 고맙습니다. ^^
						</div>
						<div class = "reply_date">
							2016/03/22
						</div>
						<div class = "reply_buttons">
							<i class="fa fa-times-circle"></i>
						</div>
					</div>
					<div id = "line">
						<div class = "reply_write">
							<textarea rows="4" cols="100" ></textarea>
						</div>
						<div class = "reply_button">
							<input type = "button" value = "댓글등록" />
						</div>
					</div>
				</div>
			</td>
		</tr>

	</table>
		<div class="page">
			<a href="#">〈</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#">〉</a>
		</div>
	</div>
 </body>
</html>
