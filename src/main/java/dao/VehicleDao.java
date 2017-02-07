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
		v1.setPlate("EK159NJ");
		v1.setSupplyType("BENZINA");
		
		//aggiunta alla tree map
		vehicles.put(v1.getPlate(), v1);
	}

	public TreeMap<String, Vehicle> findAll() {
		
		return vehicles;
	}

	public void add(Vehicle item) {
		
		String plate = item.getPlate();
		
		vehicles.put(plate, item);
	}

	public void delete(Vehicle item) {
		// TODO Auto-generated method stub
	}

	public void update(Vehicle item) {
		// TODO Auto-generated method stub
	}

	public Vehicle getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
