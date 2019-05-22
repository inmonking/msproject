package com.msproject.action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.msproject.dao.BoardDAO;

public class BoardGoodSwitchAjaxAction implements Action {

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
		String switchResult = "";
		System.out.println(result);
		if(result == null) {
			hMap.put("good", "1");
			bDao.goodInsert(hMap);
			System.out.println("새롭게 1 추가");
		}else if(result.equals("0")) {
			hMap.put("good", "1");
			bDao.goodSwitch(hMap);
			System.out.println("0에서 1로 스위칭");
		}else if(result.equals("1")){
			hMap.put("good", "0");
			bDao.goodSwitch(hMap);
			System.out.println("1에서 0로 스위칭");
		}
		
		
		return null;
	}

}
