package com.sdu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sdu.po.User;

@Repository("userDao")
public interface UserDao {
	// 查询
	public List<Map<String, Object>> getUsers();

	public User getUserById(Integer id);

	public void updatePo(User user,Integer id);

	public void savePo(User user);
	public void deletePo(Integer id);

}