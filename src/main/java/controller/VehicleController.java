package controller;

import java.util.TreeMap;

import dao.ResourceDao;
import pojo.Vehicle;

public class VehicleController extends ResourceController<Vehicle> {

	public VehicleController(ResourceDao<Vehicle> resourceDao) {
		super(resourceDao);
	}

	public TreeMap<String,Vehicle> getVehiclesWithMinSeats(int minSeats){
		
		TreeMap<String, Vehicle> minimumRequirementMap = new TreeMap<String, Vehicle>();
		
		TreeMap<String, Vehicle> vehicles = findAll();
		
		for(String key : vehicles.keySet()){
			
			Vehicle v = vehicles.get(key);
			
			if(v.getSeats() >= minSeats)
				minimumRequirementMap.put(key, v);
		}
		return minimumRequirementMap;
	}
}
