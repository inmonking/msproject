package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.msproject.dao.MemberDAO;


public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("id>>"+id);
		
		MemberDAO mDao = MemberDAO.getInstance();
		String result = mDao.idCheck(id);
		
		
		JSONObject jobj = new JSONObject();
		jobj.put("message",result);
		jobj.put("id", id);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jobj);
		
		return null;
	}

}
