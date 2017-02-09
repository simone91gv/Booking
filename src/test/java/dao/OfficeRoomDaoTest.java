package dao;

import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.ResourceController;
import pojo.OfficeRoom;

/**
 * 
 * @author guasconi
 * 
 * This test class should be used to proof the correct CRUD based methods on the resource object model
 * This will be replaced by an admin page that will handles all the resource instances(crud).
 *
 */
public class OfficeRoomDaoTest {
	
	private OfficeRoom officeroom;
	private ResourceController<OfficeRoom> resourceController;
	

	@Before
	public void setUp() throws Exception {
		
		resourceController = new ResourceController<OfficeRoom>(new OfficeRoomDao());
		
		
		
		//creazione nuovo veicolo (simulazione di aggiunta nuovo veicolo da form)
		officeroom = new OfficeRoom();
		
		officeroom.setId("OR000000001");
		officeroom.setDescription("Aula riunioni al primo piano");
		officeroom.setCapacity(60);
		officeroom.setFloor(1);
			
	}
	
	@Test
	public void addResource() {
		
		//aggiunta di un veicolo alla treemap
		resourceController.add(officeroom);
		
		TreeMap<String,OfficeRoom> officerooms =  resourceController.findAll();
		
		OfficeRoom o = officerooms.get(officeroom.getId());
		Assert.assertEquals("the officeRoom with the id : "+officeroom.getId()+" is added", officeroom.getId(), o.getId());
	}
	
	@Test
	public void retrieveResource(){
		
		OfficeRoom o2 = resourceController.getById("OR000000001");
		Assert.assertNotNull("the value of the officeroom o2 is correctyly retrieved", o2);
	}
	
	@Test
	public void updateResource(){
		
		officeroom.setCapacity(45);
		resourceController.update(officeroom);
		
		OfficeRoom o3 = resourceController.getById("OR000000001");
		
		Assert.assertEquals("the resource object is correctly updated", 45, o3.getCapacity());
		
	}
	
	@Test
	public void deleteResource(){
		
		resourceController.delete("OR000000001");
		
		OfficeRoom o4 = resourceController.getById("OR000000001");
		
		Assert.assertNull("the resource with id : OR000000001 is correctly removed", o4);
	}

}