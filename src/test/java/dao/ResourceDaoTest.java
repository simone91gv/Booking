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
		
		TreeMap<String,Vehicle> vlist = resourceController.findAll();
		
		for(String i : vlist.keySet()){
			
			System.out.println("chiave" + i);
			System.out.println(vlist.get(i).getBrand()+ " \t" + vlist.get(i).getModel());
		}
		
		//creazione nuovo veicolo (simulazione di aggiunta nuovo veicolo da form)
		vehicle = new Vehicle();
		
		vehicle.setId("BF490SH");
		vehicle.setDescription("Nuovo veicolo aggiunto alla flotta aziendale");
		vehicle.setBrand("VOLVO");
		vehicle.setDisplacement(2000);
		vehicle.setModel("XC60");
		vehicle.setPlate("BF490SH");
		vehicle.setSupplyType("DIESEL");
		
		
	}
	
	
	

	@Test
	public void addResource() {
		
		//aggiunta di un veicolo alla treemap
		resourceController.add(vehicle);
		
		TreeMap<String,Vehicle> vehicles =  resourceController.findAll();
		
		Vehicle v = vehicles.get(vehicle.getId());
		
		
		Assert.assertEquals("the vehicle with the plate : "+vehicle.getPlate()+" is added", vehicle.getId(), v.getId());
		
	}

}
