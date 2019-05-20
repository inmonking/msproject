package com.msproject.dao;

import java.util.List;

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
}
