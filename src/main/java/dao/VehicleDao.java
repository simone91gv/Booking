package dao;

import java.util.TreeMap;

import pojo.Vehicle;

public class VehicleDao implements ResourceDao<Vehicle> {
	
	private TreeMap<String, Vehicle> vehicles = new TreeMap<String,Vehicle>();
	
	public VehicleDao(){
		
		//inizializza la lista aggiungendo un vehicle
		Vehicle v1 = new Vehicle();
		v1.setId("EK159NJ");
		v1.setBrand("FIAT");
		v1.setModel("PUNTO");
		v1.setDescription("The first business car of the company");
		v1.setDisplacement(1400);
		v1.setSeats(5);
		v1.setSupplyType("DIESEL");
		
		//aggiunta alla tree map
		vehicles.put(v1.getId(), v1);
	}

	public TreeMap<String, Vehicle> findAll() {		
		return vehicles;
	}

	public Vehicle getById(String id) {
		return vehicles.get(id);
	}

	public void add(Vehicle item) {
		vehicles.put(item.getId(), item);
	}
	
	public void delete(String id) {
		vehicles.remove(id);	
	}
	public void update(Vehicle item) {
		vehicles.put(item.getId(), item);
	}

	
	

}
