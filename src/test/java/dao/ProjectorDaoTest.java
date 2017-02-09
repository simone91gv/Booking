package dao;

import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.ResourceController;
import pojo.Projector;

/**
 * 
 * @author guasconi
 * 
 * This test class should be used to proof the correct CRUD based methods on the resource object model
 * This will be replaced by an admin page that will handles all the resource instances(crud).
 *
 */
public class ProjectorDaoTest {
	
	private Projector projector;
	private ResourceController<Projector> resourceController;
	

	@Before
	public void setUp() throws Exception {
		
		resourceController = new ResourceController<Projector>(new ProjectorDao());
		
		
		
		//creazione nuovo veicolo (simulazione di aggiunta nuovo veicolo da form)
		projector = new Projector();
		
		projector.setId("P000000002");
		projector.setDescription("Nuovo veicolo aggiunto alla flotta aziendale");
		projector.setBrand("BENQ");
		projector.setModel("x45re");
		projector.setResolution("1080dpi");
			
	}
	
	@Test
	public void addResource() {
		
		//aggiunta di un veicolo alla treemap
		resourceController.add(projector);
		
		TreeMap<String,Projector> projectors =  resourceController.findAll();
		
		Projector p = projectors.get(projector.getId());
		Assert.assertEquals("the projector with the id : "+projector.getId()+" is added", projector.getId(), p.getId());
	}
	
	@Test
	public void retrieveResource(){
		
		Projector p2 = resourceController.getById("P000000001");
		Assert.assertNotNull("the value of the projector p2 is correctyly retrieved", p2);
	}
	
	@Test
	public void updateResource(){
		
		projector.setResolution("720dpi");
		resourceController.update(projector);
		
		Projector p3 = resourceController.getById("P000000002");
		
		Assert.assertEquals("the resource object is correctly updated", "720dpi", p3.getResolution() );
		
	}
	
	@Test
	public void deleteResource(){
		
		resourceController.delete("P000000002");
		
		Projector p4 = resourceController.getById("P000000002");
		
		Assert.assertNull("the resource with id : EK159NJ is correctly removed", p4);
	}

}