package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.dao.BoardDAO;
import com.msproject.dto.BoardDTO;

public class InsertPlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "boardList.ms";
		
		BoardDTO bDto = new BoardDTO();
		String title = request.getParameter("title");
		System.out.println(title);
		bDto.setTitle(request.getParameter("title"));
		bDto.setContent(request.getParameter("content"));
		bDto.setWriter(request.getParameter("writer"));
		
		System.out.println(bDto.toString());
		BoardDAO bDao = BoardDAO.getInstance();
		int result = bDao.insertBoard(bDto);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
	}
}
