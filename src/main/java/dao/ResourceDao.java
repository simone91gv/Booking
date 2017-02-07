package dao;

import java.util.TreeMap;

import pojo.Resource;

public interface ResourceDao<T extends Resource> {

	public TreeMap<String, T>  findAll();
	
	public T getById(String id);
	
	public void delete(String id);
	
	public void update(T item);

	public void add(T t);
}
