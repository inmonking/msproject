package com.msproject.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.dao.ProductDAO;
import com.msproject.dto.ProductDTO;

public class IndexAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.jsp";
		
		ProductDAO pDao = ProductDAO.getInstance();
		List<ProductDTO> bList = pDao.bestList();
		request.setAttribute("bestList", bList);
		bList = pDao.newList();
		request.setAttribute("newList", bList);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
