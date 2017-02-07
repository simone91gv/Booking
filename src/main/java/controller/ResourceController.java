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
	
	//add a new resource to the tree map
	public void add(T t){
		resourceDao.add(t);
	}
	
	//retrieves all the resources allocated
	public TreeMap<String, T> findAll(){
		return resourceDao.findAll();
	}
	
	//this method tries to retrieve a resource by its id
	//if the resource is present it returns the instance, otherwise returns null 
	public T getById(String id){
		return resourceDao.getById(id);
	}
	
	public void update(T t){
		resourceDao.update(t);
	}
	
	public void delete(String id){
		resourceDao.delete(id);
	}
	
	public ResourceDao<T> getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao<T> resourceDao) {
		this.resourceDao = resourceDao;
	}
	
	
	
	

}
