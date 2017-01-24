package com.itheima.mybatis.first;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.impl.UserDaoImpl;
import com.itheima.mybatis.pojo.User;

public class UserDaoTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception{
		//读取配置文件，全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	@Test
	public void testFindUserById() throws Exception{
		//创建UserDao
		UserDao dao = new UserDaoImpl(sqlSessionFactory);
		User user = dao.findUserById(1);
		System.out.println(user);
	}
}
