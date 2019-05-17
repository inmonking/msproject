package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msproject.dao.MemberDAO;
import com.msproject.dto.MemberDTO;

public class PwUpdatePlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.ms";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.pwUpdate(id, pw);
		
		if(result > 0) {
			HttpSession session = request.getSession();
			MemberDTO mDto = mDao.memOne(id);
			
			session.removeAttribute("loginUser");
			session.setAttribute("loginUser", mDto);
		}
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}

}
