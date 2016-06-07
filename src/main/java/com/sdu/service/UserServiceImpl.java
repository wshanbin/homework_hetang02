package com.sdu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdu.dao.UserDao;
import com.sdu.po.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	public List<Map<String, Object>> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	public  void updatePo(User user, Integer id) {
		userDao.updatePo(user, id);
	}

	public void savePo(User user) {
		userDao.savePo(user);	
	}
	
	public void daletePo(Integer id){
		userDao.deletePo(id);
	}
	
}
