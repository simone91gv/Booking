package businessLogic;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.Reservationcontroller;
import controller.ResourceController;
import controller.UserController;
import dao.NotebookDao;
import dao.ReservationDao;
import dao.UserDao;
import pojo.Notebook;
import pojo.Reservation;
import pojo.User;

public class ResourceAvailabilityTest {

	private Reservation reservation;
	private Reservation reservation2;
	private User user;
	private Notebook n;
	
	private UserController userController;
	private ResourceController<Notebook> resourceController;
	private Reservationcontroller reservationController;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		
		UserDao userdao = new UserDao();
		userController = new UserController(userdao);
		
		NotebookDao notebookdao = new NotebookDao();
		resourceController = new ResourceController<Notebook>(notebookdao);
		
		ReservationDao reservationDao = new ReservationDao();
		reservationController = new Reservationcontroller(reservationDao);
		
		//aggiunta utente
		user = new User();
		user.setUsername("SimoneGuasconi");
		user.setPassword(userController.encryptpassword("password"));
		user.setName("Simone");
		user.setSurname("Guasconi");
		user.setEmail("guasconi@ariadne.it");
		user.setPhoneNumber("3388194740");
		user.setAdmin(false);
		userController.add(user);
		
		//ottieni il tipo di risorsa da verificare la disponibilità
		n = resourceController.getById("N000000001");
		

		DateTime beginDate = new DateTime(2017,2,10, 12, 00);
	    DateTime endDate = new DateTime(2017,2,10, 15, 30);
	  
		reservation = new Reservation();
		reservation.setUser(user);
		reservation.setResource(n);
		reservation.setBeginDate(beginDate);
		reservation.setActive(true);
		reservation.setEndDate(endDate);
		
		reservationController.performReservation(reservation);
		
		
		DateTime beginDate2 = new DateTime(2017,2,10, 17, 00);
	    DateTime endDate2 = new DateTime(2017,2,10, 18, 00);
	  
		reservation = new Reservation();
		reservation.setUser(user);
		reservation.setResource(n);
		reservation.setBeginDate(beginDate2);
		reservation.setActive(true);
		reservation.setEndDate(endDate2);
		
		reservationController.performReservation(reservation);
		
		
		
		
	}

	@Test
	public void findFirstResourceByTimeInterval() {
		
		int hours =3;
		int minutes = 30;
		
		DateTime beginSeachDate = new DateTime(2017,02,10,12,00);
		DateTime endSeachDate = new DateTime(2017,02,16,18,00);
		
		DateTime firstAvailabiltyStartTime =  reservationController.findFirstResourceAvailability(n,hours,minutes,beginSeachDate,endSeachDate);
		System.out.println(firstAvailabiltyStartTime.toString());
		
		Assert.assertNotNull(firstAvailabiltyStartTime);
	}

}
