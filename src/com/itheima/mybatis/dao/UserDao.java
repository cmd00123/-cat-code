package com.itheima.mybatis.dao;

import java.io.IOException;
import java.util.List;

import com.itheima.mybatis.pojo.User;

public interface UserDao {
	//1.根据用户ID查询用户信息
	public User findUserById(int id);
	//2.根据用户名称模糊查询用户列表
	public List<User> findUserByName(String name) throws IOException;
	//3.增加用户
	public void insertUser(User user);
}
