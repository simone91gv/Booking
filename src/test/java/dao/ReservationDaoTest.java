package dao;


import java.util.TreeMap;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.Reservationcontroller;
import controller.ResourceController;
import controller.UserController;
import pojo.Reservation;
import pojo.User;
import pojo.Vehicle;

public class ReservationDaoTest {

	private Reservation reservation;
	private Reservation reservation2;
	private User user;
	private User user2;
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
		userController.add(user);
		
		user2 = new User();
		user2.setUsername("ThimotyBarbieri");
		user2.setPassword(userController.encryptpassword("thimoty"));
		user2.setName("Thimoty");
		user2.setSurname("Barbieri");
		user2.setEmail("thimoty.barbieri@gmail.com");
		user2.setPhoneNumber("3383131540");
		user2.setAdmin(true);
		userController.add(user2);
		
		
		//simulate the resource fetch from the db
		resourceController = new ResourceController<Vehicle>(new VehicleDao());
	    v = resourceController.getById("EK159NJ");
	    
	    DateTime beginDate = new DateTime(2017,2,8, 17, 00);
	    DateTime endDate = new DateTime(2017,2,8, 18, 00);
	    
		
		reservation = new Reservation();
		reservation.setUser(user);
		reservation.setResource(v);
		reservation.setBeginDate(beginDate);
		reservation.setActive(false);
		reservation.setEndDate(endDate);
		
		reservationController.performReservation(reservation);
		
		DateTime beginDate2 = new DateTime(2017,2,9, 9, 00);
	    DateTime endDate2 = new DateTime(2017,2,9, 12, 00);
	    
	    reservation2 = new Reservation();
		reservation2.setUser(user2);
		reservation2.setResource(v);
		reservation2.setBeginDate(beginDate2);
		reservation2.setActive(true);
		reservation2.setEndDate(endDate2);
		
		reservationController.performReservation(reservation2);
	    
		DateTime beginDate3 = new DateTime(2017,2,10, 9, 00);
	    DateTime endDate3 = new DateTime(2017,2,10, 12, 00);
		
		
		reservation = new Reservation();
		reservation.setUser(user);
		reservation.setResource(v);
		reservation.setBeginDate(beginDate3);
		reservation.setActive(false);
		reservation.setEndDate(endDate3);
		
	
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
	
	@Test 
	public void ListOfUserActiveReservations(){
		
		
		User u = userController.getuserByUsername("SimoneGuasconi");
		
		TreeMap<Integer,Reservation> activeuserReservations = reservationController.getActiveReservationsByUser(u);
		
		for(Integer key : activeuserReservations.keySet()){
			
			System.out.println(activeuserReservations.get(key));
		}
		
		Assert.assertEquals(1, activeuserReservations.size());
		
	}

}
