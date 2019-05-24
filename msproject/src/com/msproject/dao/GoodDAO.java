package com.msproject.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.msproject.dto.BoardDTO;
import com.msproject.dto.GoodDTO;
import com.msproject.mybatis.SqlMapConfig;

public class GoodDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result = 0;
	List<GoodDTO> list = null;
	private GoodDTO gDto = null;
	
	private GoodDAO() {}
	private static GoodDAO instance = new GoodDAO();
	public static GoodDAO getInstance() {
		return instance;
	}
	public GoodDTO getGood(GoodDTO userGood) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			gDto = sqlSession.selectOne("getGood", userGood);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return gDto;
	}
	public void setGood(GoodDTO userGood) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("setGood", userGood);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}
	public void removeGood(GoodDTO userGood) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("removeGood", userGood);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	public int goodCnt(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.selectOne("GoodCnt", bno);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}

	public int goodUpdate(HashMap<String, String> hMap) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.update("goodTotal", hMap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}
}
