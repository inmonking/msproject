package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.dao.BoardDAO;
import com.msproject.dao.ReplyDAO;
import com.msproject.dto.ReplyDTO;

public class ReplyAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bno = Integer.parseInt(request.getParameter("re_bno"));
		String writer = request.getParameter("re_writer");
		String content = request.getParameter("re_textarea");
		
		ReplyDTO rDto = new ReplyDTO(content, writer, bno);
		ReplyDAO rDao = ReplyDAO.getInstance();
		BoardDAO bDao = BoardDAO.getInstance();
		int result = rDao.replyAdd(rDto);
		if(result>0) {
			result = bDao.replyUpdate(bno);
			System.out.println("작성완료");
		}else {
			System.out.println("작성실패");
		}
		return null;
	}

}
