package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msproject.dao.MemberDAO;
import com.msproject.dto.MemberDTO;

public class DropMemberPlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.ms";
		
		HttpSession session = request.getSession();
		MemberDTO mDto = (MemberDTO) session.getAttribute("loginUser");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.memDelete(mDto.getId());
		
		if(result > 0) {
			session.invalidate();
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}

}
