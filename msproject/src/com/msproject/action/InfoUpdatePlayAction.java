package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msproject.dao.LoginDAO;
import com.msproject.dao.MemberDAO;
import com.msproject.dto.MemberDTO;

public class InfoUpdatePlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.ms";
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String birth_year = request.getParameter("birth_year");
		String birth_month = request.getParameter("birth_month");
		String birth_day = request.getParameter("birth_day");
		String phone = request.getParameter("phone");
		
		MemberDTO mDto = new MemberDTO();
		mDto.setId(id);
		mDto.setName(name);
		mDto.setBirth_year(birth_year);
		mDto.setbirth_month(birth_month);
		mDto.setBirth_day(birth_day);
		mDto.setPhone(phone);
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.memUpdate(mDto);
		
		if(result > 0) {
			mDto = (MemberDTO) request.getSession().getAttribute("loginUser");
			LoginDAO lDao = LoginDAO.getInstance();
			mDto = lDao.loginCheck(mDto.getId(), mDto.getPw());
			HttpSession session = request.getSession();
			session.removeAttribute("loginUser");
			session.setAttribute("loginUser",mDto);
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		
		return forward;
	}

}
