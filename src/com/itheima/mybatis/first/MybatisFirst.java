package com.itheima.mybatis.first;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mybatis.pojo.User;

public class MybatisFirst {
	@Test
	public void findUserByIdTest() throws Exception{
		String resource ="SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//调用SqSession的增删改查
		//第一个参数:表示statement的唯一标示
		User user = sqlSession.selectOne("test.findUserById",1);
		
		System.out.println(user);
		
		//关闭资源
		sqlSession.close();
	}
	@Test
	public void findUserByNameTest() throws Exception{
		String resource ="SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//调用SqSession的增删改查
		//第一个参数:表示statement的唯一标示
		User user = sqlSession.selectOne("test.findUserByName","haa");
		
		System.out.println(user);
		
		//关闭资源
		sqlSession.close();
	}
	@Test
	public void insertUserTest() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建sqlsessionfactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//调用sqlsession的增删改查
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		
		user.setUsername("longlong");
		user.setAddress("aab");
		sqlSession.insert("test.insertUser", user);
		
		sqlSession.commit();
		
		sqlSession.close();
	}
}
