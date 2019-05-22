package com.msproject.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.msproject.dto.BoardDTO;
import com.msproject.dto.CriteriaDTO;
import com.msproject.mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result = 0;
	List<BoardDTO> list = null;
	private BoardDTO bDto = null;
	
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	public List<BoardDTO> listAll(CriteriaDTO criDto) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("listAll", criDto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	//페이지네이션에 필요한 게시글 Total수 구하기
	public int totalCount(CriteriaDTO criDto) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("totalCount", criDto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}
	public BoardDTO view(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			bDto = sqlSession.selectOne("boardView", bno);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return bDto ;
	}
	public void viewCnt(String bno, HttpSession session) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			long update_time = 0;
			
			//null이면 => 처음 조회수 1증가
			if(session.getAttribute("read_time_"+bno) != null) {
				//이전에 게시글 조회 시간
				update_time = (long)session.getAttribute("read_time_"+bno);
			}
			//현재시간 구하기
			long current_time = System.currentTimeMillis();
			
			//현재시간과 이전에 게시글 조회시간을 비교
			//24시간(1일)이 지났으면 조회수를 1증가
			//아니면 조회수 증가 없음
			if(current_time - update_time > 24*60*60*1000) {
				//조회수 1증가
				result = sqlSession.update("viewCnt", bno);
				//조회수 1증가한 최신 시간을 session 담음
				session.setAttribute("read_time_"+bno, current_time);
				//ex) 30번 게시글인 경우
				//	  read_time_30변수를 하나 만들고
				//	  현재시간 담음
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}	
	}
	public String goodCntInfo(HashMap<String, String> hMap) {
		// TODO Auto-generated method stub
		sqlSession = sqlSessionFactory.openSession(true);
		String resultGood = "";
		try {
			System.out.println(hMap.toString());
			resultGood = sqlSession.selectOne("goodCntInfo", hMap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return resultGood;
	}
	public void goodSwitch(HashMap<String, String> hMap) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			System.out.println(hMap.toString());
			sqlSession.update("goodSwitch", hMap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	public void goodInsert(HashMap<String, String> hMap) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			sqlSession.insert("goodInsert", hMap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
}
