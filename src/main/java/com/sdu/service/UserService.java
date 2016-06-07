package com.sdu.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sdu.po.User;
@Service("userService")
public interface UserService {
	// 查询
	public List<Map<String,Object>> getUsers();
	
	public User getUserById(Integer id);
	
	public void daletePo(Integer id);

	public void updatePo(User user,Integer id);
	public void savePo(User user);
}