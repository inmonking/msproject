package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.msproject.dao.MemberDAO;
import com.msproject.dto.MemberDTO;

public class PwCheckAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String values = null;
		System.out.println("pw"+pw);
		
		MemberDTO mDto = (MemberDTO) request.getSession().getAttribute("loginUser");
		if(mDto.getId().equals(id)&&mDto.getPw().equals(pw)) {
			values = "1";
		}else {
			values = "-1";
		}
		
		JSONObject jObj = new JSONObject();
		jObj.put("message", values);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}
