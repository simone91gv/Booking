package dao;

import java.util.TreeMap;

import pojo.Reservation;

public class ReservationDao {
	
	private TreeMap<Integer, Reservation> reservations = new TreeMap<Integer, Reservation>();
	
	public ReservationDao() {
		 
	}
	public TreeMap<Integer, Reservation> findAll(){
		return reservations;
	}
	public Reservation getUserByUsername(String username){
		return reservations.get(username);
	}
	
	public void add(Reservation r){
		try {
			
			Integer last = reservations.lastKey();
			reservations.put(++last, r);
			
		} catch (Exception e) {
			reservations.put(1, r);
		}
		
	}
	
	public void update(Reservation r){
		reservations.put(r.getId(),r);
	}
	
	public void delete(String username){
		reservations.remove(username);
	}
	
	

}
