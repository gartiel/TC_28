package com.hwua.service;

import com.hwua.entity.User;

public interface IUserService {
	public int register(User user);
	public User login(String username,String password);
}
