<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>게시판 목록</title>
</head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding|Sunflower:300');
	@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding|Sunflower:300');
	.viewBody{
		margin:0;
		padding: 0;
		font-family: 'Nanum Gothic Coding', monospace;
		font-weight: bold;
	}
	#board_sort > span{
		padding: 5px;
		border: 1px solid darkgray;
		font-size: 0.8em;
		border-radius: 5px;
		cursor: pointer;
		font-weight: bold;
	}
	#board_sort span:nth-child(1){
		background-color: #5D5D5D;
		color: white;
	}
	.board_content{
		margin: 0 auto;
		width: 1000px;
		border-collapse: collapse;
	}
	.board_content tr:nth-child(odd){
		background-color: #E4E4E4;
	}
	
	.board_content tr:hover{
		background-color: #D9D9D9;
	}

	.board_content td,th{
		border: 2px solid white;
	}
	.board_content th{
		height: 25px;
		padding: 5px;	
		background-color: #5D5D5D;
		color: white;
		font-size: 1.2em;
		text-align: center;
	}
	.board_content td{
		padding: 7px 10px;
		text-align: center;
		font-weight: bold;
	}
	.board_content td:nth-child(2){
		text-align: left;
	}
	.page_num > span{
		font-family: 'Sunflower', sans-serif;
		display: inline-block;
		width: 30px;
		border: 1px solid black;
		border-radius: 5px;
		cursor: pointer;
		user-select: none;
		font-weight: bold;
	}
	.fa-heart{
		font-size: 10px;
		margin-right: 2px;
	}
	.board_reply_cnt{
		margin: 0px 5px;
		background-color: tomato;
		color: white;
		border-radius: 20px;
		width: 15px;
		height: 15px;
		line-height: 15px;
		text-align: center;
		display: inline-block;
		font-weight: normal;
		font-size: 0.8em;
	}
	.board_ico_new{
		width: 40px;
		display: inline-block;
		margin: 0px 5px;
		border-radius: 10px;
		background-color: orange;
		color: white;
		text-align: center;
		height: 16px;
		line-height: 16px;
		font-size: 0.8em;
	}
</style>
<body>
	<%@ include file="../include/header.jsp" %>
	<div class="viewBody" style="width: 1040px;height: ;margin: 80px auto 100px; background-color: white; border: 1.5px solid black; border-radius: 10px; padding: 20px">
		<div><h3 style="font-size: 35px; margin: 10px 0px 20px; font-weight: bold">게시판</h3></div>
		<div>
			<span id="board_sort">
				<span id="board_sort_new">최신순</span>
				<span id="board_sort_good">추천순</span>
				<span id="board_sort_reply">댓글순</span>
				<span id="board_sort_cnt">조회순</span>
			</span>
			<span style="float: right;">
				<span id="board_insert" style="width: 200px; background-color: orange; border-radius: 25px; padding: 8px; color: white; font-weight: bold; font-size: 0.8em; cursor: pointer; user-select: none">게시글 등록</span>
			</span>
		</div>
		<div style="margin-top: 10px;">
			<table class="board_content">
				<tr>
					<th style="width: 50px">No.</th>
					<th style="width: 400px">제목</th>
					<th style="width: 120px">작성자</th>
					<th style="width: 130px">작성일</th>
					<th style="width: 60px">좋아요</th>
					<th style="width: 60px">조회수</th>
					<th style="width: 60px">첨부</th>
				</tr>
				<tr>
					<td>10</td>
					<td><span>더미데이터</span><span class="board_reply_cnt">2</span><span class="board_ico_new">New</span></td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td><i class="far fa-save"></i></td>
				</tr>
				<tr>
					<td>9</td>
					<td>더미데이터</td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td></td>
				</tr>
				<tr>
					<td>8</td>
					<td>더미데이터</td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td></td>
				</tr>
				<tr>
					<td>7</td>
					<td>더미데이터</td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td></td>
				</tr>
				<tr>
					<td>6</td>
					<td>더미데이터</td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td></td>
				</tr>
				<tr>
					<td>5</td>
					<td>더미데이터</td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td></td>
				</tr>
				<tr>
					<td>4</td>
					<td>더미데이터</td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td></td>
				</tr>
				<tr>
					<td>3</td>
					<td>더미데이터</td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td></td>
				</tr>
				<tr>
					<td>2</td>
					<td>더미데이터</td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td><i class="far fa-save"></i></td>
				</tr>
				<tr>
					<td>1</td>
					<td>더미데이터</td>
					<td>user1</td>
					<td>2019.05.16</td>
					<td><i class="fas fa-heart"></i><span>1<span></td>
					<td>1</td>
					<td></td>
				</tr>
			</table>
		</div>
		<div style="height: 29px;margin-top: 10px">
			<div style="display: flex; float: right;">
				<select style="height: 29px; width: 100px; border-radius: 20px;border: 1px solid lightgray; outline:none; box-sizing: border-box; font-weight: bold; user-select: none;">
					<option>-조건 선택-</option>
					<option>제목</option>
					<option>내용</option>
					<option>제목+내용</option>
					<option>작성자</option>
				</select>
				<input style="border-radius: 20px;height: 29px; width: 200px; border: 1px solid lightgray; outline:none; padding-left: 8px; box-sizing: border-box; margin-left: 10px; font-weight: bold" type="text" name="" placeholder="검색할 값을 입력하세요.">
				<span style="height: 29px; width: 60px; background-color: orange; line-height: 29px; text-align: center; border-radius: 20px; color: white;margin-left: 10px;font-weight: bold;">검색</span>
			</div>
		</div>
		<div class="page_num" style="text-align: center; margin-top: 10px">
			<span class="pre_page"><<</span>
			<span class="page_detail">1</span>
			<span class="page_detail">2</span>
			<span class="page_detail">3</span>
			<span class="page_detail">4</span>
			<span class="page_detail">5</span>
			<span class="page_detail">6</span>
			<span class="page_detail">7</span>
			<span class="page_detail">8</span>
			<span class="page_detail">9</span>
			<span class="page_detail">10</span>
			<span class="post_page">>></span>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#board_insert').click(function(event) {
				location.href = "../boardInsert.ms";
			});
		});
	</script>
</body>
</html>