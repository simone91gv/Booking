package pojo;

import java.io.Serializable;

public class Vehicle extends Resource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String brand;
	private String model;
	private int displacement;
	private String supplyType;
	
	
	public Vehicle() {
		super();
	}


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


	public int getDisplacement() {
		return displacement;
	}


	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getSupplyType() {
		return supplyType;
	}


	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}


	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", model=" + model + ", displacement=" + displacement + ", supplyType="
				+ supplyType + ", getId()=" + getId() + ", getDescription()=" + getDescription() + "]";
	}
	
	


	
	
	
	
	
}
