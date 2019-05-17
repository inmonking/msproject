package com.msproject.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.msproject.dto.ProductDTO;
import com.msproject.mybatis.SqlMapConfig;

public class ProductDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
//	singleton패턴을 활용한 DAO객체 사용
//	:객체생성 1회만 동작하고 생성된 객체를 빌려쓰는 형태
//	:+외부에서는 객체생성이 불가능하게 잠금
	private ProductDAO() {}
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	public List<ProductDTO> bestList() {
		List<ProductDTO> list = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			list = sqlSession.selectList("bestList");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		return list;
	}
	public List<ProductDTO> newList() {
		List<ProductDTO> list = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			list = sqlSession.selectList("newList");
			for (ProductDTO productDTO : list) {
				System.out.println(productDTO.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		return list;
	}
}
