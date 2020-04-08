package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	@PostMapping("/user")
	public String addUser(UserBean userBean) {
		System.out.println(userBean.getFirstName());
		System.out.println(userBean.getLastName());
		System.out.println(userBean.getEmail());
			System.out.println(userBean.getPassword());
	// here we need to call add user from dao
			userDao.insertUser(userBean);
			return "user added";
	}

	@GetMapping("/users")
	public ArrayList<UserBean> listUsers() {
		return userDao.listUsers();
	}

	@GetMapping("/user/{email}")
	public UserBean getUser(@PathVariable("email") String email) {
		UserBean userBean = userDao.getUserByEmail(email);
		return userBean;// so we get either user or null value in response
		// later we learn how to send error instead of null
	}
	@PostMapping("/user/{email}")
	public  ArrayList<UserBean> UpdateUser(@PathVariable("email") String email,UserBean ub) {
		 userDao.UpdateUserByEmail(email,ub);
		return userDao.listUsers();
		}

	@DeleteMapping("user/{email}")
	public ArrayList<UserBean> deleteUser(@PathVariable("email") String email){
		//will remove user from array list 
		userDao.deleteUser(email);
		//after removal of user we sent updated list to the client 
		return userDao.listUsers();
}
}