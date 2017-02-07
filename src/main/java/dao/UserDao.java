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
		user.setPassword("administrator");
		user.setName("Simone");
		user.setSurname("Guasconi");
		user.setEmail("guasconi@ariadne.it");
		user.setPhoneNumber("3388194740");
		user.setAdmin(true);
		
		users.put(user.getPassword(), user);
		
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
	
	public String EncryptPassword(String password){
	
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		
		return encryptedPassword;
	}
	
	public boolean CheckDecryptedPassword(String encryptedPassword,String plainPassword){
		
		return passwordEncryptor.checkPassword(plainPassword, encryptedPassword);
	}
}
