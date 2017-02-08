package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.UserController;
import pojo.User;

public class UserDaoTest {

	private UserController userController;
	
	
	@Before
	public void setUp() throws Exception {
		
		userController = new UserController(new UserDao());

	}

	@Test
	public void loginTest() {
		
		User u = userController.performLogin("administrator","admin");
		Assert.assertNotNull("user credentials correct", u);
	}

}
