<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.reply_body_viewer{
		width:700px; 
		border:1px solid #747474; 
		border-top:10px solid #747474; 
		padding: 10px; 
		border-radius: 5px; 
		margin-bottom: 20px; 
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
	}
	
	.reply_body_master{
		width:700px; 
		border:1px solid orange; 
		border-top:10px solid orange; 
		padding: 10px; 
		border-radius: 5px; 
		margin-bottom: 20px; 
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19);
	}
	
	.reply_body_user{
		width:700px; 
		border:1px solid mediumseagreen; 
		border-top:10px solid mediumseagreen; 
		padding: 10px; 
		border-radius: 5px; 
		margin-bottom: 20px; 
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2), 0 4px 20px 0 rgba(0,0,0,0.19); 
		margin-left: 125px;
	}
	
	.reply_content{
		width: 690px; 
		border:1px solid #747474; 
		margin-top: 10px; 
		padding: 15px 5px; 
		border-radius: 5px;
	}
</style>
</head>
<body>
<%@ include file="../include/common.jsp" %>
	<div style="width: 850px;margin: 30px auto 100px; background-color: white; border: 1.5px solid black; border-radius: 10px; padding: 20px;">
		<div style="height: 30px; background-color: black; margin: -20px; margin-bottom: 20px;border-radius: 5px 5px 0px 0px;"><span style="line-height: 30px;margin-left: 20px; color: white;font-weight: 20px; font-size: 1.2em">댓글<span style="margin-left: 5px">3</span></span><span style="line-height: 30px;color: white;font-weight: 20px; font-size: 1.2em; float: right; margin-right: 20px;"><i class="fas fa-sync-alt"></i></span></div>
		
	<c:forEach items="${replyList }" var="replyview">
		<c:if test="${sessionScope.loginUser.id == replyview.writer }">
			<div class="reply_body_user">
				<span>${replyview.writer }</span>
				<span style="float: right;">${replyview.regdate}</span>
				<div class="reply_content">${replyview.content}</div>
			</div>
		</c:if>
		<c:if test="${sessionScope.loginUser.id != replyview.writer }">
			<div class="reply_body_viewer">
				<span>${replyview.writer }</span>
				<span style="float: right;">${replyview.regdate}</span>
				<div class="reply_content">${replyview.content}</div>
			</div>
		</c:if>
	</c:forEach>
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