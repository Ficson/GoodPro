package com.jyu.service;

import com.jyu.bean.User;

public interface UserService {
	public User selectByName(String name);
	public User selectById(String id);
	public int update(User user);

}
