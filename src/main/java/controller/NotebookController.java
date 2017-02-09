package controller;

import java.util.TreeMap;

import dao.ResourceDao;
import pojo.Notebook;

public class NotebookController extends ResourceController<Notebook> {

	public NotebookController(ResourceDao<Notebook> resourceDao) {
		super(resourceDao);
	}

	public TreeMap<String,Notebook> getNotebookWithMinRam(int minRam){
		
		TreeMap<String, Notebook> minimumRequirementMap = new TreeMap<String, Notebook>();
		
		TreeMap<String, Notebook> notebooks = findAll();
		
		for(String key : notebooks.keySet()){
			
			Notebook n = notebooks.get(key);
			
			if(n.getRam() >= minRam)
				minimumRequirementMap.put(key, n);
		}
		return minimumRequirementMap;
	}
}
