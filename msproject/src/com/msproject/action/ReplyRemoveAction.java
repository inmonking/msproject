package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.dao.BoardDAO;
import com.msproject.dao.ReplyDAO;
import com.msproject.dto.ReplyDTO;

public class ReplyRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rno = Integer.parseInt(request.getParameter("rno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		ReplyDTO rDto = new ReplyDTO();
		rDto.setRno(rno);
		rDto.setBno(bno);
		ReplyDAO rDao = ReplyDAO.getInstance();
		BoardDAO bDao = BoardDAO.getInstance();
		int result = rDao.replyRemove(rDto);
		if(result>0) {
			System.out.println("삭제완료");
			result = bDao.replyUpdate(bno);
		}else {
			System.out.println("삭제실패");
		}
		return null;
	}

}
