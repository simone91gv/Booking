package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.UserController;
import pojo.User;

public class UserDaoTest {

	private User user;
	private UserController userController;
	
	
	@Before
	public void setUp() throws Exception {
		
		userController = new UserController(new UserDao());

		user = new User();
		user.setUsername("administrator");
		user.setPassword("administrator");
		user.setName("Simone");
		user.setSurname("Guasconi");
		user.setEmail("guasconi@ariadne.it");
		user.setPhoneNumber("3388194740");
		user.setAdmin(true);
		
		userController.add(user);
		
	}

	@Test
	public void loginTest() {
		
		User u = userController.performLogin(user.getUsername(),user.getPassword());
		
		Assert.assertNotNull("user credentials correct", u);
		
	}

}
