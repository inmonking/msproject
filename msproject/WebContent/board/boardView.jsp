<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><style type="text/css">
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
	<div class="viewBody" style="width: 850px;margin: 80px auto 0px; background-color: white; border: 1.5px solid black; border-radius: 10px; padding: 20px">
		<div><h3 style="font-size: 35px; margin: 10px 0px 20px; font-weight: bold;">게시글 조회</h3></div>
		<div style="width: 840px; margin:0 auto; border-radius: 5px 5px 0px 0px; overflow: hidden;">
			<div style="height: 40px; width: 100%; color: white; background-color:#747474; border-bottom: 1px solid lightgray">
				<span style="margin: 0 20px; font-size: 20px;">TITLE</span>
				<div name="" style="display: inline-block;padding-left: 10px;width:86%;margin-top: 10px; border: none; outline: none; font-size: 15px; border-radius: 5px; color: white;">더미 데이터 - 제목</div>
			</div>
			<div style="font-size: 15px">
				<div style="padding: 10px 20px;background-color:#747474;color: white;">
					<span>작성자</span><span style="margin-left: 10px;">누구</span>
					<span style="float: right; font-size: 10px; line-height: 25px; display: flex; flex-direction: column; margin-top: -9px">
						<span style="font-size: 14px">2019.05.17</span>
						<span style="margin-top: -8px; text-align: right;">
							<span>조회</span><span>1</span>
							<span>추천</span><span>1</span>
						</span>
					</span>
					</div>
				<div style="padding: 10px; border: 1px solid #747474">
					<div style="width: 100%; min-height: 200px; box-sizing: border-box; border: none">더미 데이터 - 내용</div>
					<div style="width: 100%; font-size: 12px; border-top: 1px solid lightgray; border-bottom: 1px solid lightgray;margin: 10px 0; padding-bottom: 10px;">
						첨부 파일
						<ul style="font-size: 10px; margin: 5px 20px 0px;">
							<li><a href="#">첨부파일이 있다면 여기에 뜰 것</a></li>
						</ul>
					</div>
					<div style="width: 100%; text-align: center; font-size: 20px;">
						<div style="border: 1px solid #747474; display: inline-block; border-radius: 50px; width: 40px; height: 40px; display: flex;justify-content: center;line-height: 45px; margin: 0 auto">
							<span><i class="fas fa-heart"></i></span>
						</div>
					</div>
				</div>
			</div>
			<div style="width: 100%; height: 50px; border: 1px solid #747474; border-top: none; box-sizing: border-box; display: flex; align-items: center;">
				<div style="width:50%; margin-left: 10px;">
					<span style="background-color: #747474;text-align: center;padding: 8px; border-radius: 10px; color: white">목록으로</span>
				</div>
				<div style="width:50%; margin-right: 10px; text-align: right;">
					<span style="background-color: #747474;text-align: center;padding: 8px; border-radius: 10px; color: white">수정</span>
					<span style="background-color: #747474;text-align: center;padding: 8px; border-radius: 10px; color: white">삭제</span>
					<span style="background-color: #747474;text-align: center;padding: 8px; border-radius: 10px; color: white">글쓰기</span>
				</div>
			</div>
		</div>
	</div>
	<div style="width: 850px;margin: 30px auto 100px; background-color: white; border: 1.5px solid black; border-radius: 10px; padding: 20px;">
		<div style="height: 30px; background-color: black; margin: -20px; margin-bottom: 20px;border-radius: 5px 5px 0px 0px;"><span style="line-height: 30px;margin-left: 20px; color: white;font-weight: 20px; font-size: 1.2em">댓글<span style="margin-left: 5px">3</span></span><span style="line-height: 30px;color: white;font-weight: 20px; font-size: 1.2em; float: right; margin-right: 20px;"><i class="fas fa-sync-alt"></i></span></div>
		<div style="width:700px; border:1px solid #747474; border-top:10px solid #747474; padding: 10px; border-radius: 5px; margin-bottom: 20px; box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);">
			<span>댓글-조회자</span>
			<span style="float: right;">2019.05.17</span>
			<div style="width: 690px; border:1px solid #747474; margin-top: 10px; padding: 15px 5px; border-radius: 5px">댓글을 확인함</div>
		</div>
		<div style="width:700px; border:1px solid orange; border-top:10px solid orange; padding: 10px; border-radius: 5px; margin-bottom: 20px; box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);">
			<span>댓글-작성자</span>
			<span style="float: right;">2019.05.17</span>
			<div style="width: 690px; border:1px solid #747474; margin-top: 10px; padding: 15px 5px; border-radius: 5px;">댓글을 확인함</div>
		</div>
		<div style="width:700px; border:1px solid mediumseagreen; border-top:10px solid mediumseagreen; padding: 10px; border-radius: 5px; margin-bottom: 20px; box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19); margin-left: 125px">
			<span>댓글-본인</span>
			<span style="float: right;">2019.05.17</span>
			<div style="width: 690px; border:1px solid #747474; margin-top: 10px; padding: 15px 5px; border-radius: 5px;">댓글을 확인함</div>
		</div>
		<hr style="border: 1px solid darkgray">
		<div style="width:700px; border:1px solid mediumseagreen; border-top:10px solid mediumseagreen; padding: 10px; border-radius: 5px; margin-bottom: 20px; box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19); margin-left: 125px">
			<span>작성자</span>
			<textarea style="width: 690px; border:1px solid #747474; margin-top: 10px; padding: 15px 5px; border-radius: 5px;">댓글을 작성함</textarea>
			<div style="text-align: right;">
				<span style="background-color: mediumseagreen;text-align: center;padding: 6px; border-radius: 10px; color: white; font-size: 13px">댓글 쓰기</span>
			</div>
		</div>
	</div>
</body>
</html>