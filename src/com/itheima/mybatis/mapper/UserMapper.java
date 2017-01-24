package com.itheima.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.itheima.mybatis.pojo.User;
import com.itheima.mybatis.pojo.UserQueryVO;

public interface UserMapper {
	//1.根据用户Id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//2.添加用户
	public void insertUser(User user) throws Exception;
	
	//3.综合查询
	public List<User> findUserList(UserQueryVO vo );
	//4.根据map键值对
	public List<User> findUserByHashmap(HashMap map);
	//5.根据resultmap
	public User findUserRstMap(int id);
	//6.动态sql
	public int findUserCount(UserQueryVO vo);
}
