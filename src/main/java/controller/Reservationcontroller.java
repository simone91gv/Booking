package controller;

import java.util.TreeMap;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import dao.ReservationDao;
import pojo.Reservation;
import pojo.Resource;

public class Reservationcontroller {

	private ReservationDao reservationDao;

	public Reservationcontroller(ReservationDao reservationDao) {
		super();
		this.reservationDao = reservationDao;
	}

	public ReservationDao getReservationDao() {
		return reservationDao;
	}

	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}
	
	

	//this method tries to serve a reservation request
	// return value: TRUE 	--> reservation made with success
	// return value: FALSE 	--> reservation impossible to made another reservation is in action
	public boolean performReservation(Reservation reservation) {
		
		Resource urr = reservation.getResource();
		Interval uInterval = new Interval(reservation.getBeginDate(), reservation.getEndDate());
		
		TreeMap<Integer, Reservation> reservations =  reservationDao.findAll();
		
		for(Integer key : reservations.keySet()){
			
			Reservation dbr = reservations.get(key);
			Resource dbrr = dbr.getResource();
			
			//check if the resource in the reservation map is equal to the one that should be booked
			if(dbrr.getId().equals(urr.getId())){
				
				//interval of the reservation on the db
				Interval dbInterval = new Interval(dbr.getBeginDate(),dbr.getEndDate());
				
				if(dbInterval.overlaps(uInterval) == true)
					return false;
			}
		}
		reservationDao.add(reservation);
		
		return true;
	}
	
	
}
