package dao;


import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.Reservationcontroller;
import controller.ResourceController;
import controller.UserController;
import pojo.Reservation;
import pojo.Resource;
import pojo.User;
import pojo.Vehicle;

public class ReservationDaoTest {

	private Reservation reservation;
	private User user;
	private Vehicle v;
	
	private UserController userController;
	private ResourceController<Vehicle> resourceController;
	private Reservationcontroller reservationController;
	
	@Before
	public void setUp() throws Exception {
		
		userController = new UserController(new UserDao());
		reservationController = new Reservationcontroller(new ReservationDao());
		
		user = new User();
		user.setUsername("SimoneGuasconi");
		user.setPassword(userController.encryptpassword("password"));
		user.setName("Simone");
		user.setSurname("Guasconi");
		user.setEmail("guasconi@ariadne.it");
		user.setPhoneNumber("3388194740");
		user.setAdmin(false);
		
		
		//simulate the resource fetch from the db
		resourceController = new ResourceController<Vehicle>(new VehicleDao());
	    v = resourceController.getById("EK159NJ");
	    
	    DateTime beginDate = new DateTime(2017,2,8, 10, 00);
	    DateTime endDate = new DateTime(2017,2,8, 11, 00);
	    
		
		reservation = new Reservation();
		reservation.setUser(user);
		reservation.setResource(v);
		reservation.setBeginDate(beginDate);
		reservation.setEndDate(endDate);
		
		reservationController.performReservation(reservation);
		
		
	}

	@Test
	public void reservationOnResource() {
		
		
		DateTime beginDate = new DateTime(2017,2,8, 11, 00);
		DateTime endDate = new DateTime(2017,2,8, 12, 00);
		
		
		Reservation reservation2 = new Reservation();
		reservation2.setUser(user);
		reservation2.setResource(v);
		reservation2.setBeginDate(beginDate);
		reservation2.setEndDate(endDate);

		boolean available = reservationController.performReservation(reservation2);
		
		Assert.assertTrue("resource available",available);
	}

}
