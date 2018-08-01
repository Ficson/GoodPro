package com.jyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jyu.bean.User;
import com.jyu.mapper.UserMapper;
import com.jyu.service.UserService;

@Component("UserServiceImpl")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectByName(String name) {
		return userMapper.selectByName(name);
		
	}

	@Override
	public User selectById(String id) {
		return userMapper.selectByPrimaryKey(new Integer(id));
	}

	@Override
	public int update(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

}
