package com.itheima.mybatis.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.pojo.User;

public class UserDaoImpl implements UserDao{
	//依赖注入
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) {
		String resource ="SqlMapConfig.xml";
		InputStream inputStream;
		
			
			//创建SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//调用SqSession的增删改查
			//第一个参数:表示statement的唯一标示
			User user = sqlSession.selectOne("test.findUserById",id);
			
			sqlSession.close();
			
			return user;
			//关闭资源
		
	}

	@Override
	public List<User> findUserByName(String name) throws IOException {
		
		//创建sqlsessionfactory
	
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//调用SqSession的增删改查
		//第一个参数:表示statement的唯一标示
		List user = sqlSession.selectList("test.findUserByName");
		
		System.out.println(user);
		
		//关闭资源
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) {
			//调用sqlsession的增删改查
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			sqlSession.insert("test.insertUser", user);
			
			sqlSession.commit();
			
			sqlSession.close();
		
		
	}

}
