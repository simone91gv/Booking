package dao;

import java.util.TreeMap;

import pojo.Vehicle;

public class VehicleDao implements ResourceDao<Vehicle> {
	
	private TreeMap<Integer, Vehicle> vehicles = new TreeMap<Integer,Vehicle>();
	
	public VehicleDao(){
		
		//inizializza la lista aggiungendo un vehicle
		Vehicle v1 = new Vehicle();
		v1.setId(0);
		v1.setBrand("FIAT");
		v1.setModel("PUNTO");
		v1.setDescription("The first business car of the company");
		v1.setDisplacement(1400);
		v1.setPlate("EK159NJ");
		v1.setSupplyType("BENZINA");
		
		//aggiunta alla tree map
		vehicles.put(v1.getId(), v1);
	}

	public TreeMap<Integer, Vehicle> findAll() {
		
		return vehicles;
	}

	public Vehicle getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Vehicle item) {
		
		Integer lastId = vehicles.lastKey();
		Integer newId = lastId +1;
		
		vehicles.put(newId, item);
	}

	public void delete(Vehicle item) {
		// TODO Auto-generated method stub
	}

	public void update(Vehicle item) {
		// TODO Auto-generated method stub
	}

}
