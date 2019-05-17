package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.msproject.dao.LoginDAO;
import com.msproject.dto.MemberDTO;

public class LoginAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션을 사용하기 위해 session 객체생성
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		LoginDAO lDao = LoginDAO.getInstance();
		MemberDTO mDto = lDao.loginCheck(id,pw);
		String message = null;
		
		if(mDto!=null) {
			session.removeAttribute("loginUser");
			session.setAttribute("loginUser", mDto);
			message = "1";
		}else {
			message = "-1";
		}
		
		JSONObject jObj = new JSONObject();
		jObj.put("message", message);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}
