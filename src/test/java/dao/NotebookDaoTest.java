package dao;

import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.NotebookController;
import controller.ResourceController;
import pojo.Notebook;

/**
 * 
 * @author guasconi
 * 
 * This test class should be used to proof the correct CRUD based methods on the resource object model
 * This will be replaced by an admin page that will handles all the resource instances(crud).
 *
 */
public class NotebookDaoTest {
	
	private Notebook notebook;
	private ResourceController<Notebook> resourceController;
	private NotebookController notebookController;
	

	@Before
	public void setUp() throws Exception {
		
		NotebookDao notebookDao = new NotebookDao();
		
		resourceController = new ResourceController<Notebook>(notebookDao);
		notebookController = new NotebookController(notebookDao);
		
		
		//creazione nuovo veicolo (simulazione di aggiunta nuovo veicolo da form)
		notebook = new Notebook();
		
		notebook.setId("N000000001");
		notebook.setDescription("Portatile  aggiunto per i corsi aziendali");
		notebook.setBrand("ASUS");
		notebook.setModel("X50L");
		notebook.setHardDiskType("HDD");
		notebook.setProcessor("I7 2.8 GHz");
		notebook.setRam(8);
		notebook.setUsb3(false);
			
	}
	
	@Test
	public void addResource() {
		
		//aggiunta di un veicolo alla treemap
		resourceController.add(notebook);
		
		TreeMap<String,Notebook> notebooks =  resourceController.findAll();
		
		Notebook n = notebooks.get(notebook.getId());
		Assert.assertEquals("the notebook with the serial number : "+notebook.getId()+" is added", notebook.getId(), n.getId());
	}
	
	@Test
	public void retrieveResource(){
		
		Notebook n2 = resourceController.getById("N000000001");
		Assert.assertNotNull("the value of the vehicle v2 is correctyly retrieved", n2);
	}
	
	@Test
	public void updateResource(){
		
		notebook.setRam(16);
		resourceController.update(notebook);
		
		Notebook v3 = resourceController.getById("N000000001");
		
		Assert.assertEquals("the resource object is correctly updated", 16, v3.getRam());
		
	}
	
	@Test
	public void deleteResource(){
		
		resourceController.delete("N000000001");
		
		Notebook v4 = resourceController.getById("N000000001");
		
		Assert.assertNull("the resource with id : N000000001 is correctly removed", v4);
	}
	
	@Test
	public void getNotebooksWithMinRam(){
		
		TreeMap<String,Notebook> notebooks = notebookController.getNotebookWithMinRam(4);
		
		Assert.assertEquals("numero di notebooks con ram > 2", 1, notebooks.size());
		
	}

}