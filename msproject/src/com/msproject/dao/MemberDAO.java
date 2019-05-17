package com.msproject.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.msproject.dto.MemberDTO;
import com.msproject.mybatis.SqlMapConfig;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
//	singleton패턴을 활용한 DAO객체 사용
//	:객체생성 1회만 동작하고 생성된 객체를 빌려쓰는 형태
//	:+외부에서는 객체생성이 불가능하게 잠금
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public String idCheck(String id) {
		sqlSession = sqlSessionFactory.openSession();
		String result="";
		try {
			result = sqlSession.selectOne("idCheck", id);
			if(result!=null) {
				result = "-1";
			}else {
				result = "1";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}

	public int memInsert(MemberDTO mDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		int result = 0;
		try {
			result = sqlSession.insert("memInsert", mDto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}

	public int memUpdate(MemberDTO mDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		int result = 0;
		try {
			result = sqlSession.insert("memUpdate", mDto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}
	public int pwUpdate(String id,String pw) {
		int result = 0;
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw",pw);
		try {
			result = sqlSession.update("pwUpdate",map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}

	public MemberDTO memOne(String id) {
		MemberDTO mDto = new MemberDTO();
		sqlSession = sqlSessionFactory.openSession();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		return null;
	}

	public int memDelete(String id) {
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result = sqlSession.delete("memDelete",id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}
}
