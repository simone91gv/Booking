package dao;

import java.util.TreeMap;

import pojo.OfficeRoom;

public class OfficeRoomDao implements ResourceDao<OfficeRoom> {
	
	private TreeMap<String, OfficeRoom> officeRooms;

	public OfficeRoomDao() {
		
		//inizializza la lista aggiungendo un vehicle
		OfficeRoom or1 = new OfficeRoom();
		or1.setId("Aula riunione 001");
		or1.setCapacity(40);
		or1.setFloor(-1);
		
		
		//aggiunta alla tree map
		officeRooms.put(or1.getId(), or1);
	}

	public TreeMap<String, OfficeRoom> findAll() {
		return officeRooms;
	}
	
	public OfficeRoom getById(String id) {
		return officeRooms.get(id);
	}
	
	public void delete(String id) {
		officeRooms.remove(id);
		
	}

	public void update(OfficeRoom item) {
		officeRooms.put(item.getId(), item);
		
	}

	public void add(OfficeRoom item) {
		officeRooms.put(item.getId(), item);
		
	}
	

}
