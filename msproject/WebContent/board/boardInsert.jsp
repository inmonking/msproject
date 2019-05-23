<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>게시글 작성</title>
</head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap.css?v=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding|Sunflower:300');
	.viewBody{
		margin:0;
		padding: 0;
		font-family: 'Nanum Gothic Coding', monospace;
		font-weight: bold;
	}
</style>
<body>
	<%@ include file="../include/header.jsp" %>
	<div class="viewBody" style="width: 850px;height: ;margin: 80px auto 100px; background-color: white; border: 1.5px solid black; border-radius: 10px; padding: 20px">
		<div><h3 style="font-size: 35px; margin: 10px 0px 20px; font-weight: bold;">게시글 작성</h3></div>
		<div style="width: 800px; margin:0 auto; border-radius: 10px 10px 0px 0px; overflow: hidden;">
			<div style="height: 40px; width: 100%; color: white; background-color:#747474; border-bottom: 1px solid lightgray">
				<span style="margin: 0 20px; font-size: 20px;">TITLE</span>
				<input type="text" name="" placeholder="제목을 입력해주세요" style="padding-left: 10px;width:86%; height: 30px;margin-top: 5px; border: none; outline: none; font-size: 15px; border-radius: 5px; color: black;">
			</div>
			<div style="font-size: 15px">
				<div style="padding: 10px 20px;background-color:#747474;color: white;">CONTENT<span style="float: right;margin-left: 10px;">${sessionScope.loginUser.id}</span><span style="float: right;">WRITER</span></div>
				<div style="padding: 10px; border: 1px solid #747474">
					<textarea style="width: 100%; height: 500px; box-sizing: border-box; resize: none; border: none"></textarea>
				</div>
			</div>
			<div style="width: 100%; height: 50px; border: 1px solid #747474; border-top: none; box-sizing: border-box; display: flex; align-items: center;">
				<div style="width:50%; margin-left: 10px;"><input type="file" name=""></div>
				<div style="width:50%; margin-right: 10px;"><span style="background-color: #747474;text-align: center;padding: 8px; border-radius: 10px; float: right; color: white">SUBMIT</span></div>
			</div>
		</div>
	</div>
</body>
</body>
</html>