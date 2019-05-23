package com.msproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.dao.GoodDAO;
import com.msproject.dto.GoodDTO;

public class GoodSwitchAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =request.getParameter("id");
		int bno =  Integer.parseInt(request.getParameter("bno"));
		GoodDAO gDao = GoodDAO.getInstance();
		GoodDTO userGood = new GoodDTO(id, bno);
		GoodDTO gDto = gDao.getGood(userGood);
		
		if(gDto == null) {
			gDao.setGood(userGood);
		}else {
			gDao.removeGood(userGood);
		}
		
		return null;
	}

}
