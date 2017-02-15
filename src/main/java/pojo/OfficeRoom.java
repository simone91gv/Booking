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
	
	@Override
	public String toString() {
		return "OfficeRoom [capacity=" + capacity + ", floor=" + floor + ", toString()=" + super.toString() + "]";
	}
	

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfficeRoom other = (OfficeRoom) obj;
		if (capacity != other.capacity)
			return false;
		if (floor != other.floor)
			return false;
		return true;
	}
	
	@Override
	public boolean filterByContraint(int minimum) {
		
		if(capacity >= minimum)
			return true;
		else
			return false;
		
	}
	
	
}
