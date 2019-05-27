package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msproject.dao.BoardDAO;
import com.msproject.dto.BoardDTO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/boardUpdate.jsp";
		
		String bno = request.getParameter("bno");
		BoardDAO bDao = BoardDAO.getInstance();
		HttpSession session = request.getSession();
		
		//게시글 1건(상세 조회)
		BoardDTO bDto = bDao.view(bno);
		request.setAttribute("one", bDto);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
