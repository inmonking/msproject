package com.msproject.action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.msproject.dao.BoardDAO;

public class BoardGoodAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bno = request.getParameter("bno");
		String id = request.getParameter("id");
		System.out.println("bno = "+bno+" id = "+id);
		
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("bno", bno);
		hMap.put("id",id);
		BoardDAO bDao = BoardDAO.getInstance();
		String result = bDao.goodCntInfo(hMap);
		System.out.println(hMap.toString());
		if(result == null) {
			result = "2";
		}
		
		JSONObject jObj = new JSONObject();
		jObj.put("result", result);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}
