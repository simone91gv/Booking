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

public class FilterByContraintTest {

	private Reservation reservation;
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

		// aggiunta utente
		user = new User();
		user.setUsername("SimoneGuasconi");
		user.setPassword(userController.encryptpassword("password"));
		user.setName("Simone");
		user.setSurname("Guasconi");
		user.setEmail("guasconi@ariadne.it");
		user.setPhoneNumber("3388194740");
		user.setAdmin(false);
		userController.add(user);

		// effettuo la reservation di 10 notebook con ram variabile
		for (int i = 1; i <= 10; i++) {

			n = new Notebook();
			n.setBrand("Toshiba");
			n.setModel("XC32DWD2_#" + i);
			n.setHardDiskType("HDD");
			n.setDescription("Busniness Laptop #" + i);
			n.setProcessor("I7");
			n.setRam(i);
			n.setId("N000000"+i);

			DateTime beginDate = new DateTime(2017, 2, 22, 11, 00);
			DateTime endDate = new DateTime(2017, 2, 22, 16, 00);

			reservation = new Reservation();
			reservation.setUser(user);
			reservation.setResource(n);
			reservation.setBeginDate(beginDate);
			reservation.setActive(true);
			reservation.setEndDate(endDate);

			reservationController.performReservation(reservation);

		}
		
		

	}

	@Test
	public void test() {
		
		Reservation r = reservationController.findResourceAvailabilityByContraint(Notebook.class, 3, 30, 4);

		System.out.println(r.getBeginDate());
		System.out.println(r.getEndDate());
		System.out.println(r.getResource().getDescription());
		System.out.println(r.getResource().getId());
		
		Assert.assertNotNull(r);
	}

}
