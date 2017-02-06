package dao;

import java.util.TreeMap;

import pojo.Resource;

public interface ResourceDao<T extends Resource> {

	public TreeMap<Integer, T>  findAll();
	
	public T getById(int id);
	
	public void delete(T item);
	
	public void update(T item);

	public void add(T t);
}
