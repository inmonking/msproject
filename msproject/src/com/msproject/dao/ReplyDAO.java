package com.msproject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.msproject.dto.ReplyDTO;
import com.msproject.mybatis.SqlMapConfig;

public class ReplyDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result = 0;
	ReplyDTO rDto = new ReplyDTO();
	List<ReplyDTO> list = null;
	boolean flag = false;
	
	private ReplyDAO() {}
	private static ReplyDAO instance = new ReplyDAO();
	public static ReplyDAO getInstance() {
		return instance;
	}
	public List<ReplyDTO> replyList(String bno) {
		// TODO Auto-generated method stub
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("replyList", bno);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	public int replyAdd(ReplyDTO rDto2) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("replyAdd", rDto2);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}
	public int replyRemove(ReplyDTO rDto2) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("replyRemove", rDto2);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}
}
