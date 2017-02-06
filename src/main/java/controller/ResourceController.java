package controller;

import java.util.TreeMap;

import dao.ResourceDao;
import pojo.Resource;

public class ResourceController<T extends Resource> {
	
	private ResourceDao<T> resourceDao;
	
	public ResourceController(ResourceDao<T> resourceDao) {
		super();
		this.resourceDao = resourceDao;
	}
	
	public void add(T t){
		resourceDao.add(t);
	}
	
	public TreeMap<Integer, T> findAll(){
		
		return resourceDao.findAll();
	}
	
	public ResourceDao<T> getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao<T> resourceDao) {
		this.resourceDao = resourceDao;
	}
	
	
	
	

}
