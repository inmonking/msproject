package com.msproject.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.dao.ReplyDAO;
import com.msproject.dto.ReplyDTO;

public class CommentListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "board/commentlist.jsp";
		
		String bno = request.getParameter("bno");
		System.out.println("게시글번호: "+bno);
		
		ReplyDAO rDao = ReplyDAO.getInstance();
		List<ReplyDTO>list = rDao.replyList(bno);
		
		request.setAttribute("replyList", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
