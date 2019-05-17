<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding|Sunflower:300');
	.viewBody{
		margin:0;
		padding: 0;
		font-family: 'Nanum Gothic Coding', monospace;
		font-weight: bold;
	}
</style>
</head>
<body>
<%@ include file="../include/header.jsp" %>
	<div class="viewBody" style="width: 850px;height: ;margin: 80px auto 100px; background-color: white; border: 1.5px solid black; border-radius: 10px; padding: 20px">
		<div><h3 style="font-size: 35px; margin: 10px 0px 20px; font-weight: bold;">게시글 수정</h3></div>
		<div style="width: 800px; margin:0 auto; border-radius: 10px 10px 0px 0px; overflow: hidden;">
			<div style="height: 40px; width: 100%; color: white; background-color:#747474; border-bottom: 1px solid lightgray">
				<span style="margin: 0 20px; font-size: 20px;">TITLE</span>
				<input type="text" name="" placeholder="제목을 입력해주세요" style="padding-left: 10px;width:86%; height: 30px;margin-top: 5px; border: none; outline: none; font-size: 15px; border-radius: 5px;">
			</div>
			<div style="font-size: 15px">
				<div style="padding: 10px 20px;background-color:#747474;color: white;">CONTENT<span style="float: right;margin-left: 10px;">누구</span><span style="float: right;">WRITER</span></div>
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
</html>