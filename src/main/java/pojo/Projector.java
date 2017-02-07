package pojo;

import java.io.Serializable;

public class Projector extends Resource implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String brand;
	private String model; 
	private String resolution;
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getResolution() {
		return resolution;
	}
	
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
	
	
	
}
