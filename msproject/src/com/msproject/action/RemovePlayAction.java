package com.msproject.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.common.Constants;
import com.msproject.dao.BoardDAO;

public class RemovePlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = request.getParameter("filename");
		if(!filename.equals("-")) {
			File file = new File(Constants.UPLOAD_PATH+filename);
			file.delete();
		}
		// 게시글 삭제
		String bno = request.getParameter("bno");
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.removeBoard(bno);
		
		String url = "boardList.ms";
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
	}

}
