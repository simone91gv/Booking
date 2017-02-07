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
		
		//creazione nuovo veicolo (simulazione di aggiunta nuovo veicolo da form)
		vehicle = new Vehicle();
		
		vehicle.setId("BF490SH");
		vehicle.setDescription("Nuovo veicolo aggiunto alla flotta aziendale");
		vehicle.setBrand("VOLVO");
		vehicle.setDisplacement(2000);
		vehicle.setModel("XC60");
		vehicle.setSupplyType("DIESEL");
		
		
	}
	
	@Test
	public void addResource() {
		
		//aggiunta di un veicolo alla treemap
		resourceController.add(vehicle);
		
		TreeMap<String,Vehicle> vehicles =  resourceController.findAll();
		
		Vehicle v = vehicles.get(vehicle.getId());
		Assert.assertEquals("the vehicle with the plate : "+vehicle.getId()+" is added", vehicle.getId(), v.getId());
	}
	
	@Test
	public void retrieveResource(){
		
		Vehicle v2 = resourceController.getById("EK159NJ");
		Assert.assertNotNull("the value of the vehicle v2 is correctyly retrieved", v2);
	}
	
	@Test
	public void updateResource(){
		
		vehicle.setId("EK159NJ");
		resourceController.update(vehicle);
		
		Vehicle v3 = resourceController.getById("EK159NJ");
		
		Assert.assertEquals("the resource object is correctly updated", "VOLVO", v3.getBrand() );
		
	}
	
	@Test
	public void deleteResource(){
		
		resourceController.delete("EK159NJ");
		
		Vehicle v4 = resourceController.getById("EK159NJ");
		
		Assert.assertNull("the resource with id : EK159NJ is correctly removed", v4);
	}

}
