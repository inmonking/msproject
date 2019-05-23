package com.msproject.action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.msproject.dao.BoardDAO;
import com.msproject.dao.GoodDAO;
import com.msproject.dto.GoodDTO;

public class GoodAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String id = request.getParameter("id");
		HashMap<String, String> hMap = new HashMap<String, String>();
		
		GoodDAO gDto = GoodDAO.getInstance();
		GoodDTO result = gDto.getGood(new GoodDTO(id, bno));
		int GoodCnt = gDto.GoodCnt(bno);
		
		
		hMap.put("bno", bno+"");
		hMap.put("cnt", GoodCnt+"");
		
		BoardDAO bDao = BoardDAO.getInstance();
		int gResult = bDao.goodCnt(hMap);
		JSONObject jObj = new JSONObject();
		if(result != null) {
			jObj.put("result", "1");
		}else {
			jObj.put("result", "0");
		}
		jObj.put("GoodCnt", GoodCnt);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}
