package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getHeader("referer");
		System.out.println(url);
		
		HttpSession session = request.getSession();
		
		if(session!=null) {
			session.invalidate();
		}
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
	}

}
