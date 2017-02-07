package pojo;

import java.io.Serializable;

public class OfficeRoom extends Resource implements Serializable {

	private static final long serialVersionUID = 1L;

	private int capacity;
	private int floor;
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
	
}
