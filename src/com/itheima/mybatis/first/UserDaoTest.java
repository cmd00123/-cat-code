package com.itheima.mybatis.first;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.impl.UserDaoImpl;
import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;
import com.itheima.mybatis.pojo.UserQueryVO;

public class UserDaoTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception{
		//读取配置文件，全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		
	}
//	public void testFindUserById() throws Exception{
//		//创建UserDao
//		UserDao dao = new UserDaoImpl(sqlSessionFactory);
//		User user = dao.findUserById(1);
//		System.out.println(user);
//		
//	}
	@Test
	public void testFindUserById() throws Exception{
		//创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//由mybatis通过sqlSession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user = mapper.findUserById(1);
		
		System.out.println(user);
		
		sqlSession.close();
	}
	@Test
	public void testFindUserList(){
		//创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//由mybatis通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVO vo = new UserQueryVO();
		User user = new User();
		user.setUsername("hebin");
		user.setSex("1");
		vo.setUser(user);
		
		List<User> list = mapper.findUserList(vo);
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void testFindUserByHashmap(){
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		//获取mapper接口实例
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//构造查询条件Hashmap对象
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("id", 1);
		map.put("username","hebin");
		
		//传递hashmap对象查询用户列表
		List<User> list = userMapper.findUserByHashmap(map);
		//打印list列表
		System.out.println(list);
		//关闭session
		session.close();
	}
	@Test
	public void testFindUserRstMap(){
		//创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//由mybatis通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user = mapper.findUserRstMap(1);
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void testFindUserList1() {
		//创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//由mybaits通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVO vo = new UserQueryVO();
		
		User user = new User();
		user.setUsername("hebin");
		//user.setSex("1");
		vo.setUser(user);
		
		List<User> list = mapper.findUserList(vo);
		int count = mapper.findUserCount(vo);
		
		System.out.println(list);
		System.out.println(count);
		
		sqlSession.close();
	}
	
}
