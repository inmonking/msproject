package com.msproject.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory sqlsessionFactory;
	static {
		String resource = "com/msproject/mybatis/Configuration.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			if(sqlsessionFactory == null) {
				sqlsessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSession() {
		return sqlsessionFactory;
	}
}
