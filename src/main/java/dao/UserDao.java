package dao;

import java.util.TreeMap;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import pojo.User;

public class UserDao {
	
	
	private TreeMap<String, User> users = new TreeMap<String, User>();
	private ConfigurablePasswordEncryptor passwordEncryptor; 
	
	
	public UserDao() {
		
		passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm("SHA-1");
		passwordEncryptor.setPlainDigest(true);
		
		User user = new User();
		user.setUsername("administrator");
		user.setPassword(encryptPassword("admin"));
		user.setName("Simone");
		user.setSurname("Guasconi");
		user.setEmail("guasconi@ariadne.it");
		user.setPhoneNumber("3388194740");
		user.setAdmin(true);
		
		users.put(user.getUsername(), user);
		
	}
	
	public TreeMap<String, User> findAll(){
		return users;
	}
	public User getUserByUsername(String username){
		return users.get(username);
	}
	
	public void add(User u){
		users.put(u.getUsername(), u);
	}
	
	public void update(User u){
		users.put(u.getUsername(),u);
	}
	
	public void delete(String username){
		users.remove(username);
	}
	
	public String encryptPassword(String password){
	
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		
		return encryptedPassword;
	}
	
	public boolean checkDecryptedPassword(String encryptedPassword,String plainPassword){
		
		System.out.println("criptata : "+ encryptedPassword);
		System.out.println("plain : "+ plainPassword);
		
		
		return passwordEncryptor.checkPassword(plainPassword, encryptedPassword);
	}
}
