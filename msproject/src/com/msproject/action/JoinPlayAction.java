package com.msproject.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msproject.dao.MemberDAO;
import com.msproject.dto.MemberDTO;

public class JoinPlayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.ms";
		Map<String, String[]> map= request.getParameterMap();
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = new MemberDTO();
		for (String key : map.keySet()) {
			String[] value = map.get(key);
			for (String string : value) {
				System.out.println(key+" : "+string);
			}
		}
		ActionForward forward = new ActionForward();
		mDao.memInsert(new MemberDTO(map.get("uid")[0], 
				map.get("upw")[0],
				map.get("uname")[0], 
				map.get("uphone")[0],
				map.get("address_postcode")[0], 
				map.get("address_basic")[0], 
				map.get("address_detail")[0], 
				map.get("birth_yy")[0], 
				map.get("birth_mm")[0], map.get("birth_dd")[0]));
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
	}

}
