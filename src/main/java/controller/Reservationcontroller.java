package controller;

import java.util.TreeMap;

import org.joda.time.Interval;

import dao.ReservationDao;
import pojo.Reservation;
import pojo.Resource;
import pojo.User;

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
	
	public TreeMap<Integer, Reservation> findAll(){
		return reservationDao.findAll();
	}
	
	
	//this meethod returns all the reservations of the user.
	//it returns both active and made reservations.
	public TreeMap<Integer, Reservation> findByUser(User u){
		
		TreeMap<Integer, Reservation> userReservations = new TreeMap<Integer, Reservation>();
		
		TreeMap<Integer, Reservation> reservations = reservationDao.findAll();
		
		for(Integer key : reservations.keySet()){
			
			Reservation r = reservations.get(key);
			if(r.getUser().equals(u))
				userReservations.put(key, r);
		}
		
		return userReservations;
	}
	
	public TreeMap<Integer, Reservation> findByResource(Resource r) {

		TreeMap<Integer, Reservation> ResourceReservations = new TreeMap<Integer, Reservation>();
		
		TreeMap<Integer, Reservation> reservations = reservationDao.findAll();
		
		for(Integer key : reservations.keySet()){
			
			Reservation reservation = reservations.get(key);
			if(reservation.getResource().equals(r))
				ResourceReservations.put(key, reservation);
		}
		
		return ResourceReservations;
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
	
	//this method returns a map of all the active user reservations
	//it checks reservations with:
	//case1 : active = true (possibility to have a resource expired but not released)
	//case2 :  begindate<now<enddate (the resource is currently owned by the user) 
	public TreeMap<Integer, Reservation> getActiveReservationsByUser(User u) {
	
		TreeMap<Integer, Reservation> activeReservations = new TreeMap<Integer, Reservation>();
		TreeMap<Integer, Reservation> reservations = this.findByUser(u);
		
		for(Integer key : reservations.keySet()){
			
			Reservation dbr = reservations.get(key);
			
			if(( (dbr.isActive()) || (dbr.getBeginDate().isBeforeNow() && dbr.getEndDate().isAfterNow()) == true)){
				activeReservations.put(key, dbr);
			}
		}
		
		return activeReservations;	
	}

	//this method returns a map of all the made user reservations
	//it checks reservations with:
	//case1 : active = false (the user has returned the given resource)
	public TreeMap<Integer, Reservation> getMadeReservationsByUser(User u) {
		
		TreeMap<Integer, Reservation> madeReservations = new TreeMap<Integer, Reservation>();
		TreeMap<Integer, Reservation> reservations = this.findByUser(u);
		
		for(Integer key : reservations.keySet()){
			
			Reservation dbr = reservations.get(key);
			
			if(!dbr.isActive()){
				madeReservations.put(key, dbr);
			}
		}
		
		return madeReservations;
	}

	
	
}