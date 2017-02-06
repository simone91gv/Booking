package dao;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import controller.ResourceController;
import junit.framework.Assert;
import pojo.Vehicle;

/**
 * 
 * @author guasconi
 * 
 * This test class should be used to proof the correct CRUD based methods on the resource object model
 * This will be replaced by an admin page that will handles all the resource instances(crud).
 *
 */
@SuppressWarnings("deprecation")
public class ResourceDaoTest {
	
	private Vehicle vehicle;
	private ResourceController<Vehicle> resourceController;
	

	@Before
	public void setUp() throws Exception {
		
		resourceController = new ResourceController<Vehicle>(new VehicleDao());
		
		TreeMap<Integer,Vehicle> vlist = resourceController.findAll();
		
		if(vlist.size() > 0)
			System.out.println("fiat presente");
		else
			System.out.println("fiat non presente");
		
		for(Integer i : vlist.keySet()){
			
			System.out.println("chiave" + i);
			System.out.println(vlist.get(i).getBrand()+ " \t" + vlist.get(i).getModel());
		}
		
		//creazione nuovo veicolo (simulazione di aggiunta nuovo veicolo da form)
		vehicle = new Vehicle();
		
		vehicle.setBrand("VOLVO");
		vehicle.setDisplacement(2000);
		vehicle.setModel("XC60");
		vehicle.setPlate("BF490SH");
		vehicle.setSupplyType("DIESEL");
		
		
	}
	
	
	

	@SuppressWarnings("deprecation")
	@Test
	public void addResource() {
		
		//aggiunta di un veicolo alla treemap
		resourceController.add(vehicle);
		
		
		
		TreeMap<Integer,Vehicle> vehicles =  resourceController.findAll();
		
		Vehicle v = vehicles.get(vehicle.getId());
		
		
		Assert.assertNotNull("the vehicle is correcty added?",v);
		
		System.out.println("*****************************");
		
		for(Integer i : vehicles.keySet()){
			
			System.out.println("index :"+ i);
			System.out.println(vehicles.get(i).getBrand()+ " \t" + vehicles.get(i).getModel());
		}
		
	}

}
