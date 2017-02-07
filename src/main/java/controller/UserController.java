package controller;

import java.util.TreeMap;

import dao.UserDao;
import pojo.User;

public class UserController {
	
	private UserDao userdao;
	
	public UserController(UserDao userdao) {
		super();
		this.userdao = userdao;
	}

	public void add(User user) {
		
		String encryptedPassword = userdao.EncryptPassword(user.getPassword());
		user.setPassword(encryptedPassword);
		
		userdao.add(user);
	}
	
	public TreeMap<String, User> findAll(){
		return userdao.findAll();
	}
	
	public User getuserByUsername(String username){
		return userdao.getUserByUsername(username);
	}

	//this method check if the user credentials are correct or not
	public User performLogin(String username, String password) {
		
		User u = userdao.getUserByUsername(username);
		if(u != null){
			if(userdao.CheckDecryptedPassword(u.getPassword(), password));
				return u;
		}
		
		return null;
	}
	
	

}
