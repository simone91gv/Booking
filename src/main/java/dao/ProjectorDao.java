package dao;

import java.util.TreeMap;

import pojo.Projector;

public class ProjectorDao implements ResourceDao<Projector> {
	
	private TreeMap<String, Projector> projectors;
	
	public ProjectorDao(){
		
		//inizializza la lista aggiungendo un vehicle
		Projector p1 = new Projector();
		p1.setId("0000000012");
		p1.setBrand("HP");
		p1.setModel("15sq15");
		p1.setResolution("1080dpi");
		p1.setDescription("The first projector of the company");
		
		//aggiunta alla tree map
		projectors.put(p1.getId(), p1);
	}

	public TreeMap<String, Projector> findAll() {
		return projectors;
	}
	
	public Projector getById(String id) {
		return projectors.get(id);
		
	}

	public void delete(String id) {
		projectors.remove(id);
		
	}

	public void update(Projector item) {
		projectors.put(item.getId(), item);
		
	}

	public void add(Projector item) {
		projectors.put(item.getId(), item);		
	}
	
	
}
