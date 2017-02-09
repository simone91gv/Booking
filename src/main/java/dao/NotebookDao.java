package dao;

import java.util.TreeMap;

import pojo.Notebook;

public class NotebookDao implements ResourceDao<Notebook> {
	
	private TreeMap<String, Notebook> notebooks = new TreeMap<String,Notebook>();
	
	public NotebookDao() {
	
		//inizializza la lista aggiungendo un notebook
		Notebook n1 = new Notebook();
		n1.setId("N000000001");
		n1.setBrand("LENOVO");
		n1.setModel("XSD");
		n1.setDescription("The first business car of the company");
		n1.setHardDiskType("HDD");
		n1.setProcessor("I7 2800Ghz");
		n1.setRam(8);
		n1.setUsb3(true);
		
		//aggiunta alla tree map
		notebooks.put(n1.getId(), n1);
	}

	public Notebook getById(String id) {
		return notebooks.get(id);
	}
	
	public TreeMap<String, Notebook> findAll() {
		return notebooks;
	}
	
	public void delete(String id) {
		notebooks.remove(id);	
	}

	public void update(Notebook item) {
		notebooks.put(item.getId(), item);
	}

	public void add(Notebook item) {
		notebooks.put(item.getId(), item);
	}
	

}
