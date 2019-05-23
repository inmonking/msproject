<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String referer = request.getHeader("referer");
%>
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
	.fullheart{
		display: none;
	}
	.heart_ico{
		transition: 0.2s;
	}
	.heart_ico:hover{
		transform: scale(1.2);
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
				<div name="" style="display: inline-block;padding-left: 10px;width:86%;margin-top: 10px; border: none; outline: none; font-size: 15px; border-radius: 5px; color: white;">${one.title}</div>
			</div>
			<div style="font-size: 15px">
				<div style="padding: 10px 20px;background-color:#747474;color: white;">
					<span>작성자</span><span style="margin-left: 10px;">${one.writer}</span>
					<span style="float: right; font-size: 10px; line-height: 25px; display: flex; flex-direction: column; margin-top: -9px">
					<fmt:formatDate value="${one.regdate }" pattern="yyyy년 MM월 dd일" var="regdate"/>
						<span style="font-size: 14px">${regdate}</span>
						<span style="margin-top: -8px; text-align: right;">
							<span>조회</span><span>${one.viewcnt }</span>
							<span>추천</span><span>${one.goodcnt }</span>
						</span>
					</span>
					</div>
				<div style="padding: 10px; border: 1px solid #747474">
					<div style="width: 100%; min-height: 200px; box-sizing: border-box; border: none">${one.content }</div>
					<div style="width: 100%; font-size: 12px; border-top: 1px solid lightgray; border-bottom: 1px solid lightgray;margin: 10px 0; padding-bottom: 10px;">
						첨부 파일
						<ul style="font-size: 10px; margin: 5px 20px 0px;">
							<li><a href="#">첨부파일이 있다면 여기에 뜰 것</a></li>
						</ul>
					</div>
					<div style="width: 100%; text-align: center; font-size: 20px;">
					<c:if test="${!empty sessionScope.loginUser }">
						<div style="border: 1px solid #747474; display: inline-block; border-radius: 50px; width: 40px; height: 40px; display: flex;justify-content: center;line-height: 45px; margin: 0 auto">
							<span class="fullheart heart_ico"><i class="fas fa-heart"></i></span><span class="emptyheart heart_ico"><i class="far fa-heart"></i></span>
						</div>
					</c:if>
					</div>
				</div>
			</div>
			<div style="width: 100%; height: 50px; border: 1px solid #747474; border-top: none; box-sizing: border-box; display: flex; align-items: center;">
				<div style="width:50%; margin-left: 10px;">
					<span id="returnGo" style="background-color: #747474;text-align: center;padding: 8px; border-radius: 10px; color: white">목록으로</span>
				</div>
				<div style="width:50%; margin-right: 10px; text-align: right;">
				
				<c:if test="${sessionScope.loginUser.id == one.writer}">
					<span style="background-color: #747474;text-align: center;padding: 8px; border-radius: 10px; color: white">수정</span>
					<span style="background-color: #747474;text-align: center;padding: 8px; border-radius: 10px; color: white">삭제</span>
				</c:if>
					<span style="background-color: #747474;text-align: center;padding: 8px; border-radius: 10px; color: white">글쓰기</span>
				</div>
			</div>
		</div>
	</div>
	<div id="reply_wrap">
		<div id="commentList">
			
		</div>
	</div>
	<script type="text/javascript">
		goodInfo();
		$(document).ready(function() {
			comment_list();
			$('#returnGo').click(function(){
				location.href = "<%=referer%>";
			});
			$(".heart_ico").click(function(event) {
				goodSwitch();
				goodInfo();
			});
		});
		function comment_list(){
			$.ajax({
				type: "post",
				url: "commentlist.ms",
				data: "bno=${one.bno}",
				success: function(result){
					$("#commentList").html(result);
				}
			});
		}

		function goodSwitch(){
			$.ajax({
				url: '${path}/boardGoodSwitch.ms',
				type: 'post',
				dataType: 'json',
				data: "bno=${one.bno}&id=${sessionScope.loginUser.id}",
				success: function(data){
				}
			});
		}

		function goodInfo(){
			$.ajax({
				url: '${path}/boardGood.ms',
				type: 'post',
				dataType: 'json',
				data: "bno=${one.bno}&id=${sessionScope.loginUser.id}",
				success: function(data){
					if(data.result == 1){
						$('.fullheart').css('display', 'block');
						$('.emptyheart').css('display', 'none');
					}else if(data.result == 2){
						$('.emptyheart').css('display', 'block');
						$('.fullheart').css('display', 'none');
					}else{
						$('.emptyheart').css('display', 'block');
						$('.fullheart').css('display', 'none');
					}
				}
			});
		}
	</script>
</body>
</html>